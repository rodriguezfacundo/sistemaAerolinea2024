package sistemaAutogestion;

import dominio.*;
import tads.Lista;
import tads.Nodo;
import tads.Pila;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> aerolineas;
    private Pila<Cliente> clientes;
    private Lista<Vuelo> vuelos;

    public Sistema() {
        this.aerolineas = new Lista<>();
        this.clientes = new Pila<>(300);
        this.vuelos = new Lista<>();
    }

    @Override
    public Retorno crearSistemaDeAutogestion() {
        this.aerolineas = new Lista<>();
        this.clientes = new Pila<>(300);
        this.vuelos = new Lista<>();
        return Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
        if (this.aerolineas.estaElemento(aerolinea)) {
            return Retorno.error1();
        } else if (cantMaxAviones <= 0) {
            return Retorno.error2();
        } else {
            aerolineas.agregarOrdenado(aerolinea);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nombre, "", 1));
        if (nodoAerolinea == null) {
            return Retorno.error1();
        } else {
            Aerolinea aerolinea = nodoAerolinea.getDato();
            Lista<Avion> avionesAerolinea = aerolinea.getAviones();
            if (!avionesAerolinea.esVacia()) {
                return Retorno.error2();
            } else {
                this.aerolineas.eliminarElemento(aerolinea);
                return Retorno.ok();
            }
        }
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Avion avion = new Avion(codigo, capacidadMax);
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nomAerolinea, "", 1));
        if (nodoAerolinea == null) {
            return Retorno.error3();
        } else if (nodoAerolinea.getDato().getAviones().estaElemento(avion)) {
            return Retorno.error1();
        } else if ((capacidadMax < 9) || (capacidadMax % 3 != 0)) {
            return Retorno.error2();
        } else if (nodoAerolinea.getDato().getAviones().getCantMaxima() == nodoAerolinea.getDato().getAviones().cantidadElementos()) {
            return Retorno.error4();
        } else {
            Aerolinea aerolinea = nodoAerolinea.getDato();
            avion.setAerolinea(aerolinea);
            aerolinea.getAviones().agregarOrdenado(avion);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nomAerolinea, "", 1));
        if (nodoAerolinea == null) {
            return Retorno.error1();
        } else if (!nodoAerolinea.getDato().getAviones().estaElemento(new Avion(codAvion, 1))) {
            return Retorno.error2();
        } else {
            nodoAerolinea.getDato().getAviones().eliminarElemento(new Avion(codAvion, 1));
            return Retorno.ok();
        }
        //Faltaria validar el punto 3 que me parece que podemos hacerlo recien en la segunda entrega
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        if (edad < 0) {
            return Retorno.error1();
        } else if (pasaporte.length() != 7) { //ToDo: Preguntar ...Es con regex?
            return Retorno.error2();
        }
        Cliente nuevo = new Cliente(pasaporte, nombre, edad);
        if (clientes.existeElemento(nuevo)) {
            return Retorno.error3();
        }
        clientes.apilar(nuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {

        if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
            // error 5 – En caso de que las cantidades de pasajes (de cualquiera de las categorías) no sea
            // múltiplo de 3.
            return Retorno.error5();
        } else if (cantPasajesEcon < 3 || cantPasajesPClase < 3) {
            return Retorno.error6();// 6 - En caso de que la suma de los pasajes de ambas categorías supere la cant. máxima permitida por el avión.
        }
        Vuelo nuevo = new Vuelo(codigoVuelo, aerolinea, codAvion, paisDestino, dia, mes, anio, cantPasajesEcon, cantPasajesPClase);
        Aerolinea aero = aerolineas.obtenerElemento(new Aerolinea(aerolinea, " ", 0)).getDato();
        Avion avion = aero.getAviones().obtenerElemento(new Avion(codAvion, 0, aero)).getDato();

        if (vuelos.estaElemento(nuevo)) {    // 1.- En caso de que ya exista el código de vuelo en el sistema
            return Retorno.error1();
        } else if (aero == null) { // 2. - En caso de que la aerolínea no exista en el sistema.
            return Retorno.error2();
        } else if (avion == null) { // 3.- En caso de que el código de avión no exista dentro de la aerolínea.
            return Retorno.error3();
        } else if (avion.disponibilidad(dia, mes, anio)) {
            return Retorno.error4();// 4 - En caso de que ya exista un vuelo creado para ese avión en dicha fecha.
        }

        if (cantPasajesPClase + cantPasajesEcon > avion.getCapacidadMax()) {
            return Retorno.error6();
        } else {
            vuelos.agregarFinal(nuevo);
            return Retorno.ok();
        }
        //Descripción: Se crea el vuelo en el sistema. Todos los vuelos salen en un único horario 
        //(no será necesario verificar la correctitud de la fecha ingresada).
        //Se deberá indicar cuantos pasajes de categoría económica (tipo 1) y cuantos de primera clase (tipo 2) se ponen a la venta.
        //Las cantidades de cada categoría de pasaje debe ser >=3 y múltiplo de 3.
        //En caso de que la suma de la cantidad de pasajes de ambas categorías no cubra el total
        //de pasajes disponibles, se completará el vuelo con pasajes de categoría económica hasta cubrir el total de capacidad del avión.
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {

        Cliente c = new Cliente(pasaporteCliente, "", 0);
        if (!clientes.existeElemento(c)) {
            return Retorno.error1();
        }

        Vuelo v = new Vuelo(codigoVuelo, "", "", "", 0, 0, 0, 0, 0);
        if (!vuelos.estaElemento(v)) {
            return Retorno.error2();
        }

        c = clientes.ObtenerElemento(c).getDato();
        v = vuelos.obtenerElemento(v).getDato();

        Pasaje p = new Pasaje(c, v, categoríaPasaje);
        if (v.disponibilidad(categoríaPasaje)) {//  En caso de existir disponibilidad para dicha categoría (1-económica, 2-Primera Clase),
            v.emitirPasaje(p);//  se emite el pasaje para dicho cliente.
            return Retorno.ok();
        } else {
            v.dejarPendiente(p);  //En caso de no existir disponibilidad para la categoría seleccionada, la emisión del pasaje quedará en estado pendiente 
            return Retorno.ok();
        }
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Cliente c = new Cliente(pasaporteCliente, "", 0);
        if (!clientes.existeElemento(c)) {
            return Retorno.error1();//error1.- En caso de que exista el pasaporte del cliente
        }
        Vuelo v = new Vuelo(codigoVuelo, "", "", "", 0, 0, 0, 0, 0);
        if (!vuelos.estaElemento(v)) {
            return Retorno.error2();// error 2.- En caso de que no exista el código de vuelo
        }

        c = clientes.ObtenerElemento(c).getDato();
        v = vuelos.obtenerElemento(v).getDato();

        if (v.obtenerCompra(c) == null) {
            return Retorno.error3();// error 3 – En caso de que no exista una compra del cliente para dicho vuelo
        }
        Pasaje p = v.obtenerCompra(c);
        v.devolver(p);//Se realiza la devolución del pasaje comprado anteriormente por el cliente. 
        return Retorno.ok();

    }

    @Override
    public Retorno listarAerolineas() {
        //aerolineas.mostrar();
        Retorno ret = Retorno.ok();
        Nodo<Aerolinea> aux = aerolineas.getInicio();
        ret.valorString = "";
        while (aux != null) {
            if (aux.getSiguiente() != null) {
                ret.valorString += aux.getDato().toString() + '\n';
            } else {
                ret.valorString += aux.getDato().toString();
            }
            aux = aux.getSiguiente();

        }
        return ret;
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Retorno ret = Retorno.ok();
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nombre, "", 1));
        ret.valorString = "";
        if (nodoAerolinea != null) {
            Aerolinea aerolinea = nodoAerolinea.getDato();
            Lista<Avion> aviones = aerolinea.getAviones();
            Nodo<Avion> aux = aviones.getInicio();
            while (aux != null) {
                if (aux.getSiguiente() != null) {
                    ret.valorString += aux.getDato().toString() + '\n';
                } else {
                    ret.valorString += aux.getDato().toString();
                }
                aux = aux.getSiguiente();
            }
        } else {
            ret = Retorno.error1();
        }
        return ret;
    }

    @Override
    public Retorno listarClientes() {
        return Retorno.ok(clientes.imprimirPila());
    }

    @Override
    public Retorno listarVuelos() {
        Retorno ret = Retorno.ok("");
        Nodo<Vuelo> aux = vuelos.getInicio();
        while (aux != null) {
            if (aux.getSiguiente() != null) {
                ret.valorString += aux.getDato().toString() + '\n';
            } else {
                ret.valorString += aux.getDato().toString();
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        Retorno ret = Retorno.ok("");
        
        return ret;
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        return null;
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return null;
    }
}

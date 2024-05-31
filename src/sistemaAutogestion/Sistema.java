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
        }
        Avion avion = nodoAerolinea.getDato().getAviones().obtenerElemento(new Avion(codAvion, 1)).getDato();
        if (avion == null) {
            return Retorno.error2();
        }
        if(avion.isTieneViajeVendido()){
            return Retorno.error3();
        }
        else {
            nodoAerolinea.getDato().getAviones().eliminarElemento(new Avion(codAvion, 1));
            return Retorno.ok();
        }
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
        Aerolinea aero = aerolineas.obtenerElemento(new Aerolinea(aerolinea, " ", 0)).getDato();
        Avion avion = aero.getAviones().obtenerElemento(new Avion(codAvion, 0, aero)).getDato();

        if(aero == null){
             return Retorno.error2();
        }
        if(avion == null){
            return Retorno.error3();
        }
        if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
            return Retorno.error5();
        }  
        if( cantPasajesPClase + cantPasajesEcon > avion.getCapacidadMax()){
            return Retorno.error6();
        }
        if (avion.disponibilidad(dia, mes, anio)) {
            return Retorno.error4();
        }
        Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aero, avion, paisDestino, dia, mes, anio, cantPasajesEcon, cantPasajesPClase);
        if (vuelos.estaElemento(nuevoVuelo)) {
            return Retorno.error1();
        } 
         else {
            vuelos.agregarFinal(nuevoVuelo);
            avion.getVuelos().agregarFinal(nuevoVuelo);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {

        Cliente cliente = this.clientes.ObtenerElemento(new Cliente(pasaporteCliente, "", 0)).getDato();
        Vuelo vuelo = new Vuelo(codigoVuelo, null, null, "", 0, 0, 0, 0, 0);
        if (!clientes.existeElemento(cliente)) {
            return Retorno.error1();
        }
        if (!vuelos.estaElemento(vuelo)) {
            return Retorno.error2();
        }
        Pasaje pasaje = new Pasaje(cliente, vuelo, categoríaPasaje);
        if (vuelo.disponibilidad(categoríaPasaje)) {
            vuelo.emitirPasaje(pasaje);
            cliente.getPasajesComprados().agregarFinal(pasaje);
            vuelo.getAvion().setTieneViajeVendido(true);
            return Retorno.ok();
        } else {
            vuelo.dejarPendiente(pasaje);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Cliente cliente = this.clientes.ObtenerElemento(new Cliente(pasaporteCliente, "", 0)).getDato();
        if (cliente == null) {
            return Retorno.error1();
        }
        Vuelo vuelo = this.vuelos.obtenerElemento(new Vuelo(codigoVuelo, null,null, "", 0, 0, 0, 0, 0)).getDato();
        if (vuelo == null) {
            return Retorno.error2();
        }
        Pasaje pasaje = vuelo.obtenerCompra(cliente);
        if (pasaje == null) {
            return Retorno.error3();// error 3 – En caso de que no exista una compra del cliente para dicho vuelo
        } else{
             vuelo.devolver(pasaje);//Se realiza la devolución del pasaje comprado anteriormente por el cliente. 
            return Retorno.ok();   
        }
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

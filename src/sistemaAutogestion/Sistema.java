package sistemaAutogestion;

import dominio.*;
import sistemaAutogestion.Retorno.Resultado;
import tads.Lista;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> aerolineas;
    private Lista<Cliente> clientes;
    private Lista<Vuelo> vuelos;

    public Sistema() {
        this.aerolineas = new Lista<>();
        this.clientes = new Lista<>(300);
        this.vuelos = new Lista<>();
    }

    @Override
    public Retorno crearSistemaDeAutogestion() {
        this.aerolineas = new Lista<>();
        this.clientes = new Lista<>(300);
        this.vuelos = new Lista<>();
        return Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
        if (this.aerolineas.obtenerElemento(aerolinea) != null) {
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
        } else if (nodoAerolinea.getDato().getAviones().obtenerElemento(avion) != null) {
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
        Nodo<Avion> nodoAvion = nodoAerolinea.getDato().getAviones().obtenerElemento(new Avion(codAvion, 1));
        if (nodoAvion == null) {
            return Retorno.error2();
        }
        if(nodoAvion.getDato().isTieneViajeVendido()){
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
        } else if (pasaporte.length() != 7) {
            return Retorno.error2();
        }
        Cliente nuevo = new Cliente(pasaporte, nombre, edad);
        if (clientes.estaElemento(nuevo)) {
            return Retorno.error3();
        }
        clientes.agregarInicio(nuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        Nodo<Aerolinea> nodoAerolinea = aerolineas.obtenerElemento(new Aerolinea(aerolinea, " ", 0));
        if(nodoAerolinea == null){
             return Retorno.error2();
        }
        Aerolinea aerolineaElegida = nodoAerolinea.getDato();
        Nodo<Avion> nodoAvion = aerolineaElegida.getAviones().obtenerElemento(new Avion(codAvion, 0));
        if(nodoAvion == null){
            return Retorno.error3();
        }
        if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
            return Retorno.error5();
        }  
        Avion avion = nodoAvion.getDato();
        if( cantPasajesPClase + cantPasajesEcon > avion.getCapacidadMax()){
            return Retorno.error6();
        }
        Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aerolineaElegida, avion, paisDestino, dia, mes, anio, cantPasajesEcon, cantPasajesPClase);
        if (vuelos.obtenerElemento(nuevoVuelo) != null) {
            return Retorno.error1();
        } 
        if (avion.getVuelos().estaElemento(nuevoVuelo)){
            return Retorno.error4();
        }
         else {
            this. vuelos.agregarFinal(nuevoVuelo);
            avion.getVuelos().agregarFinal(nuevoVuelo);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {

        Nodo<Cliente> nodoCliente = this.clientes.obtenerElemento(new Cliente(pasaporteCliente, "", 0));
        Nodo<Vuelo> nodoVuelo = this.vuelos.obtenerElemento(new Vuelo(codigoVuelo, null, null, "", 0, 0, 0, 0, 0));
        if (nodoCliente == null) {
            return Retorno.error1();
        }
        if (nodoVuelo == null) {
            return Retorno.error2();
        }
        Cliente cliente = nodoCliente.getDato();
        Vuelo vuelo = nodoVuelo.getDato();
        Pasaje pasaje = new Pasaje(cliente, vuelo, categoríaPasaje);
        if (vuelo.disponibilidad(categoríaPasaje)) {
            vuelo.emitirPasaje(pasaje);
            vuelo.getAvion().setTieneViajeVendido(true);
            return Retorno.ok();
        } else {
            vuelo.dejarPendiente(pasaje);
            cliente.getPasajesComprados().agregarFinal(pasaje);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Nodo<Cliente> nodoCliente = this.clientes.obtenerElemento(new Cliente(pasaporteCliente, "", 0));
        if (nodoCliente == null) {
            return Retorno.error1();
        }
        Nodo<Vuelo> nodoVuelo = this.vuelos.obtenerElemento(new Vuelo(codigoVuelo, null,null, "", 0, 0, 0, 0, 0));
        if (nodoVuelo == null) {
            return Retorno.error2();
        }
        Cliente cliente = nodoCliente.getDato();
        Vuelo vuelo = nodoVuelo.getDato();
        Nodo<Pasaje> nodoPasaje = vuelo.obtenerCompra(cliente);
        if (nodoPasaje == null) {
            return Retorno.error3();
        } else{
            Pasaje pasaje = nodoPasaje.getDato();
             vuelo.devolver(pasaje);
             
            //Actualizo ese pasaje viejo que tenia estado CPR a estado DEV para luego mostrarlo en el listado pasajes comprados de cliente
             Pasaje pasajeActualizado = new Pasaje(pasaje.getCliente(), pasaje.getVuelo(), pasaje.getCategoriaPasaje());
             pasajeActualizado.setEsDevuelto(true);
             cliente.getPasajesComprados().reemplazar(pasaje, pasajeActualizado);
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
        return new Retorno(Resultado.OK,  this.clientes.mostrarRecString(this.clientes.getInicio()));
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
        Nodo<Cliente> nodoCliente = this.clientes.obtenerElemento(new Cliente(pasaporte, "", 0));
        if(nodoCliente == null){
            return Retorno.error1();
        } else{
            return new Retorno(Resultado.OK,  nodoCliente.getDato().getPasajesComprados().mostrarRecString(nodoCliente.getDato().getPasajesComprados().getInicio()));
        }
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nombreAerolinea, "", 0));
        if(nodoAerolinea == null){
            return Retorno.error1();
        } else{
            Retorno ret = Retorno.ok("");
            Nodo<Pasaje> aux = nodoAerolinea.getDato().getPasajesDevueltos().getInicio();
            while (aux != null) {
                if (aux.getSiguiente() != null) {
                    ret.valorString += aux.getDato().getCliente().getPasaporte() + "-" + aux.getDato().getVuelo().getCodigoVuelo() + "|" +'\n';
                } else {
                    ret.valorString += aux.getDato().getCliente().getPasaporte() + "-" + aux.getDato().getVuelo().getCodigoVuelo() + "|";
                }
                aux = aux.getSiguiente();
            }
            return ret;
        }
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return null;
    }
}

package sistemaAutogestion;

import dominio.*;
import tads.Lista;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> aerolineas;
    private Lista<Cliente> clientes;
    private Lista<Pasaje> pasajes;
    private Lista<Vuelo> vuelos;


    @Override
    public Retorno crearSistemaDeAutogestion() {
        this.aerolineas = new Lista<Aerolinea>();
        this.clientes = new Lista<Cliente>();
        this.pasajes = new Lista<Pasaje>();
        this.vuelos = new Lista<Vuelo>();
        return  Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
        if(this.aerolineas.estaElemento(aerolinea)){
            return Retorno.error1();
        } else if(cantMaxAviones <=0){
            return Retorno.error2();
        } else{
            aerolinea.setCantMaxAviones(cantMaxAviones);
            aerolineas.agregarOrdenado(aerolinea);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nombre, "", 1));
        if(nodoAerolinea == null){
            return Retorno.error1();
        } else{
            Aerolinea aerolinea = nodoAerolinea.getDato();
            Lista<Avion> avionesAerolinea = aerolinea.getAviones();
            if(!avionesAerolinea.esVacia()){
                return Retorno.error2();
            } else{
                this.aerolineas.eliminarElemento(aerolinea);
                return Retorno.ok();
            }
        }
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Avion avion = new Avion(codigo, capacidadMax, nomAerolinea);
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nomAerolinea, "", 1));
        if(nodoAerolinea == null){
            return Retorno.error3();
        } else if(nodoAerolinea.getDato().getAviones().estaElemento(avion)){
            return Retorno.error1();
        } else if ((capacidadMax < 9) || (capacidadMax % 3 != 0)) {
            return Retorno.error2();
        } else if(nodoAerolinea.getDato().getCantMaxAviones() == 0){
            return Retorno.error4();
        } else{
            Aerolinea aerolinea = nodoAerolinea.getDato();
            aerolinea.setCantMaxAviones(aerolinea.getCantMaxAviones() - 1);
            aerolinea.getAviones().agregarFinal(avion);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nomAerolinea, "", 1));
        if(nodoAerolinea == null){
            return Retorno.error1();
        } else if(!nodoAerolinea.getDato().getAviones().estaElemento(new Avion(codAvion, 1, nomAerolinea))) {
            return Retorno.error2();
        } else{
            nodoAerolinea.getDato().getAviones().eliminarElemento(new Avion(codAvion, 1, nomAerolinea));
            return Retorno.ok();
        }
        //Faltaria validar el punto 3 que me parece que podemos hacerlo recien en la segunda entrega
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        return null;
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        return null;
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        return null;
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        return null;
    }

    @Override
    public Retorno listarAerolineas() {
        if (!aerolineas.esVacia()) {
            aerolineas.mostrar();
            return Retorno.ok();
        } else{
            //Me parece que en la letra no dice nada de validar si hay aerolineas o no, pero por las dudas meti esta
            //validacion.
            return Retorno.error1();
        }
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Nodo<Aerolinea> nodoAerolinea = this.aerolineas.obtenerElemento(new Aerolinea(nombre, "", 1));
        if (nodoAerolinea != null){
            Aerolinea a = nodoAerolinea.getDato();
            Lista<Avion> aviones = a.getAviones();
            aviones.mostrar();
            return Retorno.ok();
        }else{
            return Retorno.error1();
        }
    }

    @Override
    public Retorno listarClientes() {
        return null;
    }

    @Override
    public Retorno listarVuelos() {
        return null;
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        return null;
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

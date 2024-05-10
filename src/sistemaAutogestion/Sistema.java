package sistemaAutogestion;

import dominio.*;
import tads.Lista;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> aerolineas;
    private Lista<Cliente> clientes;//Seguramente se cambie a pila.
    private Lista<Vuelo> vuelos;

    public Sistema() {
        this.aerolineas = new Lista<>();
        this.clientes = new Lista<>();
        this.vuelos = new Lista<>();
    }

    @Override
    public Retorno crearSistemaDeAutogestion() {
        this.aerolineas = new Lista<>();
        this.clientes = new Lista<>();
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

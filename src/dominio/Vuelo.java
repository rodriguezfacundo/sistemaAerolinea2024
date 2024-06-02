package dominio;

import tads.Cola;
import tads.Lista;
import tads.Nodo;

public class Vuelo implements Comparable<Vuelo> {
    private String codigoVuelo;
    private Aerolinea aerolinea;
    private Avion avion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private Lista<Pasaje> pasajesEconomicosEmitidos;
    private Lista<Pasaje> pasajesPrimeraClaseEmitidos;
    private Cola<Pasaje> pasajesPrimeraClasePendientes;
    private Cola<Pasaje> pasajesEconomicosPendientes;
    private Cola<Cliente> clientesEnEspera;
    private Lista<Pasaje> pasajesDevueltos;

    public Vuelo(String codigoVuelo, Aerolinea aerolinea, Avion avion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.aerolinea = aerolinea;
        this.avion = avion;
        this.pasajesEconomicosEmitidos = new Lista<>(cantPasajesEcon);
        this.pasajesPrimeraClaseEmitidos = new Lista<>(cantPasajesPClase);
        this.pasajesEconomicosPendientes = new Cola<>();
        this.pasajesPrimeraClasePendientes = new Cola<>();
        this.clientesEnEspera = new Cola<>(); //todo: ver para que es esto
        this.pasajesDevueltos = new Lista<>();
    }

    public Lista<Pasaje> getPasajesEconomicosEmitidos() {
        return pasajesEconomicosEmitidos;
    }

    public void setPasajesEconomicosEmitidos(Lista<Pasaje> pasajesEconomicosEmitidos) {
        this.pasajesEconomicosEmitidos = pasajesEconomicosEmitidos;
    }

    public Lista<Pasaje> getPasajesPrimeraClaseEmitidos() {
        return pasajesPrimeraClaseEmitidos;
    }

    public void setPasajesPrimeraClaseEmitidos(Lista<Pasaje> pasajesPrimeraClaseEmitidos) {
        this.pasajesPrimeraClaseEmitidos = pasajesPrimeraClaseEmitidos;
    }

    public Cola<Pasaje> getPasajesPrimeraClasePendientes() {
        return pasajesPrimeraClasePendientes;
    }

    public void setPasajesPrimeraClasePendientes(Cola<Pasaje> pasajesPrimeraClasePendientes) {
        this.pasajesPrimeraClasePendientes = pasajesPrimeraClasePendientes;
    }

    public Cola<Pasaje> getPasajesEconomicosPendientes() {
        return pasajesEconomicosPendientes;
    }

    public void setPasajesEconomicosPendientes(Cola<Pasaje> pasajesEconomicosPendientes) {
        this.pasajesEconomicosPendientes = pasajesEconomicosPendientes;
    }

    public Lista<Pasaje> getPasajesDevueltos() {
        return pasajesDevueltos;
    }

    public void setPasajesDevueltos(Lista<Pasaje> pasajesDevueltos) {
        this.pasajesDevueltos = pasajesDevueltos;
    }

    @Override
    public int compareTo(Vuelo v) {
    if (this.codigoVuelo == v.codigoVuelo) {
        return 0;
    }
    else{
        return -1;
    }
    }
    
   @Override
    public boolean equals(Object v) {
        Vuelo vuelo = (Vuelo) v;
        if (this.dia == vuelo.dia && this.mes == vuelo.mes && this.anio == vuelo.anio){
            return true;
        }else{
            return false;
        }
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    public int cantDisponible(){
        int cantidad = pasajesEconomicosEmitidos.getCantMaxima() - pasajesEconomicosEmitidos.cantidadElementos();
        cantidad += pasajesPrimeraClaseEmitidos.getCantMaxima() - pasajesPrimeraClaseEmitidos.cantidadElementos();
        return cantidad;
    }

    @Override
    public String toString() {
        return  codigoVuelo + '-'
                + aerolinea.getNombre() + '-'
                + avion.getCodigo() + '-'
                + pasajesEconomicosEmitidos.cantidadElementos()+ '-'
                + pasajesPrimeraClaseEmitidos.cantidadElementos() + '-'
                + cantDisponible() +'|';
    }

    public boolean disponibilidad(int categoriaPasaje) {
        boolean r = false;
        int cantidadPasajesVendidos = 0;
        int cantidadMaximaPermitida = 0;
        if (categoriaPasaje == 1) {
            cantidadPasajesVendidos = pasajesEconomicosEmitidos.cantidadElementos();
            cantidadMaximaPermitida = pasajesEconomicosEmitidos.getCantMaxima();
            r = cantidadPasajesVendidos < cantidadMaximaPermitida;
        }
        if (categoriaPasaje == 2) {
            cantidadPasajesVendidos = pasajesPrimeraClaseEmitidos.cantidadElementos();
            cantidadMaximaPermitida = pasajesPrimeraClaseEmitidos.getCantMaxima();
             r = cantidadPasajesVendidos < cantidadMaximaPermitida;
        }
        return r;
    }

    public void emitirPasaje(Pasaje p) {
        if (p.getCategoriaPasaje() == 1) {
            p.setEsDevuelto(false);
            pasajesEconomicosEmitidos.agregarInicio(p);
        } else if (p.getCategoriaPasaje() == 2) {
            p.setEsDevuelto(false);
            pasajesPrimeraClaseEmitidos.agregarInicio(p);
        }
        p.getCliente().agregarCompra(p);
    }

    public void dejarPendiente(Pasaje p) {
        if (p.getCategoriaPasaje() == 1) {
            p.setEsDevuelto(false);
            pasajesEconomicosPendientes.encolar(p);

        } else if (p.getCategoriaPasaje() == 2) {
            p.setEsDevuelto(false);
            pasajesPrimeraClasePendientes.encolar(p);
        }
    }

    public Nodo<Pasaje> obtenerCompra(Cliente c) {
        
        Pasaje p = new Pasaje(c, this, 2);
        if (pasajesPrimeraClaseEmitidos.obtenerElemento(p)!=null) {
            return pasajesPrimeraClaseEmitidos.obtenerElemento(p);
        }
        p = new Pasaje(c, this, 1);
        if (pasajesEconomicosEmitidos.obtenerElemento(p) != null) {
            return pasajesEconomicosEmitidos.obtenerElemento(p);
        }
        return null;
    }

    public void devolver(Pasaje p) {
        if(p.getCategoriaPasaje() == 2){
            pasajesPrimeraClaseEmitidos.eliminarElemento(p);//Se realiza la devolución del pasaje comprado anteriormente por el cliente. 
            if(!this.pasajesPrimeraClasePendientes.esVacia()){
                Pasaje pasajeEnEspera = pasajesPrimeraClasePendientes.frente().getDato();
                pasajesPrimeraClaseEmitidos.agregarOrdenado(pasajeEnEspera); //En caso de existir clientes en lista de espera, se le otorgará el pasaje al primero de la lista.
                pasajesPrimeraClasePendientes.desencolar();   
            }
            p.getVuelo().getAerolinea().getPasajesDevueltos().agregarInicio(p);
        }else if(p.getCategoriaPasaje() == 1){
            pasajesEconomicosEmitidos.eliminarElemento(p);
            if(this.pasajesEconomicosPendientes.esVacia()){
                Pasaje pasajeEnEspera = pasajesEconomicosPendientes.frente().getDato();
                pasajesEconomicosEmitidos.agregarOrdenado(pasajeEnEspera);
                pasajesEconomicosPendientes.desencolar();   
            }
            p.getVuelo().getAerolinea().getPasajesDevueltos().agregarInicio(p);
        }
    }
    
}

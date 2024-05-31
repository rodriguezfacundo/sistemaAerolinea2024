package dominio;

import tads.Cola;
import tads.Lista;

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
    public int compareTo(Vuelo o) {
        return 0;
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
        if (categoriaPasaje == 1) {
            r = pasajesEconomicosEmitidos.cantidadElementos() < pasajesEconomicosEmitidos.getCantMaxima();
        }
        if (categoriaPasaje == 2) {
            r = pasajesPrimeraClaseEmitidos.cantidadElementos() < pasajesPrimeraClaseEmitidos.getCantMaxima();
        }
        return r;
    }

    public void emitirPasaje(Pasaje p) {
        if (p.getCategoriaPasaje() == 1) {
            pasajesEconomicosEmitidos.agregarInicio(p);
        } else if (p.getCategoriaPasaje() == 2) {
            pasajesPrimeraClaseEmitidos.agregarInicio(p);
        }
        p.getCliente().agregarCompra(p);
    }

    public void dejarPendiente(Pasaje p) {
        if (p.getCategoriaPasaje() == 1) {
            pasajesEconomicosPendientes.encolar(p);
        } else if (p.getCategoriaPasaje() == 2) {
            pasajesPrimeraClasePendientes.encolar(p);
        }
    }

    public Pasaje obtenerCompra(Cliente c) {
        
        Pasaje p = new Pasaje(c, this, 2);
        if (pasajesPrimeraClaseEmitidos.estaElemento(p)) {
            return pasajesPrimeraClaseEmitidos.obtenerElemento(p).getDato();
        }
        p = new Pasaje(c, this, 1);
        if (pasajesEconomicosEmitidos.estaElemento(p)) {
            return pasajesEconomicosEmitidos.obtenerElemento(p).getDato();
        }

        return null;
    }

    public void devolver(Pasaje p) {
        if(p.getCategoriaPasaje() == 1){
            pasajesPrimeraClaseEmitidos.eliminarElemento(p);//Se realiza la devolución del pasaje comprado anteriormente por el cliente. 
            
            Pasaje pasajeEnEspera = pasajesPrimeraClasePendientes.frente().getDato();
            pasajesPrimeraClaseEmitidos.agregarOrdenado(pasajeEnEspera); //En caso de existir clientes en lista de espera, se le otorgará el pasaje al primero de la lista.
            pasajesPrimeraClasePendientes.desencolar();
            
        }else if(p.getCategoriaPasaje() == 2){
            pasajesEconomicosEmitidos.eliminarElemento(p);
            Pasaje pasajeEnEspera = pasajesEconomicosPendientes.frente().getDato();
            pasajesEconomicosEmitidos.agregarOrdenado(pasajeEnEspera);
            pasajesEconomicosPendientes.desencolar();
        }
        p.getCliente().devolverPasaje(p);//se agrega a la lista de devueltos del Cliente
        
        
    }
}

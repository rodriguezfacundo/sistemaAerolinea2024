package dominio;

import tads.ListaVuelo;

public class Avion implements Comparable<Avion> {
    private String codigo;
    private int capacidadMax;
    private Aerolinea aerolinea;
    private ListaVuelo<Vuelo> vuelos = new ListaVuelo<>();
    private boolean tieneViajeVendido;

     public Avion(String codigo, int capacidadMax, Aerolinea aerolinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.aerolinea = aerolinea;
        this.tieneViajeVendido = false;
    }

    public Avion(String codigo, int capacidadMax) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
    }
    
    public boolean isTieneViajeVendido() {
        return tieneViajeVendido;
    }

    public void setTieneViajeVendido(boolean tieneViajeVendido) {
        this.tieneViajeVendido = tieneViajeVendido;
    }

    @Override
    public int compareTo(Avion o) {
        return this.codigo.compareTo(o.codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public Aerolinea getAerolinea() {
        return this.aerolinea;
    }

    public void setAerolinea(Aerolinea a) {
        this.aerolinea = a;
    }
    @Override
    public String toString() {
        return codigo + '-' + capacidadMax + '|';
    }
    
    public ListaVuelo<Vuelo> getVuelos() {
        return vuelos;
    }

    public boolean disponibilidad(int dia, int mes, int anio) {
        boolean r = true;
        if(this.vuelos.obtenerPorFecha(dia,mes,anio)!= null) return false;
        return r;
    }
    
    

}

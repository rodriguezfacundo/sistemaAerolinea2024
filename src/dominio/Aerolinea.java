package dominio;

import tads.Lista;

public class Aerolinea implements Comparable<Aerolinea> {
    private String nombre;
    private String pais;
    private Lista<Avion> aviones;
    private Lista<Pasaje> pasajesDevueltos;

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.aviones = new Lista<>(cantMaxAviones);
        this.pasajesDevueltos = new Lista<>();
    }


    @Override
    public int compareTo(Aerolinea o) {
        return this.nombre.compareTo(o.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }



    public Lista<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Lista<Avion> aviones) {
        this.aviones = aviones;
    }

    public Lista<Pasaje> getPasajesDevueltos(){
        return this.pasajesDevueltos;
    }
    @Override
    public String toString() {
        return nombre +'-'+ pais + '-' + aviones.getCantMaxima() +'|';
    }

}

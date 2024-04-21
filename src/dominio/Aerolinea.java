package dominio;

import tads.Lista;

public class Aerolinea implements Comparable<Aerolinea> {
    private String nombre;
    private String pais;
    private int cantMaxAviones;
    private Lista<Avion> aviones = new Lista<>();

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        this.aviones = new Lista<Avion>();
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

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }

    public Lista<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(Lista<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public String toString() {
        return "Aerolinea{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", cantMaxAviones=" + cantMaxAviones +
                '}';
    }
}

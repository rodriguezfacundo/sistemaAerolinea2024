package dominio;

import tads.Lista;


public class Cliente implements Comparable<Cliente> {
    private String pasaporte;
    private String nombre;
    private int edad;
    private Lista<Pasaje> pasajesComprados;
    private Lista<Pasaje> pasajesDevueltos;

    @Override
    public String toString() {
        return pasaporte + '-' + nombre + '-' + + edad + '|';
    }

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
        this.pasajesComprados = new Lista<>();
        this.pasajesDevueltos = new Lista<>();
    }

    @Override
    public int compareTo(Cliente c) {
        return this.pasaporte.compareTo(c.pasaporte);
    }
    
    @Override
    public boolean equals(Object c){
        Cliente cliente = (Cliente)c;
        if(this.pasaporte == cliente.getPasaporte()){
            return true;
        } else{
            return false;
        }
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Lista<Pasaje> getPasajesDevueltos() {
        return this.pasajesDevueltos;
    }
    
    public Lista<Pasaje> getPasajesComprados(){
        return this.pasajesComprados;
    }

    public void setPasajesDevueltos(Lista<Pasaje> pasajes) {
        this.pasajesDevueltos = pasajes;
    }
    
    public void devolverPasaje(Pasaje p) {
        pasajesDevueltos.agregarFinal(p);
    }

    void agregarCompra(Pasaje p) {
        p.setEsDevuelto(false);
        pasajesComprados.agregarInicio(p);
    }

    public void actualizarPasajeComprado(Pasaje pasaje) {
        this.pasajesComprados.eliminarElemento(pasaje);
        pasaje.setEsDevuelto(true);
        this.pasajesComprados.agregarFinal(pasaje);
    }
}

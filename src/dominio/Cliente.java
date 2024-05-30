package dominio;

import tads.Lista;


public class Cliente implements Comparable<Cliente> {
    private String pasaporte;
    private String nombre;
    private int edad;
    private Lista<Pasaje> pasajesComprados;//tal vez cambiemos a pila en un futuro
    private Lista<Pasaje> pasajesDevueltos;

    @Override
    public String toString() {
        return "Cliente{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
        this.pasajesComprados = new Lista<>();
        this.pasajesDevueltos = new Lista<>();
    }

    @Override
    public int compareTo(Cliente o) {
        return 0;
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
        return pasajesDevueltos;
    }

    public void setPasajesDevueltos(Lista<Pasaje> pasajes) {
        this.pasajesDevueltos = pasajes;
    }
    
    public void devolverPasaje(Pasaje p) {
        pasajesDevueltos.agregarFinal(p);
    }

    void agregarCompra(Pasaje p) {
        pasajesComprados.agregarFinal(p);
    }
}

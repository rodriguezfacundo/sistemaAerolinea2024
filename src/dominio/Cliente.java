package dominio;

public class Cliente implements Comparable<Cliente> {
    private String pasaporte;
    private String nombre;
    private int edad;

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
}

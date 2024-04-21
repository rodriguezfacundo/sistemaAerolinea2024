package dominio;

public class Piloto implements Comparable<Piloto> {
    private String nombre;

    public Piloto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Piloto p) {
        return this.nombre.compareTo(p.nombre);
    }

}

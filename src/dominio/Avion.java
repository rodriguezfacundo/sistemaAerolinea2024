package dominio;
public class Avion implements Comparable<Avion> {
    private String codigo;
    private int capacidadMax;
    private Aerolinea aerolinea;

    @Override
    public String toString() {
        return "Avion{" +
                "codigo='" + codigo + '\'' +
                ", capacidadMax=" + capacidadMax +
                ", nomAerolinea='" + aerolinea.getNombre() + '\'' +
                '}';
    }

    public Avion(String codigo, int capacidadMax, Aerolinea aerolinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.aerolinea = aerolinea;
    }

    public Avion(String codigo, int capacidadMax) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
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
}

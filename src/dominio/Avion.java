package dominio;

public class Avion implements Comparable<Avion> {
    private String codigo;
    private int capacidadMax;
    private String nomAerolinea;

    @Override
    public String toString() {
        return "Avion{" +
                "codigo='" + codigo + '\'' +
                ", capacidadMax=" + capacidadMax +
                ", nomAerolinea='" + nomAerolinea + '\'' +
                '}';
    }

    public Avion(String codigo, int capacidadMax, String nomAerolinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.nomAerolinea = nomAerolinea;
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

    public String getNomAerolinea() {
        return nomAerolinea;
    }

    public void setNomAerolinea(String nomAerolinea) {
        this.nomAerolinea = nomAerolinea;
    }
}

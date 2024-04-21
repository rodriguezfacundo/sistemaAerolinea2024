package dominio;

public class Pasaje implements Comparable<Pasaje> {
    private String pasaporteCliente;
    private String codigoVuelo;
    private int categoriaPasaje;

    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    @Override
    public int compareTo(Pasaje o) {
        return 0;
    }

    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }

    @Override
    public String toString() {
        return "Pasaje{" +
                "pasaporteCliente='" + pasaporteCliente + '\'' +
                ", codigoVuelo='" + codigoVuelo + '\'' +
                ", categoriaPasaje=" + categoriaPasaje +
                '}';
    }
}

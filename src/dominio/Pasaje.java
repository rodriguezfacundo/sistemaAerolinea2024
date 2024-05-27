package dominio;

public class Pasaje implements Comparable<Pasaje> {
    private Cliente cliente;
    private Vuelo vuelo;
    private int categoriaPasaje;

    public Pasaje(Cliente cliente, Vuelo vuelo, int categoriaPasaje) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    @Override
    public int compareTo(Pasaje o) {
        return 0;
    }

    public int getCategoriaPasaje() {
        return categoriaPasaje;
    }

    public void setCategoriaPasaje(int categoriaPasaje) {
        this.categoriaPasaje = categoriaPasaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public String toString() {
        return "Pasaje{" +
                "cliente=" + cliente.getNombre() +
                ", vuelo=" + vuelo.getCodigoVuelo() +
                ", categoriaPasaje=" + categoriaPasaje +
                '}';
    }
}

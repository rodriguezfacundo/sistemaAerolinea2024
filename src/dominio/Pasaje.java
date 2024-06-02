package dominio;

public class Pasaje implements Comparable<Pasaje> {
    private Cliente cliente;
    private Vuelo vuelo;
    private int categoriaPasaje;
    private boolean  esDevuelto;

    public Pasaje(Cliente cliente, Vuelo vuelo, int categoriaPasaje) {
        this.cliente = cliente;
        this.vuelo = vuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    @Override
    public int compareTo(Pasaje p) {
        if((this.cliente.getPasaporte() == p.getCliente().getPasaporte() && this.getVuelo().getCodigoVuelo() == p.getVuelo().getCodigoVuelo() && this.categoriaPasaje == p.categoriaPasaje)){
            return 0;
        } else{
            return -1;
        }
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
    
    public boolean getEsDevuelto() {
        return esDevuelto;
    }

    public void setEsDevuelto(boolean esDevuelto) {
        this.esDevuelto = esDevuelto;
    }
    
    private String getCodigoEstado(){
        if(this.esDevuelto){
            return "DEV";
        }else{
            return "CPR";
        }
    }

    @Override
    public String toString() {
        return vuelo.getCodigoVuelo() + "-" + this.getCodigoEstado() + "|";
    }
}

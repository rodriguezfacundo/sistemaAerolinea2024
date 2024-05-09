package dominio;

import tads.Cola;
import tads.Lista;

public class Vuelo implements Comparable<Vuelo> {
    private String codigoVuelo;
    private Aerolinea aerolinea;
    private Avion avion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private Lista<Pasaje> pasajesEconomicosEmitidos;
    private Lista<Pasaje> pasajesPrimeraClaseEmitidos;
    private Cola<Pasaje> pasajesPrimeraClasePendientes;
    private Cola<Pasaje> pasajesEconomicosPendientes;
    private Cola<Cliente> clientesEnEspera;
    private Lista<Pasaje> pasajesDevueltos;

    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.pasajesEconomicosEmitidos = new Lista<>(cantPasajesEcon);
        this.pasajesPrimeraClaseEmitidos = new Lista<>(cantPasajesPClase);
        this.pasajesEconomicosPendientes = new Cola<>();
        this.pasajesPrimeraClasePendientes = new Cola<>();
        this.clientesEnEspera = new Cola<>();
        this.pasajesDevueltos = new Lista<>();
    }

    public Lista<Pasaje> getPasajesEconomicosEmitidos() {
        return pasajesEconomicosEmitidos;
    }

    public void setPasajesEconomicosEmitidos(Lista<Pasaje> pasajesEconomicosEmitidos) {
        this.pasajesEconomicosEmitidos = pasajesEconomicosEmitidos;
    }

    public Lista<Pasaje> getPasajesPrimeraClaseEmitidos() {
        return pasajesPrimeraClaseEmitidos;
    }

    public void setPasajesPrimeraClaseEmitidos(Lista<Pasaje> pasajesPrimeraClaseEmitidos) {
        this.pasajesPrimeraClaseEmitidos = pasajesPrimeraClaseEmitidos;
    }

    public Cola<Pasaje> getPasajesPrimeraClasePendientes() {
        return pasajesPrimeraClasePendientes;
    }

    public void setPasajesPrimeraClasePendientes(Cola<Pasaje> pasajesPrimeraClasePendientes) {
        this.pasajesPrimeraClasePendientes = pasajesPrimeraClasePendientes;
    }

    public Cola<Pasaje> getPasajesEconomicosPendientes() {
        return pasajesEconomicosPendientes;
    }

    public void setPasajesEconomicosPendientes(Cola<Pasaje> pasajesEconomicosPendientes) {
        this.pasajesEconomicosPendientes = pasajesEconomicosPendientes;
    }

    public Lista<Pasaje> getPasajesDevueltos() {
        return pasajesDevueltos;
    }

    public void setPasajesDevueltos(Lista<Pasaje> pasajesDevueltos) {
        this.pasajesDevueltos = pasajesDevueltos;
    }


    @Override
    public int compareTo(Vuelo o) {
        return 0;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", aerolinea='" + aerolinea.getNombre() + '\'' +
                ", codAvion='" + avion.getCodigo() + '\'' +
                ", paisDestino='" + paisDestino + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                '}';
    }
}

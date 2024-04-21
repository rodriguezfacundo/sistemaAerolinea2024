package dominio;

import tads.Cola;
import tads.Lista;

public class Vuelo implements Comparable<Vuelo> {
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private Lista<Pasaje> pasajesEconomicos;
    private Lista<Pasaje> pasajesPrimeraClase;
    private Lista<Pasaje> pasajesDevueltos;
    private Cola<Pasaje> pasajesPendientes;



    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.pasajesEconomicos = new Lista<>();
        this.pasajesPrimeraClase = new Lista<>();
        this.pasajesDevueltos = new Lista<>();
        this.pasajesPendientes = new Cola<>();
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

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
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


    @Override
    public String toString() {
        return "Vuelo{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", aerolinea='" + aerolinea + '\'' +
                ", codAvion='" + codAvion + '\'' +
                ", paisDestino='" + paisDestino + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                '}';
    }

    public Lista<Pasaje> getPasajesEconomicos() {
        return pasajesEconomicos;
    }

    public Lista<Pasaje> getPasajesPrimeraClase() {
        return pasajesPrimeraClase;
    }

    public Lista<Pasaje> getPasajesDevueltos() {
        return pasajesDevueltos;
    }

    public Cola<Pasaje> getPasajesPendientes() {
        return pasajesPendientes;
    }
}

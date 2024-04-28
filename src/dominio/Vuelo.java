package dominio;

import tads.Lista;

public class Vuelo implements Comparable<Vuelo> {

    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    private Lista<Pasaje> pasajesEconPend;
    private Lista<Pasaje> pasajesPrimPend;
    private Lista<Pasaje> pasajesEconEmi;
    private Lista<Pasaje> pasajesPrimEmi;
    private Lista<Pasaje> pasajesDev;

    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
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

    public void setPasajesEconPend(Lista<Pasaje> pasajesEconPend) {
        this.pasajesEconPend = pasajesEconPend;
    }

    public void setPasajesPrimPend(Lista<Pasaje> pasajesPrimPend) {
        this.pasajesPrimPend = pasajesPrimPend;
    }

    public void setPasajesEconEmi(Lista<Pasaje> pasajesEconEmi) {
        this.pasajesEconEmi = pasajesEconEmi;
    }

    public void setPasajesPrimEmi(Lista<Pasaje> pasajesPrimEmi) {
        this.pasajesPrimEmi = pasajesPrimEmi;
    }

    public void setPasajesDev(Lista<Pasaje> pasajesDev) {
        this.pasajesDev = pasajesDev;
    }

    public Lista<Pasaje> getPasajesEconPend() {
        return pasajesEconPend;
    }

    public Lista<Pasaje> getPasajesPrimPend() {
        return pasajesPrimPend;
    }

    public Lista<Pasaje> getPasajesEconEmi() {
        return pasajesEconEmi;
    }

    public Lista<Pasaje> getPasajesPrimEmi() {
        return pasajesPrimEmi;
    }

    public Lista<Pasaje> getPasajesDev() {
        return pasajesDev;
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

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    @Override
    public String toString() {
        return "Vuelo{"
                + "codigoVuelo='" + codigoVuelo + '\''
                + ", aerolinea='" + aerolinea + '\''
                + ", codAvion='" + codAvion + '\''
                + ", paisDestino='" + paisDestino + '\''
                + ", dia=" + dia
                + ", mes=" + mes
                + ", anio=" + anio
                + ", cantPasajesEcon=" + cantPasajesEcon
                + ", cantPasajesPClase=" + cantPasajesPClase
                + '}';
    }
}

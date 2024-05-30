package tads;

import dominio.Vuelo;

public class ListaVuelo<T> extends Lista<Vuelo>{
    //todo: preguntar por esta extendde Tad lista
    public Nodo<Vuelo> obtenerPorFecha(int dia, int mes, int anio){
        Nodo<Vuelo> r = null;
        
        if(!this.esVacia()){
            Nodo<Vuelo> actual=this.getInicio();
            
            while(actual != null && actual.getDato() != null){
               
                if(actual.getDato().getAnio()== anio
                        && actual.getDato().getMes()== mes
                        && actual.getDato().getDia()== dia){
                    
                    r=actual;
                    break;
                }
                
                actual = actual.getSiguiente();
            }
        }
        return r;
    }
}

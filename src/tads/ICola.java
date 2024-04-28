package tads;

import tads.Nodo;

public interface ICola<T extends Comparable<T>> {
    public void encolar(T dato);
    public void desencolar();
    public Nodo<T> frente();
    public boolean esVacia();
    public boolean esLlena();
    //metodos complementarios
    public boolean eliminarElemento(Cola c, int num);
    public boolean existeElemento(T dato);
    public Nodo<T> obtenerElemento(T dato);
}

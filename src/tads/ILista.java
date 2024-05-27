package tads;

import tads.Nodo;

public interface ILista<T extends Comparable<T>> {
    //pre: averigua si una lista es vacia o no
    //post: retorna true si la lista es vacia y false si no lo es
    boolean esVacia();

    //pre: partimos de una lista de datos T (vacia o no)
    //post: retorna un entero que indica la cantidad de elem de la lista
    int cantidadElementos();

    //pre: tenemos una lista de datos T
    //post: muestra los datos de la lista
    public void mostrar();

    //pre: tenemos una lista de datos T
    //post: obtenemos una lista vacía (inicio=null)
    public void vaciar();

    //pre: tenemos una lista de datos de tipo T
    //post:agrega un nodo con el dato x en el inicio
    public void agregarInicio(T x);

    //pre: tenemos una lista de datos de tipo T
    //post: se agrega un elemento de tipo T al final de la lista
    public void agregarFinal(T x);

    //pre: tenemos una lista de datos de tipo T
    //post: se elimina el primer elemento de la lista.
    public void eliminarInicio();


    //pre: se tiene una lista de tipo T
    //post: se obtiene la lista sin el nodo que contiene el dato x
    public void eliminarElemento(T x);

    //pre: se tiene una lista de tipo T
    //post: retorna un booleano con true si el dato x esta en la lista
    public boolean estaElemento(T x);

    //pre: se tiene una lista de tipo T ORDENADA ascendente
    //post: se agrega el dato x en el lugar correspondiente
    //manteniendo el orden
    public void agregarOrdenado(T x);

    //pre: se tiene una lista de tipo T
    //post: se retorna el nodo que contiene el dato x y null en caso de que no exista
    public Nodo obtenerElemento(T x);

    //pre: Se tiene una lista de elementos de tipo T y se recibe un paràmetro de tipo T.
    // post: devuelve la cantidad de ocurrencias en que aparece el elemento T
    public int contarRec(T elem);

    //pre: Se tiene un nodo del tipo T y una lista del tipo T
    // post:  muestra los datos de la lista de forma recursiva
    public void mostrarREC(Nodo<T> inicio);

}

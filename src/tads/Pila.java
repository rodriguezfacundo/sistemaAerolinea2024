package tads;

public class Pila<T extends Comparable<T>> implements IPila<T> {

    private Nodo inicio;
    private int dato;
    private int cantElementos;
    private int cantMax;

    //Constructor
    public Pila(int cantMaxima) {
        cantMax = cantMaxima;
        inicio = null;
    }

    @Override
    public void apilar(T dato) {

        if (!esllena()) {
            Nodo nuevo = new Nodo(dato);
            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
            cantElementos++;
        } else {
            System.out.println("Pila llena");
        }

    }

    @Override
    public void desapilar() {
        if (!this.esVacia()) {
            inicio = getInicio().getSiguiente();
            cantElementos--;
        } else {
            System.out.println("Pila vacia");
        }
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public boolean esllena() {
        return cantElementos == cantMax;
    }

    @Override
    public Nodo cima() {
        return this.getInicio();
    }

    @Override
    public int elementos() {
        return cantElementos;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public boolean existeElemento(T dato) { //Todo: Preguntar si se puede hacer dentro de la TAD pila
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true; // Dato encontrado
            }
            actual = actual.getSiguiente();
        }
        return false; // Dato no encontrado
    }

    public Nodo<T> ObtenerElemento(T dato) {//Todo: Preguntar si se puede hacer dentro de la TAD pila
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual; // Dato encontrado
            }
            actual = actual.getSiguiente();
        }
        return null; // Dato no encontrado
    }

    public String imprimirPila() { //Todo: Preguntar si se puede hacer dentro de la TAD pila
        return imprimirNodo(inicio);
    }

    private String imprimirNodo(Nodo<T> nodo) {
        if (nodo == null) {
            return "";
        } else {
            String actual = nodo.getDato().toString();
            return actual += imprimirNodo(nodo.getSiguiente());
        }
    }

}

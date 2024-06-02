package tads;

public class Lista<T extends Comparable<T>> implements ILista<T> {
    private Nodo<T> inicio;
    private int cantElementos;
    private int cantMaxima;

    public Lista() {
        this.inicio = null;
        this.cantElementos = 0;
        this.cantMaxima = Integer.MAX_VALUE;
    }
    public Lista(int cantMaxima) {
        this.inicio = null;
        this.cantElementos = 0;
        this.cantMaxima = cantMaxima;
    }

    public int getCantMaxima(){
        return this.cantMaxima;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public int cantidadElementos() {
        Nodo<T> mostrar = inicio;
        int cant = 0;

        while (mostrar != null) {
            cant++;
            mostrar = mostrar.getSiguiente();
        }

        return cant;
    }

    @Override
    public void mostrar() {
        Nodo<T> pactual = this.inicio;
        mostrarREC(pactual);
    }

    @Override
    public void vaciar() {
        this.inicio = null;
    }

    @Override
    public void agregarInicio(T x) {
        Nodo<T> nuevo = new Nodo<T>(x);
        nuevo.setSiguiente(this.inicio);
        this.setInicio(nuevo);
    }

    @Override
    public void agregarFinal(T x) {
        Nodo<T> pactual = this.inicio;
        Nodo<T> nuevo = new Nodo<T>(x);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            while (pactual.getSiguiente() != null) {
                pactual = pactual.getSiguiente();
            }
            pactual.setSiguiente(nuevo);
        }
    }

    @Override
    public void eliminarInicio() {
        if (!esVacia()) {
            this.inicio = this.inicio.getSiguiente();
        }
    }

    @Override
    public boolean estaElemento(T x) {
        Nodo<T> pactual = inicio;
        boolean estaElem = false;
        while (pactual != null && !estaElem) {
            if (pactual.getDato().equals(x)) {
                estaElem = true;
            } else {
                pactual = pactual.getSiguiente();
            }
        }
        return estaElem;
    }

    @Override
    public void eliminarElemento(T x) {
        if (!esVacia()) {
            Nodo<T> actual = inicio;
            if (inicio.getDato().compareTo(x) == 0) {
                eliminarInicio();
            } else {
                while (actual.getSiguiente()!=null && actual.getSiguiente().getDato().compareTo(x) != 0) {
                    actual=actual.getSiguiente();
                }
                if (actual.getSiguiente()!=null) {
                    Nodo aborrar=actual.getSiguiente();
                    actual.setSiguiente(aborrar.getSiguiente());
                    aborrar.setSiguiente(null);

                }
            }
            this.cantElementos -= 1;
        }
    }

    @Override
    public void agregarOrdenado(T x) {
        if (this.esVacia() || x.compareTo(inicio.getDato())<0)   {
            this.agregarInicio(x);
        }
        else {
            Nodo<T> actual = inicio;
            while (actual.getSiguiente()!=null  && actual.getSiguiente().getDato().compareTo(x) < 0 ) {
                actual = actual.getSiguiente();
            }
            Nodo<T> nuevo = new Nodo<T>(x);
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
        this.cantElementos += 1;
    }

    @Override
    public Nodo<T> obtenerElemento(T x) {
        Nodo<T> ret = null;
        if (!this.esVacia()) {
            Nodo<T> actual= inicio;
            while (actual!=null && actual.getDato().compareTo(x)!=0) {
                actual= actual.getSiguiente();
            }
            if (actual!=null)
                ret = actual;
        }
        return ret;
    }
    @Override
    public int contarRec(T elem) {
        return contarRecDesdeNodo(this.inicio, elem);
    }

    private int contarRecDesdeNodo(Nodo<T> actual, T elem) {
        if (actual == null) {
            return 0;
        } else
        if (elem.compareTo(actual.getDato())==0)
            return 1 + contarRecDesdeNodo(actual.getSiguiente(), elem);
        else return contarRecDesdeNodo(actual.getSiguiente(), elem);

    }

    @Override
    public void mostrarREC(Nodo<T> actual) {
        if (actual != null) {
            System.out.println(" - " + actual.getDato());
            mostrarREC(actual.getSiguiente());
        }
    }

    @Override
    public String mostrarRecString(Nodo<T> actual) {
        if (actual == null) {
            return "";
        } else if (actual.getSiguiente() == null) {
            return actual.getDato().toString();
        } else {
            return actual.getDato().toString() + '\n' + mostrarRecString(actual.getSiguiente());
        }
    }
    
    @Override
    public void reemplazar(T antiguo, T nuevo) {
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.getDato().compareTo(antiguo) == 0) {
                actual.setDato(nuevo);
            }
            actual = actual.getSiguiente();
        }
    }
}

package tads;

public class Cola<T extends Comparable<T>> implements ICola<T> {

    private Nodo<T> inicio;
    private int cantidad;
    private int tope;

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public Cola(int cantMax) {
        this.tope = cantMax;
    }

    @Override
    public void encolar(T dato) {
        if (!esLlena()) {
            Nodo<T> pactual = this.inicio;
            Nodo<T> nuevo = new Nodo<T>(dato);
            if (esVacia()) {
                inicio = nuevo;
                cantidad++;
            } else {
                while (pactual.getSiguiente() != null) {
                    pactual = pactual.getSiguiente();
                }
                pactual.setSiguiente(nuevo);
                cantidad++;
            }
        }
    }

    @Override
    public void desencolar() {
        if (!esVacia()) {
            this.inicio = this.inicio.getSiguiente();
            cantidad--;
        }
    }

    @Override
    public Nodo<T> frente() {
        return inicio;
    }

    @Override
    public boolean esVacia() {
        return cantidad==0;
    }

    @Override
    public boolean esLlena() {
        return cantidad==tope;
    }

    @Override
    public boolean eliminarElemento(Cola c, int num) {
        boolean borre=false;
        for (int i=1;i<=c.cantidad;i++) {
            if ((Integer)c.frente().getDato()!=num){
                c.encolar(c.frente().getDato());
                c.desencolar();
            } else {
                c.desencolar();
                borre=true;
            }
        }
        return borre;
    }

    @Override
    public boolean existeElemento(T dato) {
        boolean existe=false;
        for (int i=1;i<=this.cantidad;i++) {
            if (this.frente().getDato().compareTo(dato) != 0){
                this.encolar(this.frente().getDato());
                this.desencolar();
            } else {
                existe=true;
            }
        }
        return existe;
    }

    @Override
    public Nodo<T> obtenerElemento(T dato) {
        Nodo<T> nodoReturn = null;
        for (int i=1;i<=this.cantidad;i++) {
            if (this.frente().getDato().compareTo(dato) != 0){
                this.encolar(this.frente().getDato());
                this.desencolar();
            } else {
                nodoReturn = this.frente();
            }
        }
        return nodoReturn;
    }

}

package tads;

public interface IPila<T> {
    
    public void apilar(T dato);
    public void desapilar();
    public boolean esVacia();
    public boolean esllena();
    public Nodo cima();
    public int elementos();

}
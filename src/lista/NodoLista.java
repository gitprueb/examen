package lista;



public class NodoLista<T> {
    public T dato;
    public NodoLista<T> siguiente;
    public NodoLista<T> anterior;

    public NodoLista(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}



package lista;

public class IteradorLista<T> {
    private NodoLista<T> actual;

    public IteradorLista(ListaDoble<T> ld) {
        actual = ld.cabeza;
    }

    public NodoLista<T> siguiente() {
        NodoLista<T> a = actual;
        if (actual != null) {
            actual = actual.siguiente;
        }
        return a;
    }

    public NodoLista<T> anterior() {
        NodoLista<T> a = actual;
        if (actual != null) {
            actual = actual.anterior;
        }
        return a;
    }
}



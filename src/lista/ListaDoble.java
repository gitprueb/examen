package lista;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ListaDoble<T> {
    protected NodoLista<T> cabeza;
    protected NodoLista<T> actual;
    protected int tamano;
    public Queue<File> fileQueue;

    public ListaDoble() {
        cabeza = null;
        actual = null;
        tamano = 0;
        fileQueue = new LinkedList<File>();
    }

    public ListaDoble<T> insertarCabezaLista(T entrada) {
        NodoLista<T> nuevo = new NodoLista<T>(entrada);
        nuevo.siguiente = cabeza;
        if (cabeza != null)
            cabeza.anterior = nuevo;
        cabeza = nuevo;
        tamano++;
        actual = cabeza;
        return this;
    }

    public ListaDoble<T> insertaDespues(NodoLista<T> anterior, T entrada) {
        NodoLista<T> nuevo = new NodoLista<T>(entrada);
        nuevo.siguiente = anterior.siguiente;
        if (anterior.siguiente != null)
            anterior.siguiente.anterior = nuevo;
        anterior.siguiente = nuevo;
        nuevo.anterior = anterior;
        if (anterior == actual) {
            actual = nuevo;
        }
        tamano++;
        return this;
    }

    public void eliminar(T entrada) {
        NodoLista<T> actual;
        boolean encontrado = false;
        actual = cabeza;
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.dato.equals(entrada));
            if (!encontrado)
                actual = actual.siguiente;
        }
        if (actual != null) {
            if (actual == cabeza) {
                cabeza = actual.siguiente;
                if (actual.siguiente != null)
                    actual.siguiente.anterior = null;
            } else if (actual.siguiente != null) {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            } else
                actual.anterior.siguiente = null;
            tamano--;
            if (actual == this.actual) {
                this.actual = this.actual.anterior;
            }
            actual = null;
        }
    }

    public void visualizar() {
        NodoLista<T> n;
        n = cabeza;
        while (n != null) {
            System.out.print(n.dato.toString() + "\n");
            n = n.siguiente;
        }
    }

    public void agregarArchivosDeCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        File[] archivos = carpeta.listFiles();
        for (File archivo : archivos) {
            if (archivo.isFile()) {
                insertarCabezaLista((T)archivo);
            }
        }
    }
}











package lista;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class cola {
    private Queue<File> cola;

    public cola(ListaDoble<File> lista) {
        cola = new LinkedList<>();
        IteradorLista iterador = new IteradorLista(lista);
        NodoLista<File> nodoActual;
        while ((nodoActual = iterador.siguiente()) != null) {
            cola.offer(nodoActual.dato);
        }
    }

    public void mostrarCola() {
        for (File archivo : cola) {
            System.out.println(archivo.getName());
        }
    }
}









package examen;

import java.io.File;
import lista.IteradorLista;
import lista.ListaDoble;
import lista.NavegadorArchivos;
import lista.NodoLista;
import lista.cola;

public class Examenmp3 {

    public static void main(String[] args) {
        ListaDoble<File> lista = new ListaDoble<File>();
        lista.agregarArchivosDeCarpeta("C:\\Users\\ericf\\OneDrive\\Documentos\\musicaexp");

        System.out.println("Archivos de la lista doblemente enlazada:");
        lista.visualizar();

        cola cola = new cola(lista);
        System.out.println("\nArchivos de la cola:");
        cola.mostrarCola();

        System.out.println("\nRecorrido con iterador de la lista doblemente enlazada:");
        IteradorLista iterador = new IteradorLista(lista);
        NodoLista<File> nodo = iterador.siguiente();
        while (nodo != null) {
            System.out.println(nodo.dato.getName());
            nodo = iterador.siguiente();
        }

        System.out.println("\nNavegación de archivos:");
        NavegadorArchivos navegador = new NavegadorArchivos(lista);
        navegador.mostrarArchivos();
        navegador.navegarArchivos();
    }
}















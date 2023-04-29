package lista;

import java.io.File;
import java.util.Scanner;

public class NavegadorArchivos {
    private cola colaArchivos;
    private IteradorLista<File> iterador;

    public NavegadorArchivos(ListaDoble<File> lista) {
        colaArchivos = new cola(lista);
        iterador = new IteradorLista<>(lista);
    }

    

    public void mostrarArchivos() {
        colaArchivos.mostrarCola();
    }

   public void navegarArchivos() {
    Scanner scanner = new Scanner(System.in);
    int opcion = 0;
    File archivoActual = null;

    while (opcion != -1) {
        if (archivoActual == null) {
            archivoActual = iterador.siguiente().dato;
            System.out.println("Archivo actual: " + archivoActual.getName());
        }

        System.out.println("Presione 1 para avanzar, 2 para retroceder, o -1 para salir.");
        opcion = scanner.nextInt();

        if (opcion == 1) {
            if (iterador.siguiente() != null) {
                archivoActual = iterador.siguiente().dato;
                System.out.println("Archivo actual: " + archivoActual.getName());
            } else {
                System.out.println("No hay más archivos para avanzar.");
            }
        } else if (opcion == 2) {
            NodoLista<File> nodoAnterior = iterador.anterior();
            if (nodoAnterior != null) {
                archivoActual = nodoAnterior.dato;
                System.out.println("Archivo actual: " + archivoActual.getName());
            } else {
                System.out.println("No hay más archivos para retroceder.");
            }
        } else if (opcion == -1) {
            System.out.println("Saliendo...");
        } else {
            System.out.println("Opción inválida.");
        }
        
        // Verificar si se llegó al final de la lista de archivos
        if (iterador.siguiente() == null && opcion == 1) {
            System.out.println("Se ha llegado al final de la lista de archivos.");
            opcion = -1;
        }
    }
}

}




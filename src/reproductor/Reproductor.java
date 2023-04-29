package reproductor;

import java.io.File;
import java.util.Queue;

public class Reproductor {
    private Queue<File> cola;
    
    public Reproductor(Queue<File> cola) {
        this.cola = cola;
    }

    public void reproducir() {
        if (cola.isEmpty()) {
            System.out.println("No hay más archivos en la cola. La reproducción se detendrá.");
            System.exit(0);
        } else {
            File archivoActual = cola.peek();
            System.out.println("Reproduciendo archivo: " + archivoActual.getName());
        }
    }
    
    public void siguiente() {
        if (!cola.isEmpty()) {
            File archivoActual = cola.poll();
            cola.offer(archivoActual);
        }
    }
    
    public void anterior() {
        if (!cola.isEmpty()) {
            File archivoActual = cola.poll();
            cola.add(archivoActual);
        }
    }
}







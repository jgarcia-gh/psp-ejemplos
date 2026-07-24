package pconcurrente.ejemplo24;

import java.util.concurrent.locks.ReentrantLock;

public class InventarioJugador {
    private final String nombreJugador;
    private final ReentrantLock lock = new ReentrantLock();
    private int objetos = 10;

    public InventarioJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void quitarObjeto() {
        objetos--;
    }

    public void anadirObjeto() {
        objetos++;
    }
}
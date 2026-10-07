package pconcurrente.ejemplo24b;

import java.util.Random;
public class InventarioJugador {
    private final String nombreJugador;
    private int objetos = 10;

    private final int ID = new Random().nextInt();
    public InventarioJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void quitarObjeto() {
        objetos--;
    }

    public void anadirObjeto() {
        objetos++;
    }

    public int getID() {
        return ID;
    }
}
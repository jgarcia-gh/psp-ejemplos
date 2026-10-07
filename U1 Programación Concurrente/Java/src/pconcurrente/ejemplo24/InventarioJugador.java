package pconcurrente.ejemplo24;

import java.util.Random;

public class InventarioJugador {
    private final String nombreJugador;
    private int objetos = 10;
    public final int ID = new Random().nextInt();

    public int getID(){
        return ID;
    }
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
}
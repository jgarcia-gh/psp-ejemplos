package sockets.ejemplo5;

import java.io.Serializable;

public class Perro implements Serializable {
    private String nombre;
    private int edad;

    public Perro(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro llamado " + nombre + ", edad " + edad + " años";
    }
}

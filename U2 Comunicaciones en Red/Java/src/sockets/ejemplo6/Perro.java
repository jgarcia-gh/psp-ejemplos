package sockets.ejemplo6;

import java.io.Serializable;

public class Perro {
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

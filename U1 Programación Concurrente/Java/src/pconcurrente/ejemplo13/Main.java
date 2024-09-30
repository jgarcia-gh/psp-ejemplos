package pconcurrente.ejemplo13;

import java.util.Scanner;

/*
En este ejemplo tenemos un hilo cafetera encargado de realizar cafés de forma indefinida.
Este ejemplo sirve de base para explicar cómo podemos finalizar o interrumpir un hilo desde otro.
En este caso, cómo detener la cafetera desde el hilo principal.
 */
public class Main {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera c = new Cafetera();
        Thread t = new Thread(c);
        t.start();
    }
}

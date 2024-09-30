package pconcurrente.ejemplo13c;

import java.util.Scanner;

/*
Otro modo es enviando una interrupción mediante el método interrupt de la clase Thread.
Si el hilo se encuentra en una operación de sleep, join o wait, lanzará una excepción (Interrupted Exception)
que hará que la cafetera salga del bucle while, y así finalizará el hilo.
Si no se lanza la excepción, será la condición del bucle while la que detectará que se ha producido la interrupción.
 */
public class Main {

    public static void main(String[] args) {

        // Lanzamos el hilo
        Cafetera c = new Cafetera();
        Thread t = new Thread(c);
        t.start();

        // Cuando el usuario pulse enter detenemos el hilo
        System.out.println("Presiona intro para detener la cafetera");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        t.interrupt();

        // La finalización no es instantánea, así que esperamos a que realmente finalice
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}

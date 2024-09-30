package pconcurrente.ejemplo13d;

import java.util.Scanner;

/*
Este ejemplo sirve para demostrar que hay que conocer bien cómo funcionan las interrupciones en Java.
Un pequeño cambio en el código de la Cafetera como el que se puede ver en este ejemplo, hará que si se produce una interrupción,
aunque se lance la excepción InterruptedException, la cafetera no saldrá del bucle while y continuará su ejecución.
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

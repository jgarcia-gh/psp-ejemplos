package pconcurrente.ejemplo13b;

import java.util.Scanner;

/*
Una de las formas de dener un hilo es mediante un flag. Un flag no deja de ser un booleano que indica si el
hilo debe seguir ejecutándose o no.
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
        // Si se ejecuta la siguiente línea es porque el usuario ha pulsado la tecla enter
        c.Detener();

        // La finalización no es instantánea, así que esperamos a que realmente finalice
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}

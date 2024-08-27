package pconcurrente.ejemplo13d;

import java.util.Scanner;

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
        while (t.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Total: %d cafés", c.getContador());
    }
}

package u2.ejemplo17TT;

import java.util.Scanner;

public class Main {
    public static boolean ejecutar = true;
    public static int cafesPreparados = 0;
    public static void main(String[] args) {

        Thread t = new Thread(() ->{
            while(ejecutar){
                try{
                    // Comenzamos a preparar el café
                    // Ponemos la cafetera
                    Thread.sleep(200);
                    // Servimos el café en la taza"
                    Thread.sleep(200);
                    // Echamos la leche
                    Thread.sleep(200);
                    // Café finalizado
                    cafesPreparados++;
                }catch (InterruptedException ie){
                    System.out.println("Hilo interrumpido");
                }
            }
        });
        t.start(); // Lanzamos el hilo
        // Cuando el usuario pulse enter detenemos el hilo
        System.out.println("Presiona intro para detener la cafetera");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        ejecutar = false;

        // Esperamos la finalización del hilo
        try {
            System.out.println("Esperamos la finalización del hilo");
            t.join();
            System.out.println("Hilo finalizado");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
        System.out.printf("Total: %d cafés", cafesPreparados);
    }
}


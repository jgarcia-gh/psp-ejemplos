package pconcurrente.ejemplo11;

import java.util.Random;

/*
¿Cómo podríamos esperar la finalización de un hilo? Este ejemplo muestra una posible solución.
El hilo main hace esperas de 1000 ms mientras el hilo esté vivo. Esta solución no es eficiente.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        // Lanzamos un hilo que cuenta de 0 a 9
        Thread t = new Thread(() ->{
            try{
                Random r = new Random();
                for(int i = 0; i < 10; i++){
                    Thread.sleep((long)r.nextInt(1500));
                    System.out.println("Número " + i);
                }
            } catch(InterruptedException ie){
                System.out.println("El hilo ha sido interrumpido");
            }
        });
        t.start();

        // Esperamos a que finalice
        while(t.isAlive()){
            Thread.sleep(1000);
        }
        System.out.println("El hilo ha finalizado");
    }
}

package u2.ejemplo12;

import java.util.Random;

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

        // Nos suspendemos hasta que el hilo t finalice
        t.join();
        System.out.println("El hilo ha finalizado");
    }
}

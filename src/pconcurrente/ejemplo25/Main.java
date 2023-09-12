package u2.ejemplo25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static int contadorHilos = 0;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;

        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                           " Hilos activos: " + pool.getActiveCount());

        System.out.println("Lanzamos hilo 0 y 1");
        Contador c = new Contador(contadorHilos);
        executor.execute(c);
        contadorHilos++;
        c = new Contador(contadorHilos);
        executor.execute(c);
        contadorHilos++;
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                           " Hilos activos: " + pool.getActiveCount());

        System.out.println("Esperamos 1 segundo");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                " Hilos activos: " + pool.getActiveCount());

        System.out.println("Lanzamos hilo 2");
        c = new Contador(contadorHilos);
        contadorHilos++;
        executor.execute(c);
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                           " Hilos activos: " + pool.getActiveCount());

        System.out.println("Esperamos 70 segundos");
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                           " Hilos activos: " + pool.getActiveCount());

        System.out.println("Lanzamos hilo 3");
        c = new Contador(contadorHilos);
        executor.execute(c);
        System.out.println("Hilos en el pool: " + pool.getPoolSize() +
                           " Hilos activos: " + pool.getActiveCount());

        executor.shutdown();
    }
}

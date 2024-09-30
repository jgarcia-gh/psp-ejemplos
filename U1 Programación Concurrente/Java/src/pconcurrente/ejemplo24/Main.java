package pconcurrente.ejemplo24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Uso de un Thread Pool con un único hilo.
 */
public class Main {

    public static int contadorHilos = 0;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for(int i = 1; i <= 10; i++){
            Contador c = new Contador(contadorHilos);
            executor.execute(c);
            contadorHilos++;
        }

        executor.shutdown();
    }
}

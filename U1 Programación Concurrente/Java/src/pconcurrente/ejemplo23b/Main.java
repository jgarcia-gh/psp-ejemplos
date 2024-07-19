package u2.ejemplo23b;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static int contadorHilos = 0;
    public static Object lock;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 1; i <= 10; i++){
            executor.execute(
                    ()->{
                        int id;
                        synchronized (lock){
                            id = contadorHilos;
                            contadorHilos++;
                        }
                        for(int j = 1; j <= 5; j++){
                            System.out.println("Tarea " + id + ": " + j);
                        }
                    }
            );
        }

        executor.shutdown();
    }
}

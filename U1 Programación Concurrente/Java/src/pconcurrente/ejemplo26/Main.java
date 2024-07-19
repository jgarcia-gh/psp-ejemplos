package u2.ejemplo26;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static int contadorHilos = 0;

    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

        System.out.println("Código antes de lanzar las tareas");
        for(int i = 1; i <= 10; i++){
            Contador c = new Contador(contadorHilos);
            ses.schedule(c, 5, TimeUnit.SECONDS);
            contadorHilos++;
        }
        System.out.println("Código después de lanzar las tareas");
        ses.shutdown();
    }
}

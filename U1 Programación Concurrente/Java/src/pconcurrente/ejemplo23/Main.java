package pconcurrente.ejemplo23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Creación de un Thread Pool de tamaño fijo 2. Podemos ver que, aunque queramos lanzar 10 contadores,
solo se ejecutarán de 2 en 2.
El atributo estático se utiliza para contabilizar los hilos creados y asignar el número a cada hilo.
 */
public class Main {

    public static int contadorHilos = 0;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 1; i <= 10; i++){
            Contador c = new Contador(contadorHilos);
            executor.execute(c);
            contadorHilos++;
        }

        executor.shutdown();
    }
}

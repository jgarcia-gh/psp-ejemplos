package pconcurrente.ejemplo23b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Caso similar al del ejemplo 23 pero utilizando una expresión lambda.
En este caso se produce un problema ya que todos los hilos acceden y modifican el mismo atributo estático contadorHilos
Es decir, se trata de una variable compartida. Para evitar problemas es necesario utilizar un bloque sincronizado.
 */
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

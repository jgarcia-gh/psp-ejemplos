package pconcurrente.ejemplo16;

/*
Ejemplo con expresión lambda, en el que no existe variable compartida.
 */
public class Main {
    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(() ->{
                int contador = 0;
                for(int j = 0; j < 100; j++){
                    contador++;
                }
                System.out.println(
                "Finalizado el hilo " + Thread.currentThread().getName() +
                ". El valor del contador es " + contador);
            });
            t.start();
        }
    }
}


package pconcurrente.ejemplo17b;

/*
Este ejemplo sirve para demostrar que la variable contador no podría ser local, ya que desde una expresión lambda (ni una clase anónima)
podemos modificar variables locales.
 */
public class Main {
    public static void main(String[] args) {
        int contador = 0;
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(() ->{
                for(int j = 0; j < 100; j++){
                    // contador++; La modificación de la variable local desde la expresión lambda produce un error
                }
                System.out.println(
                "Finalizado el hilo " + Thread.currentThread().getName() +
                ". El valor del contador es " + contador);
            });
            t.start();
        }
    }
}


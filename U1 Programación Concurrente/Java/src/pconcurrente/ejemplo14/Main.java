package pconcurrente.ejemplo14;

/*
Ejemplo en el que no existe problemas de memoria compartida ya que cada hilo tiene su propio objeto Contador.
 */
public class Main {
    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Contador c = new Contador();
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}


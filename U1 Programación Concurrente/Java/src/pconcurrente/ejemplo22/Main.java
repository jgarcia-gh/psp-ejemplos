package pconcurrente.ejemplo22;

/*
En este ejemplo tenemos dos hilos PrepararCafe y PrepararLeche que comparten un objeto de tipo Taza.
Mediante bloques sincronizados y llamadas a los métodos wait y notify, los dos hilos se coordinan para
servir un café con leche.
 */
public class Main {
    public static void main(String[] args) {

        Taza taza = new Taza();
        Thread t1 = new Thread(new PrepararCafe(taza));
        Thread t2 = new Thread(new PrepararLeche(taza));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido el hilo");
        }
        System.out.println("La taza contiene " + taza.getIngredientes());
    }
}

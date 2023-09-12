package u2.ejemplo22;

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

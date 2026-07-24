package pconcurrente.ejemplo23;

public class Main {
    private static final Object recursoA = new Object();
    private static final Object recursoB = new Object();

    public static void main(String[] args) {
        new Thread(Main::metodoHilo1).start();
        new Thread(Main::metodoHilo2).start();
    }

    public static void metodoHilo1() {
        synchronized (recursoA) {
            System.out.println("Hilo 1: Bloqueó Recurso A");

            // Un pequeño delay para asegurar que el Hilo 2 bloquee el Recurso B
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (recursoB) {
                System.out.println("Hilo 1: Bloqueó Recurso B");
            }
        }
    }
    public static void metodoHilo2() {
        synchronized (recursoB) { // <-- ¡Aquí está el peligro! Orden invertido
            System.out.println("Hilo 2: Bloqueó Recurso B");

            try { Thread.sleep(50); } catch (InterruptedException e) {}

            synchronized (recursoA) {
                System.out.println("Hilo 2: Bloqueó Recurso A");
            }
        }
    }
}

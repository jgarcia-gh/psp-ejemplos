package pconcurrente.ejemplo24b;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventarioJugador inventarioAitor = new InventarioJugador("Aitor");
        InventarioJugador inventarioBeatriz = new InventarioJugador("Beatriz");
        SistemaIntercambio sistema = new SistemaIntercambio();

        // Hilo 1: Aitor le da un objeto a Beatriz
        Thread hilo1 = new Thread(
                () -> sistema.intercambiarObjetos(inventarioAitor, inventarioBeatriz),
                "Hilo-1-Aitor->Beatriz");

        // Hilo 2: Beatriz le da un objeto a Aitor, al mismo tiempo
        Thread hilo2 = new Thread(
                () -> sistema.intercambiarObjetos(inventarioBeatriz, inventarioAitor),
                "Hilo-2-Beatriz->Aitor");

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Intercambios finalizados.");
    }
}
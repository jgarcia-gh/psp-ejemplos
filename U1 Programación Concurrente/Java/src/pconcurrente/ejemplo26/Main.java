package pconcurrente.ejemplo26;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Piscina piscina = new Piscina();

        // Empezamos en turno de natación (por defecto turnoDeSaltos = false)
        Thread[] nadadores = new Thread[3];
        for (int i = 0; i < nadadores.length; i++) {
            nadadores[i] = new Thread(new Nadador(piscina, "Nadador-" + i));
        }

        Thread[] saltadores = new Thread[3];
        for (int i = 0; i < saltadores.length; i++) {
            saltadores[i] = new Thread(new Saltador(piscina, "Saltador-" + i));
        }

        // El socorrista cambiará de turno 4 veces, cada 1 segundo
        Thread socorrista = new Thread(new Socorrista(piscina, 4, 1000));

        for (Thread t : nadadores) t.start();
        for (Thread t : saltadores) t.start();
        socorrista.start();

        for (Thread t : nadadores) t.join();
        for (Thread t : saltadores) t.join();
        socorrista.join();

        System.out.println("Fin de la jornada en la piscina.");
    }
}
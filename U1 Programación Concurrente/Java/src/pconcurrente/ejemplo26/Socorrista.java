package pconcurrente.ejemplo26;

public class Socorrista implements Runnable {
    private final Piscina piscina;
    private final int numeroCambios;
    private final long milisegundosEntreCambios;

    public Socorrista(Piscina piscina, int numeroCambios, long milisegundosEntreCambios) {
        this.piscina = piscina;
        this.numeroCambios = numeroCambios;
        this.milisegundosEntreCambios = milisegundosEntreCambios;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numeroCambios; i++) {
                Thread.sleep(milisegundosEntreCambios);
                piscina.cambiarTurno();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
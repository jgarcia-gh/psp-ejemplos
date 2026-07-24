package pconcurrente.ejemplo24b;

public class SistemaIntercambio {

    public void intercambiarObjetos(InventarioJugador inventarioOrigen, InventarioJugador inventarioDestino) {

        if(inventarioOrigen.getID() < inventarioDestino.getID()){
            InventarioJugador aux = inventarioOrigen;
            inventarioOrigen = inventarioDestino;
            inventarioDestino = aux;
        }

        System.out.println(Thread.currentThread().getName()
                + " intenta bloquear el inventario de " + inventarioOrigen.getNombreJugador());
        inventarioOrigen.getLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " ha bloqueado el inventario de " + inventarioOrigen.getNombreJugador());

            // Pequeña pausa para facilitar que se produzca el interbloqueo al ejecutar el ejemplo
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName()
                    + " intenta bloquear el inventario de " + inventarioDestino.getNombreJugador());
            inventarioDestino.getLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()
                        + " ha bloqueado el inventario de " + inventarioDestino.getNombreJugador());

                inventarioOrigen.quitarObjeto();
                inventarioDestino.anadirObjeto();

                System.out.println(Thread.currentThread().getName() + " ha completado el intercambio: "
                        + inventarioOrigen.getNombreJugador() + " -> " + inventarioDestino.getNombreJugador());

            } finally {
                inventarioDestino.getLock().unlock();
            }
        } finally {
            inventarioOrigen.getLock().unlock();
        }
    }
}
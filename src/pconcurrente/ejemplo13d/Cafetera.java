package u2.ejemplo13d;

public class Cafetera implements Runnable {

    private int contador = 0;
    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try{
                // Comenzamos a preparar el café
                // Ponemos la cafetera
                Thread.sleep(200);
                // Servimos el café en la taza"
                Thread.sleep(200);
                // Echamos la leche
                Thread.sleep(200);
                // Café finalizado
                contador++;
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        }
    }
}

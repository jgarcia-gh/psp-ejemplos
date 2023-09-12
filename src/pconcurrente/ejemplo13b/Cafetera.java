package u2.ejemplo13b;

public class Cafetera implements Runnable {

    private int contador = 0;
    private boolean ejecutar = true;
    public void Detener(){
        ejecutar = false;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        while(ejecutar){
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
                System.out.println("Nº de cafés preparados: " + contador);
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        }
    }
}


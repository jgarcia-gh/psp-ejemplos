package pconcurrente.ejemplo3;

public class Cafetera extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("Café: Comenzamos a preparar el café");
            System.out.println("Café: Ponemos la cafetera");
            Thread.sleep(2000);
            System.out.println("Café: Servimos el café en la taza");
            Thread.sleep(2000);
            System.out.println("Café: Echamos la leche");
            Thread.sleep(2000);
            System.out.println("Café: Café finalizado");
        }catch (InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
    }
}

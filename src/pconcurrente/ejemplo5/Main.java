package u2.ejemplo5;

public class Main {

    public static void main(String[] args) {

        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        Runnable r = new Runnable(){
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
        };
        Thread t = new Thread(r);
        t.start();

        // Mientras tanto preparamos las tostadas
        try{
            PrepararTostadas();
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }
    }

    public static void PrepararTostadas() throws InterruptedException {
        System.out.println("Tostadas: Comenzamos a preparar las tostadas");
        System.out.println("Tostadas: Ponemos el pan a tostar");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos aceite");
        Thread.sleep(2000);
        System.out.println("Tostadas: Echamos sal");
        Thread.sleep(2000);
        System.out.println("Tostadas: Tostadas finalizadas");
    }
}

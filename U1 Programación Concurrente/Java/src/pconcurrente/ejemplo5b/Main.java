package pconcurrente.ejemplo5b;

/*
Pequeña variación sobre el ejemplo 5. En este caso la clase anónima se instancia directamente dentro del constructor
de la clase Thread.
 */
public class Main {

    public static void miRun(){

    }

    public static void main(String[] args) {

        // Preparamos el café, la ejecución se realizará en un nuevo hiloç
        Thread t = new Thread(new Runnable(){
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
        });
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

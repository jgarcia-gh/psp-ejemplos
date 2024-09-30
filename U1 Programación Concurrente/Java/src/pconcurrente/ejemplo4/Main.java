package pconcurrente.ejemplo4;

/*
Este ejemplo es equivalente al ejemplo 3, pero en este caso la clase Cafetera implementa la interfaz Runnable.
 */
public class Main {

    public static void main(String[] args) {
        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        Thread t = new Thread(new Cafetera());
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

package pconcurrente.ejemplo3;


/*
En este ejemplo vemos cómo podemos reducir el tiempo de ejecución haciendo uso de hilos.
El código que antes se ejecutaba en el método PrepararCafe, ahora se ejecuta en un hilo.
Para ello tenemos la clase Cafetera que hereda de la clase Thread.
 */
public class Main {

    public static void main(String[] args) {

        // Preparamos el café, la ejecución se realizará en un nuevo hilo
        Cafetera c = new Cafetera();
        c.start();

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

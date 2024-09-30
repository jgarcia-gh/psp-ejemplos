package pconcurrente.ejemplo3;


/*
Es importante saber cuándo debemos lanzar el hilo. En este ejemplo podemos ver que, si lanzamos el hilo
después de ejecutar el método PrepararTostadas, el programa tardará igualmente 12 segundos en ejecutarse.
En la práctica es como si hicieramos una ejecución secuencial, como en el ejemplo 2, y no estaríamos
aprovechando el beneficio de utilizar hilos.
 */
public class Main2 {
    public static void main(String[] args) {

        // Preparamos las tostadas
        try{
            PrepararTostadas();
        } catch(InterruptedException ie){
            System.out.println("Hilo interrumpido");
        }

        // Preparamos el café, la ejecución se realizará en un nuevo hilo pero no comenzará hasta que las tostadas no hayan finalizado
        Cafetera c = new Cafetera();
        c.start();

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

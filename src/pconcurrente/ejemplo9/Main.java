package u2.ejemplo9;

public class Main {
    public static void main(String[] args) {
        // Lanzamos un hilo que saluda 5 veces
        Thread t = new Thread(()->{
            try{
                for(int i = 0; i < 5; i++){
                    Thread.sleep(1000);
                    System.out.println("¡Hola! ¡Soy un hilo!");
                }
            }catch (InterruptedException ie){
                System.out.println("Hilo interrumpido");
            }
        });
        t.start();
        // Mostramos la información del hilo
        System.out.println("ID: " + t.getId());
        System.out.println("Nombre: " + t.getName());
        System.out.println("Prioridad: " + t.getPriority());
        System.out.println("Estado: " + t.getState());
        System.out.println("Está vivo: " + t.isAlive());
    }
}

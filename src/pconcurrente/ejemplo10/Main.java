package u2.ejemplo10;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // Obtenemos el objeto Thread del hilo en el que nos encontramos
        System.out.println("ID: " + t.getId());
        System.out.println("Nombre: " + t.getName());
        System.out.println("Prioridad: " + t.getPriority());
        System.out.println("Estado: " + t.getState());
        System.out.println("Está vivo: " + t.isAlive());
    }
}

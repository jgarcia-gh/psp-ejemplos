package u2.ejemplo15;

public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}


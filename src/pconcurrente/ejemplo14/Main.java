package u2.ejemplo14;

public class Main {
    public static void main(String[] args) {
        // Lanzamos 5 hilos contador
        for(int i = 1; i <= 5; i++){
            Contador c = new Contador();
            Thread t = new Thread(c);
            t.setName("Hilo " + i);
            t.start();
        }
    }
}


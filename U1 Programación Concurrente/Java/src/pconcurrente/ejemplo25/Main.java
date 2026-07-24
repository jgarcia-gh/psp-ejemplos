package pconcurrente.ejemplo25;

public class Main {

    public static void main(String[] args) {
        Contador c = new Contador();
        new Thread(()->{
            for(int i = 0; i < 100; i++){
                c.incrementar();
            }
        }).start();
    }
}

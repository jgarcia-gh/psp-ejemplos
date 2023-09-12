package u2.ejemplo25;

public class Contador implements Runnable {
    private int id;
    public Contador(int id){
        this.id = id;
    }
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println("Tarea " + id + ": " + i);
        }
    }
}

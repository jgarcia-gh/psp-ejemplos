package u2.ejemplo8;

public class Main {
    public static int contador = 1;
    public static void main(String[] args) {
        String texto = "elefante(s) se balanceaban ...";
        Thread t = new Thread(() -> {
                while(contador <= 5){
                    System.out.println(contador + " " + texto);
                    IncrementaContador();
                }
        });
        t.start();
    }
    public static void IncrementaContador(){
        contador++;
    }
}

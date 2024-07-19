package u2.ejemplo22;

public class PrepararLeche implements Runnable {

    private Taza taza;

    public PrepararLeche(Taza t) { taza = t;}

    @Override
    public void run() {
        try {
            System.out.println("Leche: Vertemos la leche en un cazo.");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Leche: Ponemos el cazo al fuego.");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Leche: Esperamos a que se caliente.");
            Thread.sleep((long)(Math.random()*3000));

            synchronized (taza){
                while(!taza.getHayCafe()){
                    System.out.println("Leche: Esperando el café ");
                    taza.wait();
                }
            }

            System.out.println("Leche: Servimos la leche en la taza.");
            taza.añadirIngrediente("con leche");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

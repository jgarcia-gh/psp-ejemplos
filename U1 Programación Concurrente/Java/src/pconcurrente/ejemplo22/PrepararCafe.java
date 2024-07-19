package u2.ejemplo22;

public class PrepararCafe implements Runnable {

    private Taza taza;

    public PrepararCafe(Taza t) { taza = t;}

    @Override
    public void run() {
        try {
            System.out.println("Café: Ponemos el café molido en la cafetera");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Café: Ponemos el agua");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Café: Encendemos el fuego");
            Thread.sleep((long)(Math.random()*3000));
            System.out.println("Café: Esperamos a que salga el café");
            Thread.sleep((long)(Math.random()*3000));

            synchronized (taza){
                System.out.println("Café: Servimos el café en la taza");
                taza.setHayCafe(true);
                taza.añadirIngrediente("café");
                taza.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

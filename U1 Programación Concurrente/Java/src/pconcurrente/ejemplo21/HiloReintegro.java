package pconcurrente.ejemplo21;

public class HiloReintegro implements Runnable {

	private Cuenta cuenta;
	
	public HiloReintegro(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo retira 1000 veces 100€
			synchronized (cuenta){
				while(cuenta.getSaldo() < 100){
					try {
						System.out.println("No hay saldo suficiente. Esperamos...");
						cuenta.wait();
						System.out.println("Ya se ha producido un ingreso.");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				cuenta.reintegrar(100);
				System.out.println("REINTEGRO. Saldo: " + cuenta.getSaldo());
			}
		}
	}
}

package u2.ejemplo19;

public class HiloReintegro implements Runnable {

	private Cuenta cuenta;
	
	public HiloReintegro(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo retira 1000 veces 100€
			cuenta.reintegrar(100);
		}
	}

}

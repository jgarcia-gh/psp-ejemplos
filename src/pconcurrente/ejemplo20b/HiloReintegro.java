package u2.ejemplo20b;

public class HiloReintegro implements Runnable {

	private Cuenta cuenta;
	private Object object;

	public HiloReintegro(Cuenta cuenta, Object object) {
		this.cuenta = cuenta;
		this.object = object;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo retira 1000 veces 100€
			synchronized (object){
				cuenta.reintegrar(100);
			}
		}
	}
}

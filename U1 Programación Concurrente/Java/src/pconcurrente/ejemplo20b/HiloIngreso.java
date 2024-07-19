package u2.ejemplo20b;

public class HiloIngreso implements Runnable {

	private Cuenta cuenta;
	private Object object;
	
	public HiloIngreso(Cuenta cuenta, Object object) {
		this.cuenta = cuenta;
		this.object = object;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo ingresa 1000 veces 100€
			synchronized (object){
				cuenta.ingresar(100);
			}
		}
	}

}

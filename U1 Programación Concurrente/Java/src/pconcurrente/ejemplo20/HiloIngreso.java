package u2.ejemplo20;

public class HiloIngreso implements Runnable {

	private Cuenta cuenta;
	
	public HiloIngreso(Cuenta cuenta) {
				this.cuenta = cuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			// Este hilo ingresa 1000 veces 100€
			synchronized (cuenta){
				cuenta.ingresar(100);
			}
		}
	}

}

package pconcurrente.ejemplo21;

/*
En este ejemplo se introduce el uso de notify y wait, de forma que HiloIngreso notifica a HiloReintegro cuando se ingresa dinero.
HiloReintegro ejecuta el método wait cuando no hay suficiente saldo para realizar el reintegro.
 */
public class Main {

	public static void main(String[] args) {

		// Creamos una única cuenta cuyo saldo inicial será de €.
		Cuenta c = new Cuenta();

		/* Creamos dos hilos, uno que se encargará de
		 * realizar los ingresos y otro que se encargará
		 * de realizar los reintegros.
		 */
		HiloIngreso hi = new HiloIngreso(c);
		HiloReintegro hr = new HiloReintegro(c);
		
		Thread ti = new Thread(hi);
		Thread tr = new Thread(hr);
		
		// Lanzamos los hilos
		ti.start();
		tr.start();
		
		try {
			// Esperamos a que los dos hilos finalicen
			ti.join();
			tr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*  Una vez finalizan mostramos el saldo final. En este
		 *  caso no hemos implementado la sincronización entre hilos.
		 *  El resultado debería ser 0€, sin embargo, debido a las condiciones de carrera
		 *  con cada ejecución se obtendrá un resultado diferente.
		*/
		System.out.println("Saldo final: " + c.getSaldo());
		
	}

}

package pconcurrente.ejemplo18;

/*
Este ejemplo sirve para demostrar los problemas que supone utilizar variables compartidas.
En este caso, existe una instancia de la clase Cuenta compartida entre dos hilos.
Cada hilo realiza 1000 ingresos y 1000 reintegros de 100 euros cada uno. El saldo final de la cuenta debería ser 0 euros,
pero tras varias ejecuciones podemos ver que cada vez arroja un resultado diferente.
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

package pconcurrente.ejemplo20b;

/*
Modificación del ejemplo 20 para demostrar que, como monitor, podemos utilizar cualquier objeto.
En este caso se crea una instancia de la clase Object. Lo importante es que dicho objeto sea
compartido entre los diferentes hilos para poder ser utilizado en un bloque sincronizado.
 */
public class Main {

	public static void main(String[] args) {

		// Creamos una única cuenta cuyo saldo inicial será de €.
		Cuenta c = new Cuenta();
		Object o = new Object();
		/* Creamos dos hilos, uno que se encargará de
		 * realizar los ingresos y otro que se encargará
		 * de realizar los reintegros.
		 */
		HiloIngreso hi = new HiloIngreso(c, o);
		HiloReintegro hr = new HiloReintegro(c, o);
		
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
		
		System.out.println("Saldo final: " + c.getSaldo());
		
	}

}

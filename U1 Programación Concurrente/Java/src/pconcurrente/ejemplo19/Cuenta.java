package u2.ejemplo19;

public class Cuenta {

	private double saldo = 0;

	public double getSaldo() {
		return saldo;
	}

	// Método para realizar ingresos
	public synchronized void ingresar(double cantidad) {
		saldo += cantidad;
	}

	// Método para realizar reintegros
	public synchronized void reintegrar (double cantidad) {
		saldo -= cantidad;
	}

}

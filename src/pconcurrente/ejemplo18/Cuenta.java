package u2.ejemplo18;

public class Cuenta {

	private double saldo = 0;

	public double getSaldo() {
		return saldo;
	}

	// Método para realizar ingresos
	public void ingresar(double cantidad) {
		saldo += cantidad;
	}

	// Método para realizar reintegros
	public void reintegrar (double cantidad) {
		saldo -= cantidad;
	}

}

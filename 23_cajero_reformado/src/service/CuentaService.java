package service;

public class CuentaService {
	/* Tiene que tener atributo para almacenar el saldo de la cuenta,
	 * constructores (al menos 2) que permitan inicializar la cuenta,
	 * métodos para extraer dinero a partir de una cantidad, ingresar dinero a partir de un cantidad
	 * y para mostrar el saldo actual  
	 */
	private double saldo;
	
	public CuentaService () {
		this.saldo=0.0; //no hace falta, por defecto los atributos se inicializan (double, a 0.0)
	}
	public CuentaService (double saldoinicial) {
		this.saldo=saldoinicial;
	}
	
	public double extraer (double cantidad) {
		return this.saldo-=cantidad;
	}
	public double ingresar (double cantidad) {
		return this.saldo+=cantidad;
	}
	public void consultarSaldo () {
		System.out.println("El saldo es de "+saldo+" euros.");		
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}

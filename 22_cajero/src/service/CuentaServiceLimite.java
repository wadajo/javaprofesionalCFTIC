package service;

public class CuentaServiceLimite extends CuentaService {
	private double limite;

	public CuentaServiceLimite() {
		super();
	}
	public CuentaServiceLimite(double saldoinicial) {
		super(saldoinicial);
	}	
	public CuentaServiceLimite (double saldoinicial, double limite) {
		super (saldoinicial);
		this.limite=limite;
	}
	
	@Override
	public void extraer (double cantidad) {
		if (cantidad<limite) {
			super.extraer(cantidad);
		} else {
			super.extraer(limite);
			System.out.println("Has superado tu límite. Solo has retirado "+limite+" euros.");
		}
	}
	@Override
	public void ingresar (double cantidad) {
		if (cantidad<limite) {
			super.ingresar(cantidad);			
		} else {
			super.ingresar(limite);
			System.out.println("Has superado tu límite. Solo has ingresado "+limite+" euros.");
		}
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
}

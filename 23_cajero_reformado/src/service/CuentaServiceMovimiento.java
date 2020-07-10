package service;

import java.util.ArrayList;

import model.Movimiento;

public class CuentaServiceMovimiento extends CuentaServiceLimite {
	private ArrayList<Movimiento> misMovimientos = new ArrayList<>();
	
	/*
	public CuentaServiceMovimiento() {
		super();
	}

	public CuentaServiceMovimiento(double saldoinicial) {
		super(saldoinicial);
	}
	*/
	
	public CuentaServiceMovimiento(double saldoinicial, double limite) {
		super(saldoinicial, limite);
	}	
	
	@Override
	public double extraer(double cantidad) {
		double resultado = super.extraer(cantidad);
		misMovimientos.add(new Movimiento(resultado,"-Extracción-"));
		return resultado;
	}

	@Override
	public double ingresar(double cantidad) {		
		double resultado = super.ingresar(cantidad);
		misMovimientos.add(new Movimiento(resultado,"-Ingreso-"));
		return resultado;
	}

	public ArrayList<Movimiento> mostrarMovimientos () {
		return misMovimientos;		
	}
}

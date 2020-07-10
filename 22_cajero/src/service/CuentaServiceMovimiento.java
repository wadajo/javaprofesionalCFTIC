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
	public void extraer(double cantidad) {
		Movimiento mExt = new Movimiento(cantidad>getLimite()?getLimite():cantidad,"-Extracción-");
		this.misMovimientos.add(mExt);		
		super.extraer(cantidad);
	}

	@Override
	public void ingresar(double cantidad) {		
		Movimiento mIng = new Movimiento(cantidad>getLimite()?getLimite():cantidad,"-Ingreso-");
		this.misMovimientos.add(mIng);
		super.ingresar(cantidad);
	}

	public ArrayList<Movimiento> mostrarMovimientos () {
		return misMovimientos;		
	}
}

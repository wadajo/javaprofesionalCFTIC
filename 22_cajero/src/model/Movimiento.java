package model;

public class Movimiento {
	private double dinero;
	private String tipoOperacion;
	
	public Movimiento(double dinero, String tipoOperacion) {
		super();
		this.dinero = dinero;
		this.tipoOperacion = tipoOperacion;
	}
	
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}	
}

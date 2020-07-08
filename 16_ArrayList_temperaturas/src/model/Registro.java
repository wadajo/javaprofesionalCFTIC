package model;

import java.time.LocalDateTime;

public class Registro {
	private double temperatura;
	private String ciudad;
	//private LocalDateTime fechaRegistro;
	
	public Registro(double temperatura, String ciudad) {
		this.temperatura = temperatura;
		this.ciudad = ciudad;
	}
	
	public double getTemperatura() {
		return temperatura;
	}	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/*
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	*/
	
}

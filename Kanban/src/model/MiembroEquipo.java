package model;

public class MiembroEquipo {
	private String nombre;
	private String puesto;
	
	public MiembroEquipo(String nombre, String puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	//Getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPuesto() {
		return this.puesto;
	}
}

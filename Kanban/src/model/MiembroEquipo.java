package model;

public class MiembroEquipo {
	private String nombre;
	private String puesto;
	private int idm;
	
	public MiembroEquipo(int idm, String nombre, String puesto) {
		this.idm = idm;
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	//Getters
	public int getId() {
		return this.idm;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPuesto() {
		return this.puesto;
	}
}

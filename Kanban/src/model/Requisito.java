package model;

public abstract class Requisito {
	private String idr;
	private String nombre;
	private String descripcion;
	private int prioridad;
	
	public Requisito(String id, String nombre, String descripcion, int prioridad) {
		this.idr = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
	}
	
	//Getters
	public String getId() {
		return this.idr;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}
}

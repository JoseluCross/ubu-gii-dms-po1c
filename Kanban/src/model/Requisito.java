package model;

public abstract class Requisito {
	private String id;
	private String nombre;
	private String descripcion;
	private int prioridad;
	
	public Requisito(String id, String nombre, String descripcion, int prioridad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
	}
	
	//Getters
	public String getId() {
		return this.id;
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
	
	@Override 
	public boolean equals(Object o) {
		if (o instanceof Requisito) {
			return ((Requisito)o).getId() == this.id;
		}
		return false;
	}
}

package com.ubu.lsi.kanban.model;

public abstract class Requisito {
	private int idr;
	private String nombre;
	private String descripcion;
	private int prioridad;
	
	public Requisito(int id, String nombre, String descripcion, int prioridad) {
		this.idr = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
	}
	
	//Getters
	public int getId() {
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
	
	@Override 
	public boolean equals(Object o) {
		if (o instanceof Requisito) {
			return ((Requisito)o).getId() == this.idr;
		}
		return false;
	}
}

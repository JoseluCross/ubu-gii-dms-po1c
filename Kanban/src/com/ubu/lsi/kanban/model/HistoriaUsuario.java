package com.ubu.lsi.kanban.model;

public class HistoriaUsuario extends Requisito {
	
	private String actor;
	
	public HistoriaUsuario(int id, String nombre, String descripcion, int prioridad, String actor) {
		super(id,nombre,descripcion,prioridad);
		this.actor = actor;
	}
	
	//Getters
	public String getActor() {
		return this.actor;
	}
}

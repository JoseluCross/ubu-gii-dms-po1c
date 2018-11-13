package com.ubu.lsi.kanban.model;

public class Defecto extends Requisito {
	
	private String commit;
	
	public Defecto(int id, String nombre, String descripcion, int prioridad,String commit) {
		super(id,nombre,descripcion,prioridad);
		this.commit = commit;
	}
	
	//Getters
	public String getCommit() {
		return this.commit;
	}
}
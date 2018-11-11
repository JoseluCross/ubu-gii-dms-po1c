package model;

public class HistoriaUsuario extends Requisito {
	
	private String actor;
	
	public HistoriaUsuario(String id, String nombre, String descripcion, int prioridad, String actor) {
		super(id,nombre,descripcion,prioridad);
		this.actor = actor;
	}
	
	//Getters
	public String getActor() {
		return this.actor;
	}
}

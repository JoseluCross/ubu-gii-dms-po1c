/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Clase para las Historias de Usuario.
 */
public class HistoriaUsuario extends Requisito {
	
	/*
	 * Actor.
	 */
	private String actor;
	
	/*
	 * Contructor de la Historia de Usuario.
	 * @param1: id, entero que representa el id dentro del sistema de Requisitos que tiene.
	 * @param2: nombre, String que contiene el nombre que se le da a la Historia de Usuario.
	 * @param3: descripcion, String que contiene la descripci�n de la Historia de Usuario.
	 * @param4: prioridad, entero que representa la prioridad que tiene la Historia de Usuario.
	 * @param5: actor, String que contiene el actor de la Historia de Usuario.
	 */
	public HistoriaUsuario(int id, String nombre, String descripcion, int prioridad, String actor) {
		super(id,nombre,descripcion,prioridad);
		this.actor = actor;
	}
	
	//Getters
	public String getActor() {
		return this.actor;
	}
}

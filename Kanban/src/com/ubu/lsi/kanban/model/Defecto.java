/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Clase para los Defectos.
 */
public class Defecto extends Requisito {
	
	/*
	 * String con el commit relacionado con el Defecto.
	 */
	private String commit;
	
	/*
	 * Constructor de Defecto.
	 * 
	 * @param1: id, entero que representa el id dentro del sistema de Requisitos que tiene.
	 * @param2: nombre, String que contiene el nombre que se le da al Defecto.
	 * @param3: descripcion, String que contiene la descripción del Defecto.
	 * @param4: prioridad, entero que representa la prioridad que tiene el Defecto.
	 * @param5: commit, String que contiene el commit al que está relacionado el Defecto.
	 */
	public Defecto(int id, String nombre, String descripcion, int prioridad,String commit) {
		super(id,nombre,descripcion,prioridad);
		this.commit = commit;
	}
	
	//Getters
	public String getCommit() {
		return this.commit;
	}
}

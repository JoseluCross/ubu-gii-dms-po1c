/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Enumeración con los posibles estados dentro de un SprintBacklog.
 */
public enum SprintStatus {
	PorHacer(0),
	Haciendo(1),
	Validacion(2),
	Completada(3);
	
	/*
	 * Número relacionado con el estado.
	 */
	private int num;
	
	/*
	 * Constructor.
	 */
	private SprintStatus(int num) {
		this.num = num;
	}
	
	//Getters
	public int getNum() {
		return this.num;
	}
}

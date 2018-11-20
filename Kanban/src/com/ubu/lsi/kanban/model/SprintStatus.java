/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Enumeraci�n con los posibles estados dentro de un SprintBacklog.
 */
public enum SprintStatus {
	PorHacer(0),
	Haciendo(1),
	Validacion(2),
	Completada(3);
	
	/*
	 * N�mero relacionado con el estado.
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

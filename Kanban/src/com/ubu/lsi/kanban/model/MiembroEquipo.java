/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Clase de los Miembros del Equipo.
 */
public class MiembroEquipo {
	
	/*
	 * Nombre del miembro.
	 */
	private String nombre;
	
	/*
	 * Puesto del miembro.
	 */
	private String puesto;
	
	/*
	 * Identificador del Miembro.
	 */
	private int idm;
	
	/*
	 * Constructor del Miembro de Equipo.
	 * 
	 * @param1: idm, entero que representa el identificador que tiene el miembro.
	 * @param2: nombre, String que contiene el nombre del miembro.
	 * @param3: puesto, String que contiene el puesto del miembro.
	 */
	public MiembroEquipo(int idm, String nombre, String puesto) {
		this.idm = idm;
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	//Getters
	public int getId() {
		return this.idm;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPuesto() {
		return this.puesto;
	}
}

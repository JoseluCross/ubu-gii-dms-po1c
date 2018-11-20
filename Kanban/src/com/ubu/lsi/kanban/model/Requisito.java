/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

/*
 * Clase abstracta de los Requisitos.
 */
public abstract class Requisito {
	
	/*
	 * Identificador del Requisito.
	 */
	private int idr;
	
	/*
	 * Nombre del Requisito.
	 */
	private String nombre;
	
	/*
	 * Descripci�n del Requisito.
	 */
	private String descripcion;
	
	/*
	 * Prioridad del Requisito.
	 */
	private int prioridad;
	
	/*
	 * Constructor del Requisito.
	 * 
	 * @param1: id, entero que representa el identificador del Requisito.
	 * @param2: nombre, String que contiene el nombre del Requisito.
	 * @param3: descripcion, String que contiene la descripci�n del Requisito.
	 * @param4: prioridad, entero que representa la prioridad del Requisito.
	 */
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

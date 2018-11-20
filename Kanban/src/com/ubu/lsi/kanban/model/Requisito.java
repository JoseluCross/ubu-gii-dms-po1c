/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
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
	 * Descripción del Requisito.
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
	 * @param3: descripcion, String que contiene la descripción del Requisito.
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

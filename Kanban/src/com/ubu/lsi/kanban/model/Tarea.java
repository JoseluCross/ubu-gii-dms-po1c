/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

import java.util.Objects;

/*
 * Clase de la Tareas.
 */
public class Tarea {
	
	/*
	 * Identificador de la Tarea.
	 */
	private int idt;
	
	/*
	 * Título de la Tarea.
	 */
	private String titulo;
	
	/*
	 * Descripción de la Tarea.
	 */
	private String descripcion;
	
	/*
	 * Coste de la Tarea.
	 */
	private int coste;
	
	/*
	 * Beneficio que aporta la Tarea.
	 */
	private int beneficio;
	
	/*
	 * Requisito con el que se relaciona la Tarea.
	 */
	private Requisito requisito;
	
	/*
	 * Miembro que hace la Tarea.
	 */
	private MiembroEquipo miembro;
	
	/*
	 * Constructor de la Tarea.
	 * 
	 * @param1: id, entero que representa la identificador de la Tarea.
	 * @param2: titulo, String que contiene el título de la Tarea.
	 * @param3: descripcion: String que contiene la descripción de la Tarea.
	 * @param4: coste, entero que representa el coste que tiene la Tarea.
	 * @param5: beneficio, entero que representa el beneficio que aporta la Tarea.
	 * @param6: requisito, Requisito con el que se relaciona la Tarea.
	 */
	public Tarea(int idt, String titulo, String descripcion, int coste, int beneficio, Requisito requisito) {
		if (requisito == null)
			throw new IllegalArgumentException("Toda tarea ha de estar asociada a un requisito");
		
		this.idt = idt;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.coste = coste;
		this.beneficio = beneficio;
		this.requisito = requisito;
	}
	
	/*
	 * Constructor de la Tarea.
	 * @param1: id, entero que representa la identificador de la Tarea.
	 * @param2: titulo, String que contiene el título de la Tarea.
	 * @param3: descripcion: String que contiene la descripción de la Tarea.
	 * @param4: coste, entero que representa el coste que tiene la Tarea.
	 * @param5: beneficio, entero que representa el beneficio que aporta la Tarea.
	 * @param6: requisito, Requisito con el que se relaciona la Tarea.
	 * @param7: miembro, Miembro que realiza la Tarea.
	 */
	public Tarea(int idt,String titulo, String descripcion, int coste, int beneficio, Requisito requisito, MiembroEquipo miembro) {
		this(idt, titulo, descripcion, coste, beneficio, requisito);
		this.miembro = miembro;
	}
	
	/*Getters*/
	
	public int getId() {
		return this.idt;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getCoste() {
		return this.coste;
	}
	
	public int getBeneficio() {
		return this.beneficio;
	}
	
	public Requisito getRequisito() {
		return this.requisito;
	}
	
	public MiembroEquipo getMiembroEquipo() {
		return this.miembro;
	}
	
	/*Setters*/
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
	
	public void setMiembro(MiembroEquipo miembro) {
		this.miembro = miembro;
	}
	
	public void setRequisito(Requisito requisito) {
		if (requisito == null)
			throw new IllegalArgumentException("Toda tarea ha de estar asociada a un requisito");
		this.requisito = requisito;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Tarea)
			return ((Tarea)o).getId()==this.idt;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idt);
	}

	
}

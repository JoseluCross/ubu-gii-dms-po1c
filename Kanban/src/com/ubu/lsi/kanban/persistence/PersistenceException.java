/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;

/*
 * Clase para la PersistenceExceptio hereda de Exception.
 */
public class PersistenceException extends Exception {

	/*
	 * Método de lanzamiento de la excepción.
	 */
	public PersistenceException(String string) {
		super(string);
	}
	
	/*
	 * Método de lanzamiento de la excepción.
	 */
	public PersistenceException(String s, Throwable t) {
		super(s, t);
	}
	
	/*
	 * Método de lanzamiento de la excepción.
	 */
	public PersistenceException() {
		super();
	}
	

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5245700347051184568L;

}

/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;

/*
 * Clase para la PersistenceExceptio hereda de Exception.
 */
public class PersistenceException extends Exception {

	/*
	 * M�todo de lanzamiento de la excepci�n.
	 */
	public PersistenceException(String string) {
		super(string);
	}
	
	/*
	 * M�todo de lanzamiento de la excepci�n.
	 */
	public PersistenceException(String s, Throwable t) {
		super(s, t);
	}
	
	/*
	 * M�todo de lanzamiento de la excepci�n.
	 */
	public PersistenceException() {
		super();
	}
	

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5245700347051184568L;

}

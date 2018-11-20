/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Clases abstracta de los Controladores
 */
public abstract class AbstractController {
	
	/*
	 * M�todo para dar persistencia
	 */
	protected Persistence persist;
	
	/*
	 * Constructor protected
	 */
	protected AbstractController(Persistence persist) {
		this.persist = persist;
	}
	
}

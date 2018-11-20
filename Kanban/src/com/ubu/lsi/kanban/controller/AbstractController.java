/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Clases abstracta de los Controladores
 */
public abstract class AbstractController {
	
	/*
	 * Método para dar persistencia
	 */
	protected Persistence persist;
	
	/*
	 * Constructor protected
	 */
	protected AbstractController(Persistence persist) {
		this.persist = persist;
	}
	
}

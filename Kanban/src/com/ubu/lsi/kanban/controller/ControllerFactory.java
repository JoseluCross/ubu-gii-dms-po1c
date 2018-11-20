/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz de la fábrica (AbstractFactory).
 */
public abstract class ControllerFactory {
	/*
	 * Método que nos devuelve el ControllerBacklog.
	 * 
	 * @return: ControlleBacklog
	 */
	public abstract ControllerBacklog getControllerBacklog();
	
	/*
	 * Método que nos devuelve el ControllerTarea.
	 * 
	 * @return: ControllerTarea.
	 */
	public abstract ControllerTarea getControllerTarea();
	
	/*
	 * Método que nos devuelve el ControllerMiembro.
	 * 
	 * @return: ControllerMiembro.
	 */
	public abstract ControllerMiembro getControllerMiembro();
	
	/*
	 * Método que nos devuelve el ControllerRequisito.
	 * 
	 * @return: ControllerRequisito.
	 */
	public abstract ControllerRequisito getControllerRequisito();


	/**
	 * Sistema de persistencia utilizado
	 */
	protected Persistence persitence;
	
	/**
	 * Constructor de la fábrica abstracta de controller.
	 * 
	 * @param persistence parámetro para obligar a la existencia de persistencia
	 */
	public ControllerFactory(Persistence persistence) {
		this.persitence = persistence;
	}
	
}

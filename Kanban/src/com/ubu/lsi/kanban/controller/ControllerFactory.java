/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz de la f�brica (AbstractFactory).
 */
public abstract class ControllerFactory {
	/*
	 * M�todo que nos devuelve el ControllerBacklog.
	 * 
	 * @return: ControlleBacklog
	 */
	public abstract ControllerBacklog getControllerBacklog();
	
	/*
	 * M�todo que nos devuelve el ControllerTarea.
	 * 
	 * @return: ControllerTarea.
	 */
	public abstract ControllerTarea getControllerTarea();
	
	/*
	 * M�todo que nos devuelve el ControllerMiembro.
	 * 
	 * @return: ControllerMiembro.
	 */
	public abstract ControllerMiembro getControllerMiembro();
	
	/*
	 * M�todo que nos devuelve el ControllerRequisito.
	 * 
	 * @return: ControllerRequisito.
	 */
	public abstract ControllerRequisito getControllerRequisito();


	/**
	 * Sistema de persistencia utilizado
	 */
	protected Persistence persitence;
	
	/**
	 * Constructor de la f�brica abstracta de controller.
	 * 
	 * @param persistence par�metro para obligar a la existencia de persistencia
	 */
	public ControllerFactory(Persistence persistence) {
		this.persitence = persistence;
	}
	
}

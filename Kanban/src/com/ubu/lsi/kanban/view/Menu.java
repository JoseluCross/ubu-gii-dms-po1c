/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;

import com.ubu.lsi.kanban.controller.ControllerFactory;

/*
 * Interfaz del men�.
 */
public abstract class Menu {
	
	/*
	 * M�todo para comenzar el men�.
	 * 
	 * @return: true si no ha ocurrido ning�n error.
	 */
	public abstract boolean start();
	
	protected ControllerFactory cf;
	
	/**
	 * Constructor de la vista
	 * 
	 * @param cf Fábrica abstracta con la familia de controladores
	 */
	protected Menu(ControllerFactory cf) {
		this.cf = cf;
	}

}

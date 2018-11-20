/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

/*
 * Interfaz de la f�brica (FactoryMethod).
 */
public interface ControllerFactory {
	/*
	 * M�todo que nos devuelve el ControllerBacklog.
	 * 
	 * @return: ControlleBacklog
	 */
	ControllerBacklog getControllerBacklog();
	
	/*
	 * M�todo que nos devuelve el ControllerTarea.
	 * 
	 * @return: ControllerTarea.
	 */
	ControllerTarea getControllerTarea();
	
	/*
	 * M�todo que nos devuelve el ControllerMiembro.
	 * 
	 * @return: ControllerMiembro.
	 */
	ControllerMiembro getControllerMiembro();
	
	/*
	 * M�todo que nos devuelve el ControllerRequisito.
	 * 
	 * @return: ControllerRequisito.
	 */
	ControllerRequisito getControllerRequisito();
	
}

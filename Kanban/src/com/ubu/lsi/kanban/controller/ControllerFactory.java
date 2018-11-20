/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

/*
 * Interfaz de la fábrica (FactoryMethod).
 */
public interface ControllerFactory {
	/*
	 * Método que nos devuelve el ControllerBacklog.
	 * 
	 * @return: ControlleBacklog
	 */
	ControllerBacklog getControllerBacklog();
	
	/*
	 * Método que nos devuelve el ControllerTarea.
	 * 
	 * @return: ControllerTarea.
	 */
	ControllerTarea getControllerTarea();
	
	/*
	 * Método que nos devuelve el ControllerMiembro.
	 * 
	 * @return: ControllerMiembro.
	 */
	ControllerMiembro getControllerMiembro();
	
	/*
	 * Método que nos devuelve el ControllerRequisito.
	 * 
	 * @return: ControllerRequisito.
	 */
	ControllerRequisito getControllerRequisito();
	
}

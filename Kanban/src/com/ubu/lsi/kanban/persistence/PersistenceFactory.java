/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;

/*
 * Interfaz de PersistenceFactory.
 */
public interface PersistenceFactory {

	/*
	 * M�todo que devuelve la persitencia.
	 * 
	 * @return: Persistence.
	 */
	Persistence getPersistence();
	
}

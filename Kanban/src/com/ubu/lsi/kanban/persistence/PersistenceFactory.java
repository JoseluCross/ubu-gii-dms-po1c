/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;

/*
 * Interfaz de PersistenceFactory.
 */
public interface PersistenceFactory {

	/*
	 * Método que devuelve la persitencia.
	 * 
	 * @return: Persistence.
	 */
	Persistence getPersistence();
	
}

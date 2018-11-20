/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;
import java.util.*;

/*
 * Clase abstracta Backlog para el ProductBacklog y el SprintBacklog.
 */
public abstract class Backlog {
	
	/*
	 * Lista de sets de tareas, ProductBacklog tendrá solo un set, mientras que el SprintBacklog tendrá 4.
	 */
	protected List<Set<Tarea>> log;
	
	/*
	 * Método que nos devuelve la lista de sets de tareas del Backlog.
	 * 
	 * @return: List<Set<Tarea>> lista de sets de tareas.
	 */
	public List<Set<Tarea>> getLista(){
		return this.log;
	}
}

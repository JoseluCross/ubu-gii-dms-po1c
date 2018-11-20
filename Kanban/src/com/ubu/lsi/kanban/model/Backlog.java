/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;
import java.util.*;

/*
 * Clase abstracta Backlog para el ProductBacklog y el SprintBacklog.
 */
public abstract class Backlog {
	
	/*
	 * Lista de sets de tareas, ProductBacklog tendr� solo un set, mientras que el SprintBacklog tendr� 4.
	 */
	protected List<Set<Tarea>> log;
	
	/*
	 * M�todo que nos devuelve la lista de sets de tareas del Backlog.
	 * 
	 * @return: List<Set<Tarea>> lista de sets de tareas.
	 */
	public List<Set<Tarea>> getLista(){
		return this.log;
	}
}

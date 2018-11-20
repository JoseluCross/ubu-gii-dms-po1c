/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

import java.util.*;

/*
 * Clase del ProductBacklog.
 */
public class ProductBacklog extends Backlog {
	
	/*
	 * Instancia del Singleton.
	 */
	private static ProductBacklog instance;
	
	/*
	 * M�todo para obtener una instancia de ProductBacklog.
	 * 
	 * @return: la instancia de ProductBacklog.
	 */
	public static ProductBacklog getInstance() {
		if(instance == null) {
			instance = new ProductBacklog();
		}
		return instance;
	}
	
	/*
	 * Constructor privado para el Singleton.
	 */
	private ProductBacklog() {
		super();
		super.log = new ArrayList<Set<Tarea>>(1);
		super.log.add(new HashSet<Tarea>());
	}
	
	/*
	 * M�todo que a�ade una tarea al ProductBackog.
	 * 
	 * @param: tarea, Tarea que se va a a�adir al ProductBacklog.
	 * @return: true si se ha a�adido correctamente.
	 */
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
}

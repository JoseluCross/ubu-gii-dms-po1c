/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
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
	 * Método para obtener una instancia de ProductBacklog.
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
	 * Método que añade una tarea al ProductBackog.
	 * 
	 * @param: tarea, Tarea que se va a añadir al ProductBacklog.
	 * @return: true si se ha añadido correctamente.
	 */
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
}

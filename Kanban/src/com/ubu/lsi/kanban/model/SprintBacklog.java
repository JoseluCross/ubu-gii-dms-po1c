/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.model;

import java.util.*;

/*
 * Clase de los SprintBacklogs.
 */
public class SprintBacklog extends Backlog {
	
	/*
	 * Fecha de inicio del Sprint.
	 */
	private Calendar start;
	
	/*
	 * Fecha de finalización del Sprint.
	 */
	private Calendar end;
	
	/*
	 * Identificador del Sprint.
	 */
	private int ids;
	
	/*
	 * Nombre del Sprint.
	 */
	private String nombre;
	
	/*
	 * Días por defecto que dura un Sprint.
	 */
	private static int DAYS=30;
	
	/*
	 * Constructor del SprintBacklog.
	 * 
	 * @param1: ids, entero que representa el identificador del Sprint.
	 * @param2: start, Calendar de la fecha de inicio.
	 * @param3: nombre, String que contiene el nombre del Sprint.
	 */
	public SprintBacklog(int ids, Calendar start, String nombre) {
		super();
		this.ids = ids;
		super.log = new ArrayList<Set<Tarea>>(4);
		//Por hacer ~ 0
		super.log.add(new HashSet<Tarea>());
		//Haciendo ~ 1
		super.log.add(new HashSet<Tarea>());
		//Validación ~ 2
		super.log.add(new HashSet<Tarea>());
		//Completadas ~ 3
		super.log.add(new HashSet<Tarea>());
		
		this.start = start;
		this.end = (Calendar) start.clone();
		this.end.add(Calendar.DATE,DAYS);
		this.nombre = nombre;
	}
	
	/*
	 * Constructor de Sprint sin fecha de inicio. Se coge la fecha actual como inicio.
	 * 
	 * @param1: ids, entero que representa el identificador del Sprint.
	 * @param2: nombre, String que contiene el nombre del Sprint.
	 */
	public SprintBacklog(int ids, String nombre) {
		this(ids, Calendar.getInstance(), nombre);
	}
	
	/*
	 * Método para añadir una tarea al Sprint. Por defecto se mete en Pr Hacer.
	 * 
	 * @param: tarea, Tarea a insertar en el Sprint.
	 * @return: true si se ha añadido correctamente la Tarea en el Sprint.
	 */
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
	
	/*
	 * Método que nos permite mover una tarea de un estado a otro dentro de un Sprint.
	 * 
	 * @param1: tarea, Tarea que se quiere mover dentro del Sprint.
	 * @param2: desde, SprintStatus estado desde el que se quiere mover.
	 * @param3: hacia, SprintStatus estado hacia el que se quiere mover.
	 * @return: true si se ha conseguido mover la tarea con éxito.
	 */
	public boolean moverTarea(Tarea tarea, SprintStatus desde, SprintStatus hacia) {
		if(!super.log.get(desde.getNum()).contains(tarea)){
			return false;
		}
		super.log.get(desde.getNum()).remove(tarea);
		super.log.get(hacia.getNum()).add(tarea);
		return true;
	}
	
	/*
	 * Método que nos devuelve la lista de tareas de un estado.
	 * 
	 * @param: opc, SprintStatus estado del cual se quiere recoger las tareas.
	 * @return: Set<Tarea> conjuto de tareas del estado pasado por parámetro.
	 */
	public Set<Tarea> getLista(SprintStatus opc){
		return super.log.get(opc.getNum());
	}
	
	//Getters
	public int getId() {
		return this.ids;
	}
	
	public Calendar getStart() {
		return this.start;
	}
	
	public Calendar getEnd() {
		return this.end;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

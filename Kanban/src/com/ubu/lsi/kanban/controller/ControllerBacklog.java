/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;
import java.util.Calendar;

import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz del Controlador de los Backlogs (ProductBacklog y SprintBacklog).
 */
public abstract class ControllerBacklog extends Controller<SprintBacklog> {
	/*
	 * M�todo que pone una tarea en un SprintBacklog.
	 * 
	 * @param1: sprint, entero del �ndice del sprint.
	 * @param2: tarea, entero del �ndice de la tarea.
	 * @return: true si se ha conseguido a�adir con �xito la tarea en el sprint.
	 */
	public abstract boolean tareaSprint(int sprint, int tarea);
	
	/*
	 * M�todo que nos permite mover una tarea dentro de los distintos estados de un Sprint.
	 * 
	 * @param1: sprint, entero del �ndice del sprint.
	 * @param2: desde, SprintStatus estado de la tarea que se quiere mover.
	 * @param3: hacia, SprintStatus estado al que se quiere mover la tarea.
	 * @param4: tarea, entero del �ndice de la tarea.
	 * @return: true si el cambio de estado se ha hecho correctamente.
	 */
	public abstract boolean moverEnSprint(int sprint, SprintStatus desde, SprintStatus hacia, int tarea);
	
	/*
	 * Constructor protected
	 */
	protected ControllerBacklog(Persistence persist) {
		super(persist);
	}
	
	/**
	 * Crea un nuevo sprint a partir de un nombre y una fecha
	 * 
	 * @param name nombre del sprint
	 * @param cal fecha de inicio
	 * @return sprint nuevo creado
	 */
	public abstract SprintBacklog crearSprint(String name, Calendar cal);
	
}

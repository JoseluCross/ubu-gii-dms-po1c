/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;
import java.util.Calendar;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz del Controlador de los Backlogs (ProductBacklog y SprintBacklog).
 */
public interface ControllerBacklog extends Controller<SprintBacklog> {
	/*
	 * Método que pone una tarea en un SprintBacklog.
	 * 
	 * @param1: sprint, entero del índice del sprint.
	 * @param2: tarea, entero del índice de la tarea.
	 * @return: true si se ha conseguido añadir con éxito la tarea en el sprint.
	 */
	boolean tareaSprint(int sprint, int tarea);
	
	/*
	 * Método que nos permite mover una tarea dentro de los distintos estados de un Sprint.
	 * 
	 * @param1: sprint, entero del índice del sprint.
	 * @param2: desde, SprintStatus estado de la tarea que se quiere mover.
	 * @param3: hacia, SprintStatus estado al que se quiere mover la tarea.
	 * @param4: tarea, entero del índice de la tarea.
	 * @return: true si el cambio de estado se ha hecho correctamente.
	 */
	boolean moverEnSprint(int sprint, SprintStatus desde, SprintStatus hacia, int tarea);
	SprintBacklog crearSprint(String name, Calendar cal);
	
}

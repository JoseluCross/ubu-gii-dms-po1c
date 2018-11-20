/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz View de las Tareas.
 */
public interface ViewTarea extends Mostrable<Tarea>{
	
	/*
	 * M�todo que nos permite crear una Tarea.
	 * 
	 * @return: true si la Tarea se ha creado de forma exitosa.
	 */
	public boolean crearTarea();
	
	/*
	 * Nos permite modificar una Tarea.
	 */
	public void modificarTarea();
	
	/*
	 * Muestra de forma reducida una Tarea.
	 * 
	 * @param: tarea, Tarea a mostrar.
	 */
	public void mostrarReducido(Tarea tarea);
	
	/*
	 * Muestra un conjunto de Tareas.
	 * 
	 * @param: tareas, Collection<Tarea> conjunto de tareas a mostrar.
	 */
	public void mostratTareas(Collection<Tarea> tareas);
}

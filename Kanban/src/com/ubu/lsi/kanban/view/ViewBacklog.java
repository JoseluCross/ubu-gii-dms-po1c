/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz del View de los Backlogs.
 */
public abstract class ViewBacklog extends View<Backlog>{
	
	/*
	 * Muestra de forma reducida un conjunto de Sprints.
	 * 
	 * @param: sp, Collection<SprintBacklog> conjunto de Sprints a mostrar de forma reducida.
	 */
	public abstract void mostrarReducido(Collection<SprintBacklog> sp);
	
}

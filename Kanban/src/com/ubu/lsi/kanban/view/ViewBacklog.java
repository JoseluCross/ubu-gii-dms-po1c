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
	 * Crea un nuevo Sprint.
	 */
	public abstract void nuevoSprint();
	
	/*
	 * M�todo que permite mover una tarea del ProductBacklog a un SprintBacklog.
	 * 
	 * @return: true si el movimiento no ha dado error.
	 */
	public abstract boolean moverProductSprint();
	
	/*
	 * M�todo que nos permite mover una tarea dentro de un mismo Sprint.
	 * 
	 * @return: true si se ha conseguido mover la tarea con �xito.
	 */
	public abstract boolean moverSprint();
	
	/*
	 * Muestra de forma reducida un conjunto de Sprints.
	 * 
	 * @param: sp, Collection<SprintBacklog> conjunto de Sprints a mostrar de forma reducida.
	 */
	public abstract void mostrarReducido(Collection<SprintBacklog> sp);
	
	/**
	 * {@inheritDoc}
	 * @param cf {@inheritDoc}
	 */
	protected ViewBacklog(ControllerFactory cf) {
		super(cf);
	}
}

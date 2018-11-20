/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz del View de los Backlogs.
 */
public interface ViewBacklog extends Mostrable<Backlog>{
	
	/*
	 * Crea un nuevo Sprint.
	 */
	public void nuevoSprint();
	
	/*
	 * Método que permite mover una tarea del ProductBacklog a un SprintBacklog.
	 * 
	 * @return: true si el movimiento no ha dado error.
	 */
	public boolean moverProductSprint();
	
	/*
	 * Método que nos permite mover una tarea dentro de un mismo Sprint.
	 * 
	 * @return: true si se ha conseguido mover la tarea con éxito.
	 */
	public boolean moverSprint();
	
	/*
	 * Muestra de forma reducida un conjunto de Sprints.
	 * 
	 * @param: sp, Collection<SprintBacklog> conjunto de Sprints a mostrar de forma reducida.
	 */
	public void mostrarReducido(Collection<SprintBacklog> sp);
}

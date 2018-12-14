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
 * Inerfaz del View de los Requisitos.
 */
public abstract class ViewRequisito extends View<Requisito>{
	
	
	/*
	 * Muestra un conjunto de Requisitos.
	 * 
	 * @return: requisitos, Collection<Requisito> conjunto de Requisitos  imprimir.
	 */
	public abstract void mostrarRequisitos(Collection<Requisito> requisitos);
	
	/*
	 * Muestra de forma reudicda un Requisito.
	 * 
	 * @param: Requisito a mostrar.
	 */
	public abstract void mostrarReducido(Requisito requisito);
	

}

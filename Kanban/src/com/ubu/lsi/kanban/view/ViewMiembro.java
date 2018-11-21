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
 * Interfaz View de Miembro.
 */
public abstract class ViewMiembro extends View<MiembroEquipo>{
	
	/*
	 * M�todo que nos permite crear un nuevo Miembor de Equipo.
	 * 
	 * @return: true si el miembro se ha creado correctamente.
	 */
	public abstract boolean crearMiembro();
	
	/*
	 * Muestra un conjunto de miembros.
	 * 
	 * @param: miembros, Collection<MiembroEquipo> conjunto de miembros a imprimir.
	 */
	public abstract void mostrarMiembros(Collection<MiembroEquipo> miembros);
	
	/*
	 * Muestra de forma reducida un miembro.
	 * 
	 * @param: miembro, Miembro a mostrar.
	 */
	public abstract void mostrarReducido(MiembroEquipo miembro);
	
	/**
	 * {@inheritDoc}
	 * @param cf {@inheritDoc}
	 */
	protected ViewMiembro(ControllerFactory cf) {
		super(cf);
	}
}

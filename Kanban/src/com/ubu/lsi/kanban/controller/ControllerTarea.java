/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz del Controlador de las Tareas.
 */
public abstract class ControllerTarea extends Controller<Tarea> {
	
	/*
	 * M�todo que nos permite crear una nueva Tarea.
	 * 
	 * @param1: titulo, String del t�tulo que se le quiere dar a la Tarea.
	 * @param2: descripcion, String de la descripci�n que se le quiere dar a la Tarea.
	 * @param3: coste, entero que representa el coste de la Tarea.
	 * @param4: beneficio, entero que representa el beneficio de la Tarea.
	 * @param5: requisito, entero que representa el �ndice del Requisito relacionado con la Tarea.
	 * @param6: miembro, entero que representa el �ndice del Miembro relacionado con la Tarea.
	 */
	public abstract boolean nuevaTarea(String titulo, String descripcion, int coste, int beneficio, int requisito, int miembro);
	
	/*
	 * M�todo que nos permite editar el Requisito de una Tarea.
	 * 
	 * @param1: t, Tarea que se quiere modificar.
	 * @param2: requisito, entero que representa el �ndice del Requisito relacionado con la Tarea.
	 * @return: true si la edici�n se realiza correctamente.
	 */
	public abstract boolean editarRequisito(Tarea t, int requisito);
	
	/*
	 * M�todo que nos permite asignar a una Tarea un Miembro. Tambi�n sirve para modificar este atributo.
	 * 
	 * @param1: t, Tarea que se quiere modificar.
	 * @param2: miembro, entero que representa el �ndice del Miembro relacionado con la Tarea.
	 * @return: true si la asignaci�n se realiza correctamente.
	 */
	public abstract boolean asignarMiembro(Tarea t, int miembro);
	
	/**
	 * Modifica una tarea haciendo su cambio permanente
	 * @param t tarea que se ha modificado
	 */
	public abstract void actualizaTarea(Tarea t);
	
	/*
	 * Constructor protected
	 */
	protected ControllerTarea(Persistence persist) {
		super(persist);
	}
	
}

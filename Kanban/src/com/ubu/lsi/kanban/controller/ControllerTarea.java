/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz del Controlador de las Tareas.
 */
public abstract class ControllerTarea extends Controller<Tarea> {
	
	/*
	 * Método que nos permite crear una nueva Tarea.
	 * 
	 * @param1: titulo, String del título que se le quiere dar a la Tarea.
	 * @param2: descripcion, String de la descripción que se le quiere dar a la Tarea.
	 * @param3: coste, entero que representa el coste de la Tarea.
	 * @param4: beneficio, entero que representa el beneficio de la Tarea.
	 * @param5: requisito, entero que representa el índice del Requisito relacionado con la Tarea.
	 * @param6: miembro, entero que representa el índice del Miembro relacionado con la Tarea.
	 */
	public abstract boolean nuevaTarea(String titulo, String descripcion, int coste, int beneficio, int requisito, int miembro);
	
	/*
	 * Método que nos permite editar el Requisito de una Tarea.
	 * 
	 * @param1: t, Tarea que se quiere modificar.
	 * @param2: requisito, entero que representa el índice del Requisito relacionado con la Tarea.
	 * @return: true si la edición se realiza correctamente.
	 */
	public abstract boolean editarRequisito(Tarea t, int requisito);
	
	/*
	 * Método que nos permite asignar a una Tarea un Miembro. También sirve para modificar este atributo.
	 * 
	 * @param1: t, Tarea que se quiere modificar.
	 * @param2: miembro, entero que representa el índice del Miembro relacionado con la Tarea.
	 * @return: true si la asignación se realiza correctamente.
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

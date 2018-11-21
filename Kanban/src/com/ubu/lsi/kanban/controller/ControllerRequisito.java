/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz del Controlador de los Requisitos.
 */
public abstract class ControllerRequisito extends Controller<Requisito> {
	
	/*
	 * Método que nos permite crear un nuevo Requisito.
	 * 
	 * @param1: tipo, entero que representa 0 si es HistoriaUsuario o 1 si es Defecto.
	 * @param2: nombre, String del nombre que se le quiere dar al Requisito.
	 * @param3: descripcion, String de la descripción que se le quiere dar al Requisito.
	 * @param4: prioridad, entero que representa la prioridad que se le da al Requisito.
	 * @param5: of, String que representa el actor en caso de las Historias de Usuario y commit en el caso de los Defectos.
	 * @return: true si se ha creado correctamente el Requisito.
	 */
	public abstract boolean nuevoRequisito(int tipo, String nombre, String descripcion, int prioridad, String of);
	
	/*
	 * Constructor protected
	 */
	protected ControllerRequisito(Persistence persist) {
		super(persist);
	}
	
}

/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.Requisito;

/*
 * Interfaz del Controlador de los Requisitos.
 */
public interface ControllerRequisito extends Controller<Requisito> {
	
	/*
	 * M�todo que nos permite crear un nuevo Requisito.
	 * 
	 * @param1: tipo, entero que representa 0 si es HistoriaUsuario o 1 si es Defecto.
	 * @param2: nombre, String del nombre que se le quiere dar al Requisito.
	 * @param3: descripcion, String de la descripci�n que se le quiere dar al Requisito.
	 * @param4: prioridad, entero que representa la prioridad que se le da al Requisito.
	 * @param5: of, String que representa el actor en caso de las Historias de Usuario y commit en el caso de los Defectos.
	 * @return: true si se ha creado correctamente el Requisito.
	 */
	boolean nuevoRequisito(int tipo, String nombre, String descripcion, int prioridad, String of);
	
}

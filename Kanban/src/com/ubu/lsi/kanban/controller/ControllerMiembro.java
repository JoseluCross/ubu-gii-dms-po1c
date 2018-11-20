/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz del Controlador de los miembros de equipo.
 */
public interface ControllerMiembro extends Controller<MiembroEquipo> {
	
	/*
	 * Método que nos permite crear un nuevo miembro.
	 * 
	 * @param1: nombre, String del nombre que se le quiere dar al miembro.
	 * @param2: puesto, String del puesto que se le quiere dar al miembro.
	 */
	boolean nuevoMiembro(String nombre, String puesto);
	
	
}

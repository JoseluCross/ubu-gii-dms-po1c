/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;

import com.ubu.lsi.kanban.controller.ControllerFactory;

/*
 * Interfaz para todas las vistas.
 */
public abstract class View<E> {
	
	public abstract void mostrar(E e);
	
}

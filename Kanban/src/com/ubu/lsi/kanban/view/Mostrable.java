/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;

/*
 * Interfaz para unir los m�todos mostrar.
 */
public interface Mostrable<E> {
	
	public void mostrar(E e);

}

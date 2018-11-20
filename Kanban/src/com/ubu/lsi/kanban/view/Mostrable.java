/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view;

/*
 * Interfaz para unir los métodos mostrar.
 */
public interface Mostrable<E> {
	
	public void mostrar(E e);

}

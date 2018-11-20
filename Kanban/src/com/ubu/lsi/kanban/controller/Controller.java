/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;
import java.util.*;

/*
 * Interfaz de los Controladores
 */
public interface Controller<E> {
	/*
	 * Método que devuelve la lista del Controlador.
	 * @return: lista de elementos que maneja el controlador.
	 */
	Collection<E> getList();
	
	/*
	 * Método que nos devuelve un elemento de la lista del controlador.
	 * 
	 * @param: Índice del elemento dentro de la lista.
	 * @return: Elemento de la lista del Controlador.
	 */
	E getElement(int index);

}

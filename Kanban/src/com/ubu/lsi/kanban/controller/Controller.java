/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;
import java.util.*;

import com.ubu.lsi.kanban.persistence.Persistence;

/*
 * Interfaz de los Controladores
 */
public abstract class Controller<E> {
	
	/*
	 * Método para dar persistencia
	 */
	protected Persistence persist;
	
	/*
	 * Constructor protected
	 */
	protected Controller(Persistence persist) {
		this.persist = persist;
	}
	
	/*
	 * Método que devuelve la lista del Controlador.
	 * @return: lista de elementos que maneja el controlador.
	 */
	public abstract Collection<E> getList();
	
	/*
	 * Método que nos devuelve un elemento de la lista del controlador.
	 * 
	 * @param: Índice del elemento dentro de la lista.
	 * @return: Elemento de la lista del Controlador.
	 */
	public abstract E getElement(int index);

}

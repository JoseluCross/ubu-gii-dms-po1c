/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.controller;
import java.util.*;

/*
 * Interfaz de los Controladores
 */
public interface Controller<E> {
	/*
	 * M�todo que devuelve la lista del Controlador.
	 * @return: lista de elementos que maneja el controlador.
	 */
	Collection<E> getList();
	
	/*
	 * M�todo que nos devuelve un elemento de la lista del controlador.
	 * 
	 * @param: �ndice del elemento dentro de la lista.
	 * @return: Elemento de la lista del Controlador.
	 */
	E getElement(int index);

}

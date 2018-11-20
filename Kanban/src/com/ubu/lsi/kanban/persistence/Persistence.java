/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;
import java.util.*;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz de la persistencia.
 */
public interface Persistence {
	
	/*
	 * M�todo para inicializar la persistencia.
	 * 
	 * @throws: PersistenceException.
	 */
	void start() throws PersistenceException;
	
	/*
	 * M�todo que guarda en los ficheros de persistencia todos los datos al finalizar la ejecuci�n (Opci�n 0 del men�).
	 * 
	 * @throws: PersistenceException;
	 */
	void save() throws PersistenceException;
	
	/*
	 * M�todo para realizar la configuraci�n
	 * 
	 * @param: options, Mapa<String,String> con las opciones.
	 */
	void config(Map<String,String> options);
	
	/*
	 * M�todo para cargar una Tarea por su identificador;
	 * 
	 * @param: idt, entero que representa el identificador de la Tarea.
	 * @return: Tarea que coincide con el identificador.
	 */
	Tarea loadTarea(int idt);
	
	/*
	 * M�todo que nos devuelve el siguiente identificador de la Tarea.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdt();
	
	/*
	 * M�todo que nos carga un Sprint.
	 * 
	 * @param: ids, entero que representa el identificador del Sprint.
	 * @return: SprintBacklog que coincide con el identificador.
	 */
	SprintBacklog loadSprint(int ids);
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Sprint.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIds();
	
	/*
	 * M�etodo que carga un Miembro.
	 * 
	 * @param: idm, entero que representa el identificador del miembro.
	 * @return: Miembro que coincide con el identificador.
	 */
	MiembroEquipo loadMiembro(int idm);
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Miembro.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdm();
	
	/*
	 * M�todo que carga un Requisito.
	 * 
	 * @param: idr, entero que representa el identificador del Requisito.
	 * @return: Requisito que coincide con el identificador.
	 */
	Requisito loadRequisito(int idr);
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Requisito.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdr();
	
	/*
	 * M�todo que devuelve los Sprints.
	 * 
	 * @return: Collection<SprintBacklog> conjunto de Sprints.
	 */
	Collection<SprintBacklog> loadSprints();
	
	/*
	 * M�todo que devuelve las Tareas.
	 * 
	 * @return: Collection<Tarea> conjunto de Tareas.
	 */
	Collection<Tarea> loadTareas();
	
	/*
	 * M�todo que devuelve los Miembros.
	 * 
	 * @return: Collection<Miembro> conjunto de Miembros.
	 */
	Collection<MiembroEquipo> loadMiembros();
	
	/*
	 * M�todo que devuelve los Requisitos.
	 * 
	 * @return: Collection<Requisito> conjunto de Requisitos.
	 */
	Collection<Requisito> loadRequisitos();
	
	/*
	 * M�todo para poner en el mapa la Tarea pasada.
	 * 
	 * @param: t, Tarea.
	 */
	void nuevaTarea(Tarea t);
	
	/*
	 * M�todo para poner en el mapa el Miembro pasado.
	 * 
	 * @param: m, MiembroEquipo.
	 */
	void nuevoMiembro(MiembroEquipo m);
	
	/*
	 * M�todo para poner en el mapa el Requisito pasado.
	 * 
	 * @param: r, Requisito.
	 */
	void nuevoRequisito(Requisito r);
	
	/*
	 * M�todo para poner en el mapa el Sprint pasado.
	 * 
	 * @param: s, SprintBacklog.
	 */
	void nuevoSprint(SprintBacklog s);

}

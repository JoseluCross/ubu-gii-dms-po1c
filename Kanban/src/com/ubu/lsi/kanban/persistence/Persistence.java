/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;
import java.util.*;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz de la persistencia.
 */
public interface Persistence {
	
	/*
	 * Método para inicializar la persistencia.
	 * 
	 * @throws: PersistenceException.
	 */
	void start() throws PersistenceException;
	
	/*
	 * Método que guarda en los ficheros de persistencia todos los datos al finalizar la ejecución (Opción 0 del menú).
	 * 
	 * @throws: PersistenceException;
	 */
	void save() throws PersistenceException;
	
	/*
	 * Método para realizar la configuración
	 * 
	 * @param: options, Mapa<String,String> con las opciones.
	 */
	void config(Map<String,String> options);
	
	/*
	 * Método para cargar una Tarea por su identificador;
	 * 
	 * @param: idt, entero que representa el identificador de la Tarea.
	 * @return: Tarea que coincide con el identificador.
	 */
	Tarea loadTarea(int idt);
	
	/*
	 * Método que nos devuelve el siguiente identificador de la Tarea.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdt();
	
	/*
	 * Método que nos carga un Sprint.
	 * 
	 * @param: ids, entero que representa el identificador del Sprint.
	 * @return: SprintBacklog que coincide con el identificador.
	 */
	SprintBacklog loadSprint(int ids);
	
	/*
	 * Método que nos devuelve el siguiente identificador del Sprint.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIds();
	
	/*
	 * Mñetodo que carga un Miembro.
	 * 
	 * @param: idm, entero que representa el identificador del miembro.
	 * @return: Miembro que coincide con el identificador.
	 */
	MiembroEquipo loadMiembro(int idm);
	
	/*
	 * Método que nos devuelve el siguiente identificador del Miembro.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdm();
	
	/*
	 * Método que carga un Requisito.
	 * 
	 * @param: idr, entero que representa el identificador del Requisito.
	 * @return: Requisito que coincide con el identificador.
	 */
	Requisito loadRequisito(int idr);
	
	/*
	 * Método que nos devuelve el siguiente identificador del Requisito.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	int newIdr();
	
	/*
	 * Método que devuelve los Sprints.
	 * 
	 * @return: Collection<SprintBacklog> conjunto de Sprints.
	 */
	Collection<SprintBacklog> loadSprints();
	
	/*
	 * Método que devuelve las Tareas.
	 * 
	 * @return: Collection<Tarea> conjunto de Tareas.
	 */
	Collection<Tarea> loadTareas();
	
	/*
	 * Método que devuelve los Miembros.
	 * 
	 * @return: Collection<Miembro> conjunto de Miembros.
	 */
	Collection<MiembroEquipo> loadMiembros();
	
	/*
	 * Método que devuelve los Requisitos.
	 * 
	 * @return: Collection<Requisito> conjunto de Requisitos.
	 */
	Collection<Requisito> loadRequisitos();
	
	/*
	 * Método para poner en el mapa la Tarea pasada.
	 * 
	 * @param: t, Tarea.
	 */
	void nuevaTarea(Tarea t);
	
	/*
	 * Método para poner en el mapa el Miembro pasado.
	 * 
	 * @param: m, MiembroEquipo.
	 */
	void nuevoMiembro(MiembroEquipo m);
	
	/*
	 * Método para poner en el mapa el Requisito pasado.
	 * 
	 * @param: r, Requisito.
	 */
	void nuevoRequisito(Requisito r);
	
	/*
	 * Método para poner en el mapa el Sprint pasado.
	 * 
	 * @param: s, SprintBacklog.
	 */
	void nuevoSprint(SprintBacklog s);

}

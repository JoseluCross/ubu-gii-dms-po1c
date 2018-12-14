/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.persistence;
import java.io.File;
import java.util.*;

import com.ubu.lsi.kanban.model.*;

/*
 * Interfaz de la persistencia.
 */
public abstract class Persistence {
	
	
	/*
	 * Identificadores de Tarea, Sprint, Miembro y Requisito.
	 */
	protected int idt;
	protected int ids;
	protected int idm;
	protected int idr;
	
	/*
	 * Mapa de la configuración.
	 */
	protected Map<String,String> config;
	
	/*
	 * Mapa de los Requisitos con su identificador.
	 */
	protected Map<Integer,Requisito> requisitos;
	
	/*
	 * Mapa de las Tareas con su identifcador.
	 */
	protected Map<Integer,Tarea> tareas;
	
	/*
	 * Mapa de los Sprints con su identificador.
	 */
	protected Map<Integer,SprintBacklog> sprints;
	
	/*
	 * Mapa de los Miembros con su identificador.
	 */
	protected Map<Integer,MiembroEquipo> miembros;
	
	/**
	 * Constructor donde se inicializan los mapas
	 */
	protected Persistence() {
		this.requisitos = new HashMap<>();
		this.tareas = new HashMap<>();
		this.sprints = new HashMap<>();
		this.miembros = new HashMap<>();
	}
	
	/*
	 * M�todo para inicializar la persistencia.
	 * 
	 * @throws: PersistenceException.
	 */
	public abstract void start() throws PersistenceException;
	
	/*
	 * M�todo que guarda en los ficheros de persistencia todos los datos al finalizar la ejecuci�n (Opci�n 0 del men�).
	 * 
	 * @throws: PersistenceException;
	 */
	public abstract void save() throws PersistenceException;
	
	/*
	 * M�todo para realizar la configuraci�n
	 * 
	 * @param: options, Mapa<String,String> con las opciones.
	 */
	public void config(Map<String, String> options) throws PersistenceException {
		try {
			String route = options.get("folder");
			//12route = route.replaceAll("\\/", File.separator);
			route = System.getProperty("user.home")+File.separator+route;
			System.out.println(route);

			options.put("folder",route);
			this.config = options;
		}catch(NullPointerException ex) {
			throw new PersistenceException("El atributo folder no existe en la configuración");
		}
	}
	
	/*
	 * M�todo para cargar una Tarea por su identificador;
	 * 
	 * @param: idt, entero que representa el identificador de la Tarea.
	 * @return: Tarea que coincide con el identificador.
	 */
	public Tarea loadTarea(int idt) {
		return tareas.get(idt);
	}
	
	/*
	 * M�todo que nos devuelve el siguiente identificador de la Tarea.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	public int newIdt() {
		this.idt++;
		return idt;
	}
	
	/*
	 * M�todo que nos carga un Sprint.
	 * 
	 * @param: ids, entero que representa el identificador del Sprint.
	 * @return: SprintBacklog que coincide con el identificador.
	 */
	public SprintBacklog loadSprint(int ids) {
		return sprints.get(ids);
	}
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Sprint.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	public int newIds() {
		this.ids++;
		return ids;
	}
	
	/*
	 * M�etodo que carga un Miembro.
	 * 
	 * @param: idm, entero que representa el identificador del miembro.
	 * @return: Miembro que coincide con el identificador.
	 */
	public MiembroEquipo loadMiembro(int idm) {
		return this.miembros.get(idm);
	}
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Miembro.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	public int newIdm() {
		this.idm++;
		return this.idm;
	}
	
	/*
	 * M�todo que carga un Requisito.
	 * 
	 * @param: idr, entero que representa el identificador del Requisito.
	 * @return: Requisito que coincide con el identificador.
	 */
	public Requisito loadRequisito(int idr) {
		return this.requisitos.get(idr);
	}
	
	/*
	 * M�todo que nos devuelve el siguiente identificador del Requisito.
	 * 
	 * @return: siguiente valor del identificador.
	 */
	public int newIdr() {
		this.idr++;
		return idr;
	}
	
	/*
	 * M�todo que devuelve los Sprints.
	 * 
	 * @return: Collection<SprintBacklog> conjunto de Sprints.
	 */
	public Collection<SprintBacklog> loadSprints() {
		return this.sprints.values();
	}
	
	/*
	 * M�todo que devuelve las Tareas.
	 * 
	 * @return: Collection<Tarea> conjunto de Tareas.
	 */
	public Collection<Tarea> loadTareas() {
		return this.tareas.values();
	}
	
	/*
	 * M�todo que devuelve los Miembros.
	 * 
	 * @return: Collection<Miembro> conjunto de Miembros.
	 */
	public Collection<MiembroEquipo> loadMiembros() {
		return this.miembros.values();
	}
	
	/*
	 * M�todo que devuelve los Requisitos.
	 * 
	 * @return: Collection<Requisito> conjunto de Requisitos.
	 */
	public Collection<Requisito> loadRequisitos() {
		return this.requisitos.values();
	}
	
	/*
	 * Almacena una tarea o la actualiza si ya existe.
	 * 
	 * @param: t, Tarea.
	 */
	public void nuevaTarea(Tarea t) {
		this.tareas.put(t.getId(), t);	
	}
	
	/*
	 * Almacena un miembro o lo actualiza si ya existe.
	 * 
	 * @param: m, MiembroEquipo.
	 */
	public void nuevoMiembro(MiembroEquipo m) {
		this.miembros.put(m.getId(), m);
	}
	
	/*
	 * Almacena un requisito o lo actualiza si ya existe.
	 * 
	 * @param: r, Requisito.
	 */
	public void nuevoRequisito(Requisito r) {
		this.requisitos.put(r.getId(), r);
	}
	
	/*
	 * Almacena un sprint o lo actualiza si ya existe
	 * 
	 * @param: s, SprintBacklog.
	 */
	public void nuevoSprint(SprintBacklog s) {
		this.sprints.put(s.getId(), s);
	}
	
	/*
	 * Método que nos devuelve el siguiente id.
	 * 
	 * @param: integer, Set<Integer> de los identificadores.
	 * @return: entero del siguiente identificador.
	 */
	protected int newID(Set<Integer> integer) {
		int max=0;
		for (Integer it : integer) {
			if (it.intValue() > max)
				max = it.intValue();
		}
		return max;
	}

}

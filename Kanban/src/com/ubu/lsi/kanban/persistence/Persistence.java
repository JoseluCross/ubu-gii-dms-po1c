package com.ubu.lsi.kanban.persistence;
import java.util.*;

import com.ubu.lsi.kanban.model.*;

public interface Persistence {
	
	void start() throws PersistenceException;
	void save() throws PersistenceException;
	void config(Map<String,String> options);
	Tarea loadTarea(int idt);
	int newIdt();
	SprintBacklog loadSprint(int ids);
	int newIds();
	MiembroEquipo loadMiembro(int idm);
	int newIdm();
	Requisito loadRequisito(int idr);
	int newIdr();
	
	Collection<SprintBacklog> loadSprints();
	Collection<Tarea> loadTareas();
	Collection<MiembroEquipo> loadMiembros();
	Collection<Requisito> loadRequisitos();
	
	void nuevaTarea(Tarea t);
	void nuevoMiembro(MiembroEquipo m);
	void nuevoRequisito(Requisito r);
	void nuevoSprint(SprintBacklog s);

}

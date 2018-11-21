package com.ubu.lsi.kanban.controller.basic;
import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerBacklog extends ControllerBacklog{
	
	
	protected BasicControllerBacklog(Persistence p) {
		super(p);
	}
	
	@Override
	public boolean tareaSprint(int sprint, int tarea) {
		Tarea t = persist.loadTarea(tarea);
		SprintBacklog sp = persist.loadSprint(sprint);
		if (t == null || sp == null)
			return false;
		
		ProductBacklog prod = ProductBacklog.getInstance();
		
		if(!prod.getLista().get(0).contains(t)) {
			return false;
		}
		prod.getLista().get(0).remove(t);
		sp.add(t);
		return true;
	}
	
	@Override
	public boolean moverEnSprint(int sprint, SprintStatus desde, SprintStatus hacia,int tarea) {
		Tarea t = persist.loadTarea(tarea);
		SprintBacklog sp = persist.loadSprint(sprint);
		if (t == null || sp == null)
			return false;
		return sp.moverTarea(t, desde, hacia);
	}
	
	@Override
	public SprintBacklog crearSprint(String name, Calendar cal) {
		int ids = this.persist.newIds();
		SprintBacklog sb;
		if (cal == null) {
			sb = new SprintBacklog(ids,name);
		}else {
			sb = new SprintBacklog(ids, cal, name);
		}
		persist.nuevoSprint(sb);
		return sb;
	}

	@Override
	public Collection<SprintBacklog> getList() {
		return this.persist.loadSprints();
	}

	@Override
	public SprintBacklog getElement(int index) {
		return this.persist.loadSprint(index);
	}	
	
}

package controller;
import java.util.*;

import model.*;
import persistence.Persistence;

public class ControllerBacklog extends AbstractController<SprintBacklog>{
	
	private static ControllerBacklog instance;
	
	private ControllerBacklog() {
		
	}
	
	public static ControllerBacklog getInstance() {
		if (instance == null)
			instance = new ControllerBacklog();
		return instance;
	}
	
	public boolean tareaSprint(int sprint, int tarea) {
		Tarea t = persist.loadTarea(tarea);
		SprintBacklog sp = persist.loadSprint(sprint);
		if (t == null || sp == null)
			return false;
		
		ProductBacklog prod = ProductBacklog.getInstance();
		
		if(!prod.getLista().get(0).contains(t)) {
			return false;
		}
		prod.getLista().remove(tarea);
		sp.add(t);
		return true;
	}
	
	protected void introducirTarea(Tarea tarea) {
		ProductBacklog prod = ProductBacklog.getInstance();
		prod.add(tarea);
	}
	
	public boolean moverEnSprint(int sprint, SprintStatus desde, SprintStatus hacia,int tarea) {
		Tarea t = persist.loadTarea(tarea);
		SprintBacklog sp = persist.loadSprint(sprint);
		if (t == null || sp == null)
			return false;
		return sp.moverTarea(t, desde, hacia);
	}
	
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
	
	public boolean moverEntreSprint(SprintBacklog sprint1, SprintBacklog sprint2, Tarea tarea, SprintStatus estoy) {
		if(!sprint1.getLista(estoy).contains(tarea)) {
			return false;
		}
		sprint1.getLista(estoy).remove(tarea);
		sprint2.add(tarea);
		return true;
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

package controller;
import java.util.Calendar;

import model.*;

public class ControllerBacklog {
	
	private static ControllerBacklog instance;
	
	private ControllerBacklog() {
		
	}
	
	public static ControllerBacklog getInstance() {
		if (instance == null)
			instance = new ControllerBacklog();
		return instance;
	}
	
	public boolean tareaSprint(SprintBacklog sprint, Tarea tarea) {
		ProductBacklog prod = ProductBacklog.getInstance();
		if(!prod.getLista().contains(tarea)) {
			return false;
		}
		prod.getLista().remove(tarea);
		sprint.add(tarea);
		return true;
	}
	
	public void introducirTarea(Tarea tarea) {
		ProductBacklog prod = ProductBacklog.getInstance();
		prod.add(tarea);
	}
	
	public boolean moverEnSprint(SprintBacklog sprint, SprintStatus desde, SprintStatus hacia,Tarea tarea) {
		return sprint.moverTarea(tarea, desde, hacia);
	}
	
	public SprintBacklog crearSprint(int ids, String name, Calendar cal) {
		if (cal == null) {
			return new SprintBacklog(ids,name);
		}
		return new SprintBacklog(ids, cal, name);
	}
	
	public boolean moverEntreSprint(SprintBacklog sprint1, SprintBacklog sprint2, Tarea tarea, SprintStatus estoy) {
		if(!sprint1.getLista(estoy).contains(tarea)) {
			return false;
		}
		sprint1.getLista(estoy).remove(tarea);
		sprint2.add(tarea);
		return true;
	}
}

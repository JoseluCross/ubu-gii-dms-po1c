package controller;
import model.*;
import persistence.Persistence;

public class ControllerTarea {
	
	private static ControllerTarea instance;
	private Persistence persist;
	
	private ControllerTarea() {
		
	}
	
	public static ControllerTarea getInstance() {
		if (instance == null)
			instance = new ControllerTarea();
		return instance;
	}
	
	public int nuevaTarea() {
		return persist.newIds();
	}
	
	public boolean asignarMiembro(int  tarea, int miembro) {
		MiembroEquipo m = persist.loadMiembro(miembro);
		Tarea t = persist.loadTarea(tarea);
		if (t == null)
			return false;
		t.setMiembro(m);
		return true;
	}
	
	public boolean quitarMiembro(int tarea) {
		Tarea t = persist.loadTarea(tarea);
		if (t == null)
			return false;
		t.setMiembro(null);
		return true;
	}
}

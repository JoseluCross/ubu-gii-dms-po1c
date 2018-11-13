package controller;
import model.*;

public class ControllerTarea {
	
	private static ControllerTarea instance;
	
	private ControllerTarea() {
		
	}
	
	public static ControllerTarea getInstance() {
		if (instance == null)
			instance = new ControllerTarea();
		return instance;
	}
	
	public void asignarMiembro(Tarea tarea, MiembroEquipo miembro) {
		tarea.setMiembro(miembro);
	}
	
	public void quitarMiembro(Tarea tarea) {
		tarea.setMiembro(null);
	}
}

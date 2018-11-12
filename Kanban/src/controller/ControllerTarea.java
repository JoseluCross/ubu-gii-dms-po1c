package controller;
import model.*;

public class ControllerTarea {
	public void asignarMiembro(Tarea tarea, MiembroEquipo miembro) {
		tarea.setMiembro(miembro);
	}
	
	public void quitarMiembro(Tarea tarea) {
		tarea.setMiembro(null);
	}
}

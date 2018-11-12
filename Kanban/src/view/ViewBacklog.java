package view;
import model.*;

public interface ViewBacklog {
	public void nuevoSprint();
	public void cerrarSprint(SprintBacklog sprint);
	public void mostrar(Backlog log);
	public boolean mover();
}

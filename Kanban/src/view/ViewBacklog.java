package view;
import model.*;

public interface ViewBacklog extends Mostrable<Backlog>{
	public void nuevoSprint();
	public void cerrarSprint(SprintBacklog sprint);
	public boolean mover();
}

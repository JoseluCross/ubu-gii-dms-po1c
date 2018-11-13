package view;
import java.util.Collection;

import model.*;

public interface ViewBacklog extends Mostrable<Backlog>{
	public void nuevoSprint();
	public void cerrarSprint(SprintBacklog sprint);
	public boolean moverProductSprint();
	public boolean moverSprint();
	public void mostrarReducido(Collection<SprintBacklog> sp);
}

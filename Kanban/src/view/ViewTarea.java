package view;
import model.*;
import java.util.Collection;

public interface ViewTarea extends Mostrable<Tarea>{
	public boolean crearTarea();
	public void modificarTarea();
	public void mostrarReducido(Tarea tarea);
	public void mostratTareas(Collection<Tarea> tareas);
}

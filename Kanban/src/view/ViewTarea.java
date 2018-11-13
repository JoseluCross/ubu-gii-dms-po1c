package view;
import model.*;

public interface ViewTarea extends Mostrable<Tarea>{
	public boolean crearTarea();
	public boolean modificarTarea(Tarea tarea);
}

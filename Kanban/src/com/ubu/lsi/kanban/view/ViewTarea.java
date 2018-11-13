package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

public interface ViewTarea extends Mostrable<Tarea>{
	public boolean crearTarea();
	public void modificarTarea();
	public void mostrarReducido(Tarea tarea);
	public void mostratTareas(Collection<Tarea> tareas);
}

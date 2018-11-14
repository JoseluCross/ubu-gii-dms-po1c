package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.*;

public interface ControllerTarea extends Controller<Tarea> {

	boolean nuevaTarea(String titulo, String descripcion, int coste, int beneficio, int requisito, int miembro);
	boolean editarRequisito(Tarea t, int requisito);
	boolean asignarMiembro(Tarea t, int miembro);
	
}

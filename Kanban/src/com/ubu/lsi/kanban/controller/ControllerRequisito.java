package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.Requisito;

public interface ControllerRequisito extends Controller<Requisito> {

	boolean nuevoRequisito(int tipo, String nombre, String descripcion, int prioridad, String of);
	
}

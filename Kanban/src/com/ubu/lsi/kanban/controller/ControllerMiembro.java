package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.model.*;

public interface ControllerMiembro extends Controller<MiembroEquipo> {

	boolean nuevoMiembro(String nombre, String puesto);
	
	
}

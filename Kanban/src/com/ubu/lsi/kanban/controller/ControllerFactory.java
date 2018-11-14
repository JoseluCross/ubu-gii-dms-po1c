package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

public interface ControllerFactory {

	ControllerBacklog getControllerBacklog();
	ControllerTarea getControllerTarea();
	ControllerMiembro getControllerMiembro();
	ControllerRequisito getControllerRequisito();
	
}

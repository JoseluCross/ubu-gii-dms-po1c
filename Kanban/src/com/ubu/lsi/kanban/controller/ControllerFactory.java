package com.ubu.lsi.kanban.controller;

public interface ControllerFactory {

	ControllerBacklog getControllerBacklog();
	ControllerTarea getControllerTarea();
	ControllerMiembro getControllerMiembro();
	ControllerRequisito getControllerRequisito();
	
}

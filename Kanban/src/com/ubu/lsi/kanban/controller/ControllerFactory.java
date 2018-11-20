package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

public abstract class ControllerFactory {

	public abstract ControllerBacklog getControllerBacklog();
	public abstract ControllerTarea getControllerTarea();
	public abstract ControllerMiembro getControllerMiembro();
	public abstract ControllerRequisito getControllerRequisito();
	
	protected Persistence persitence;
	
	public ControllerFactory(Persistence persistence) {
		this.persitence = persistence;
	}
	
}

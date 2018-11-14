package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

public abstract class AbstractController {

	protected Persistence persist;
	
	protected AbstractController(Persistence persist) {
		this.persist = persist;
	}
	
}

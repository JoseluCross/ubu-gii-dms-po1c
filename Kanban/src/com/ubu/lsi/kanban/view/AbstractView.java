package com.ubu.lsi.kanban.view;

import com.ubu.lsi.kanban.controller.ControllerFactory;

public abstract class AbstractView {
	
	protected ControllerFactory cf;
	
	public AbstractView(ControllerFactory cf) {
		this.cf = cf;
	}
}

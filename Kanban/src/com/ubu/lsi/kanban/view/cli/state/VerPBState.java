package com.ubu.lsi.kanban.view.cli.state;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.ProductBacklog;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliBacklog;

public class VerPBState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		CliBacklog.getInstance().mostrar(ProductBacklog.getInstance());
		
		return new MenuState();
	}

}

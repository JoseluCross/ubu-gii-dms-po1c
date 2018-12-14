package com.ubu.lsi.kanban.view.cli.state;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMiembro;

public class VerMiembroState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		CliMiembro.getInstance().mostrarMiembros(cf.getControllerMiembro().getList());
		return new MenuState();
	}

}

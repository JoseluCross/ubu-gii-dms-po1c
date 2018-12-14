package com.ubu.lsi.kanban.view.cli.state;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliRequisito;

public class VerRequisitoState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		CliRequisito.getInstance().mostrarRequisitos(cf.getControllerRequisito().getList());
		return new MenuState();
	}

}

package com.ubu.lsi.kanban.view.cli.state;

import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.ProductBacklog;
import com.ubu.lsi.kanban.model.SprintBacklog;
import com.ubu.lsi.kanban.view.ViewBacklog;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliBacklog;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class VerSprintState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
				
		SprintBacklog sb = seleccionarSprint(cf);
		if(sb != null)
			CliBacklog.getInstance().mostrar(sb);
		else
			System.err.println("El Sprint seleccionado no existe");
		return new MenuState();
	}
	
	/*
	 * M�todo que nos permite seleccionar un Sprint.
	 * 
	 * @return: SprintBacklog seleccionado.
	 */
	private SprintBacklog seleccionarSprint(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		int ids;
		CliBacklog.getInstance().mostrarReducido(cf.getControllerBacklog().getList());
		System.out.print("Elige que Sprint quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return cf.getControllerBacklog().getElement(ids);
	}

}

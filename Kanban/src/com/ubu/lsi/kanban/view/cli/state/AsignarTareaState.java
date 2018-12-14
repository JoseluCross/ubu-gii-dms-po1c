package com.ubu.lsi.kanban.view.cli.state;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerBacklog;
import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.ProductBacklog;
import com.ubu.lsi.kanban.model.SprintBacklog;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliBacklog;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class AsignarTareaState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		ProductBacklog pb = ProductBacklog.getInstance();
		Scanner sc = CliMenu.sc;
		int idt, ids;
		CliBacklog.getInstance().mostrar(pb);
		System.out.print("Introduzca el número del identificador de la tarea que quiere mover al Sprint: ");
		idt = sc.nextInt();
		sc.nextLine();
		ControllerBacklog cb = cf.getControllerBacklog();
		Collection<SprintBacklog> col = cb.getList();
		CliBacklog.getInstance().mostrarReducido(col);
		System.out.print("Introduzca el identificador del Sprint al que quieres mover esta tarea: ");
		ids = sc.nextInt();
		sc.nextLine();
		if(!cb.tareaSprint(ids, idt)) {
			System.err.println("No se ha podido asignar la tarea");
		}
		return new MenuState();
	}

}

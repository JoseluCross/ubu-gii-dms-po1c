package com.ubu.lsi.kanban.view.cli.state;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerBacklog;
import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.SprintBacklog;
import com.ubu.lsi.kanban.model.SprintStatus;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliBacklog;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class MoverTareaState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {

		Scanner sc = CliMenu.sc;
		int ids,idestado=0,idestfinal=0,idtarea;
		boolean flag = true;
		ControllerBacklog cb = cf.getControllerBacklog();
		Collection<SprintBacklog> listlog = cb.getList();
		CliBacklog.getInstance().mostrarReducido(listlog);
		System.out.print("Introduzca el identificador del Sprint del cuál desea mover un tarea: ");
		ids = Integer.parseInt(sc.nextLine());
		CliBacklog.getInstance().mostrar(cb.getElement(ids));
		while(flag) {
			System.out.print("Introduzca el identificador de la lista en la que est� la tarea que quiere mover: PorHacer[0], Haciendo[1], Validación[2], Completada[3]");
			idestado = Integer.parseInt(sc.nextLine());
			if (idestado >= 0 && idestado<=3) {
				flag = false;
			}else {
				System.out.println("Ha introducido mal el identifiacador del estado");
			}
		}
		flag = true;
		//this.mostrar(cb.getElement(ids));
		System.out.print("Introduzca el identificador de la tarea que quiere mover: ");
		idtarea = Integer.parseInt(sc.nextLine());
		while(flag) {
			System.out.print("Introduzca el identificador de la lista a donde quiere mover la tarea seleccionada: PorHacer[0], Haciendo[1], Validación[2], Completada[3]");
			idestfinal = Integer.parseInt(sc.nextLine());
			if (idestfinal >= 0 && idestfinal<=3) {
				flag = false;
			}else {
				System.out.println("Ha introducido mal el identifiacador del estado");
			}
		}
		if(!cb.moverEnSprint(ids, SprintStatus.values()[idestado], SprintStatus.values()[idestfinal], idtarea)) {
			System.err.println("No se ha podido mover de estado la tarea");
		}
		return new MenuState();
	
	}

}

package com.ubu.lsi.kanban.view.cli.state;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.controller.ControllerMiembro;
import com.ubu.lsi.kanban.controller.ControllerRequisito;
import com.ubu.lsi.kanban.controller.ControllerTarea;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;
import com.ubu.lsi.kanban.view.cli.CliMiembro;
import com.ubu.lsi.kanban.view.cli.CliRequisito;

public class CrearTareaState implements ViewState {

	
	@Override
	public ViewState haz(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		String titulo, desc;
		int coste, beneficio, idr = 0, idm = 0;
		ControllerTarea ct = cf.getControllerTarea();
		ControllerRequisito cr = cf.getControllerRequisito();
		ControllerMiembro cm = cf.getControllerMiembro();
		System.out.print("Introduzca el título que quiere dar a la nueva tarea: ");
		titulo = sc.nextLine();
		System.out.print("Introduzca la descripción de la tarea: ");
		desc = sc.nextLine();
		System.out.print("Introduzca el coste de la tarea: ");
		coste = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el beneficio de la tarea: ");
		beneficio = Integer.parseInt(sc.nextLine());
		Collection<Requisito> listreq = cr.getList();
		CliRequisito.getInstance().mostrarRequisitos(listreq);
		System.out.print("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
		idr = Integer.parseInt(sc.nextLine());
		Collection<MiembroEquipo> listmiembro = cm.getList();
		CliMiembro.getInstance().mostrarMiembros(listmiembro);
		System.out.print("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
		idm = Integer.parseInt(sc.nextLine());
		boolean res = ct.nuevaTarea(titulo, desc, coste, beneficio, idr, idm);
		if(!res)
			System.err.println("La tarea ha fallado al crearse, comprueba que tiene requisito");
		return new MenuState();
	}

}

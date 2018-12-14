package com.ubu.lsi.kanban.view.cli.state;

import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.Tarea;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;
import com.ubu.lsi.kanban.view.cli.CliTarea;

public class VerTareaState implements ViewState{

	@Override
	public ViewState haz(ControllerFactory cf) {
		Tarea tt = seleccionarTarea(cf);
		if(tt != null)
			CliTarea.getInstance().mostrar(tt);
		else
			System.err.println("La tarea seleccionado no existe");
		
		return new MenuState();
	}
	
	/*
	 * M�todo que nos permite seleccionar una Tarea,
	 * 
	 * @return: Tarea seleccionada.
	 */
	private Tarea seleccionarTarea(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		int ids;
		CliTarea.getInstance().mostrarTareas(cf.getControllerTarea().getList());
		System.out.print("Elige que Tarea quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return cf.getControllerTarea().getElement(ids);
	}

}

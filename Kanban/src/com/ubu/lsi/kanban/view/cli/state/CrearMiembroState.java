package com.ubu.lsi.kanban.view.cli.state;

import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.controller.ControllerMiembro;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class CrearMiembroState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		ControllerMiembro cm = cf.getControllerMiembro();
		String nombre, puesto;
		System.out.print("Introduzca el nombre del nuevo Miembro: ");
		nombre = sc.nextLine();
		System.out.print("Introduzca el puesto del nuevo Miembro: ");
		puesto = sc.nextLine();
		if(!cm.nuevoMiembro(nombre, puesto)) {
			System.err.println("El miembro no se ha creado");
		}
		return new MenuState();
	}

}

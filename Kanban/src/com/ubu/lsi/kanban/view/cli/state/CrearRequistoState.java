package com.ubu.lsi.kanban.view.cli.state;

import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.controller.ControllerRequisito;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class CrearRequistoState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		ControllerRequisito cr = cf.getControllerRequisito();
		String nombre, desc, of;
		int prioridad, tipo = 0;
		boolean flag = true;
		while (flag) {
			System.out.print("Desea que su Requisito sea una Historia de Usuario [0] o Defecto[1]: ");
			tipo = Integer.parseInt(sc.nextLine());
			if (tipo == 0 || tipo == 1) {
				flag = false;
			} else {
				System.out.println("Se ha introducido mal el número, ha de ser 0 o 1");
			}
		}
		System.out.print("Introduzca el nombre que le quiere dar al nuevo Requisito: ");
		nombre = sc.nextLine();
		System.out.print("Introduzca la descripción que le quiere dar al nuevo Requisito: ");
		desc = sc.nextLine();
		System.out.print("Introduzca la prioridad que le quiere dar el nuevo Requisito: ");
		prioridad = Integer.parseInt(sc.nextLine());
		if (tipo == 0) {
			System.out.print("Introduzca el actor que se quiere dar a la Historia de usuario: ");
		} else {
			System.out.print("Introduzca el commit con el que está relacionado el Defecto: ");
		}
		of = sc.nextLine();
		if(!cr.nuevoRequisito(tipo, nombre, desc, prioridad, of)) {
			System.err.println("El requisito no se ha creado");
		}
		return new MenuState();
	}

}

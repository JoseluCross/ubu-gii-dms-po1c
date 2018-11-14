package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.view.ViewMiembro;

public class CliMiembro implements ViewMiembro {

	private ControllerFactory cf;
	
	protected CliMiembro(ControllerFactory cf) {
		this.cf = cf;
	}
	
	@Override
	public boolean crearMiembro() {
		Scanner sc = CliMenu.sc;
		ControllerMiembro cm = cf.getControllerMiembro();
		String nombre, puesto;
		System.out.print("Introduzca el nombre del nuevo Miembro: ");
		nombre = sc.nextLine();
		System.out.print("Introduzca el puesto del nuevo Miembro: ");
		puesto = sc.nextLine();
		return cm.nuevoMiembro(nombre, puesto);
	}

	@Override
	public void mostrar(MiembroEquipo miembro) {
		System.out.println("MIEMBRO " + miembro.getId() +"{");
		System.out.println("Identificador: " + miembro.getId());
		System.out.println("Nombre: " + miembro.getNombre());
		System.out.println("Puesto: " + miembro.getPuesto());
		System.out.println("}");
	}

	@Override
	public void mostrarMiembros(Collection<MiembroEquipo> miembros) {
		System.out.println("IDENTIFICADOR\tNOMBRE\tPUESTO");
		for (MiembroEquipo miembro : miembros) {
			this.mostrarReducido(miembro);
		}
		
	}

	@Override
	public void mostrarReducido(MiembroEquipo miembro) {
		System.out.println(miembro.getId() + "\t\t" + miembro.getNombre() + "\t" + miembro.getPuesto());
	}

}

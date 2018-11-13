package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerMiembro;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.view.ViewMiembro;

public class CliMiembro implements ViewMiembro {

	private static CliMiembro instance;
	
	public static CliMiembro getInstance() {
		if(instance == null) {
			instance = new CliMiembro();
		}
		return instance;
	}
	
	private CliMiembro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean crearMiembro() {
		Scanner sc = CliMenu.sc;
		ControllerMiembro cm = ControllerMiembro.getInstance();
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

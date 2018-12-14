/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.view.ViewMiembro;

/*
 * Clase del Cli del Miembro.
 */
public class CliMiembro extends ViewMiembro {


	private static CliMiembro instance;
	
	private CliMiembro() {
		
	}
	
	public static CliMiembro getInstance() {
		if (instance == null)
			instance = new CliMiembro();
		return instance;
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

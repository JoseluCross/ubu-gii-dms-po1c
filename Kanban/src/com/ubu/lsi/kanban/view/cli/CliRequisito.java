/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.Defecto;
import com.ubu.lsi.kanban.model.HistoriaUsuario;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.view.ViewRequisito;

/*
 * Clase del Cli de los Requisitos.
 */
public class CliRequisito extends ViewRequisito {

	private static CliRequisito instance;
	
	private CliRequisito() {
		
	}
	
	public static CliRequisito getInstance() {
		if (instance == null)
			instance = new CliRequisito();
		return instance;
	}

	@Override
	public void mostrar(Requisito requisito) {
		System.out.println("REQUISITO" + requisito.getId() + "{");
		System.out.println("Identificador: " + requisito.getId());
		System.out.println("Nombre: " + requisito.getNombre());
		System.out.println("Descripción: " + requisito.getDescripcion());
		System.out.println("Prioridad: " + requisito.getPrioridad());
		System.out.println("}");
	}

	@Override
	public void mostrarRequisitos(Collection<Requisito> requisitos) {
		System.out.println("ID\tNOMBRE\t\tPRIORIDAD\tTIPO\t\t\tDATOS ADICIONALES");
		for (Requisito requisito : requisitos) {
			this.mostrarReducido(requisito);
		}
	}

	@Override
	public void mostrarReducido(Requisito requisito) {
		System.out.print(requisito.getId() + "\t" + requisito.getNombre() + "\t\t" + requisito.getPrioridad());
		if (requisito instanceof HistoriaUsuario) {
			HistoriaUsuario aux = (HistoriaUsuario) requisito;
			System.out.println("\t\tHistoria de Usuario\tActor: " + aux.getActor());
		} else {
			Defecto aux2 = (Defecto) requisito;
			System.out.println("\t\tDefecto\t\t\tcommit: " + aux2.getCommit());
		}
	}
}

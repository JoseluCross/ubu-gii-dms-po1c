/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.*;

/*
 * Clase del Cli de la Tareas.
 */
public class CliTarea extends ViewTarea {

	private static CliTarea instance;
	
	private CliTarea() {
		
	}
	
	public static CliTarea getInstance() {
		if (instance == null)
			instance = new CliTarea();
		return instance;
	}

	@Override
	public void mostrar(Tarea tarea) {
		System.out.println("TAREA" + tarea.getId() + "{");
		System.out.println("Identificador: " + tarea.getId());
		System.out.println("Título: " + tarea.getTitulo());
		System.out.println("Descripción: " + tarea.getDescripcion());
		System.out.println("Coste: " + tarea.getCoste());
		System.out.println("Beneficio: " + tarea.getBeneficio());
		CliRequisito.getInstance().mostrar(tarea.getRequisito());
		CliMiembro.getInstance().mostrar(tarea.getMiembroEquipo());
		System.out.println("}");
	}

	@Override
	public void mostrarReducido(Tarea tarea) {
		System.out.println(tarea.getId() + "\t\t" + tarea.getTitulo());
	}

	@Override
	public void mostrarTareas(Collection<Tarea> tareas) {
		System.out.println("IDENTIFICADOR\tTÍTULO");
		for (Tarea tarea : tareas) {
			this.mostrarReducido(tarea);
		}
	}
}

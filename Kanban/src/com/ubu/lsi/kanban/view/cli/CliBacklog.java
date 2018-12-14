/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.ViewBacklog;
import com.ubu.lsi.kanban.view.ViewTarea;

/*
 * Clase del Cli de los Backlogs.
 */
public class CliBacklog extends ViewBacklog {
	
	
	private static CliBacklog instance;
	
	private CliBacklog() {
		
	}
	
	public static CliBacklog getInstance() {
		if (instance == null)
			instance = new CliBacklog();
		return instance;
	}

	@Override
	public void mostrar(Backlog log) {
		SprintStatus[] spt = {SprintStatus.PorHacer,SprintStatus.Haciendo,SprintStatus.Validacion,SprintStatus.Completada};
		if(log instanceof ProductBacklog) {
			System.out.println("PRODUCTBACKLOG");
		}else {
			System.out.println("SPRINTBACKLOG " + ((SprintBacklog)log).getNombre());
		}
		int i = 0;
		for (Set<Tarea> st : log.getLista()) {
			if(log instanceof SprintBacklog) {
				System.out.println(spt[i]);
			}
			System.out.println("IDENTIFICADOR\tTÍTULO");
			for( Tarea t : st) {
				CliTarea.getInstance().mostrarReducido(t);
			}
			i++;
		}
			
	}

	@Override
	public void mostrarReducido(Collection<SprintBacklog> sp) {
		System.out.println("IDENTIFICADOR\tNOMBRE");
		for (SprintBacklog sb : sp) {
			if (sb.getEnd().after(Calendar.getInstance())) {
				System.out.println(sb.getId() + "\t\t" + sb.getNombre());
			}
		}
	}
}

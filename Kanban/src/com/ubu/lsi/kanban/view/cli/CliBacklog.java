 

package com.ubu.lsi.kanban.view.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.AbstractView;
import com.ubu.lsi.kanban.view.ViewBacklog;
import com.ubu.lsi.kanban.view.ViewTarea;

public class CliBacklog extends AbstractView implements ViewBacklog {

	private ViewTarea vt;
	
	protected CliBacklog(ControllerFactory cf, ViewTarea vt) {
		super(cf);
		this.vt = vt;
	}
	
	@Override
	public void nuevoSprint() {
		Scanner sc = CliMenu.sc;
		boolean flag = true;
		String res = null;
		String fini,nom;
		Calendar ini = Calendar.getInstance();
		while(flag) {
			System.out.print("Desea introducir otra fecha de inicio que no sea el día de hoy?[s/n]");
			res = sc.nextLine();
			if (res.equals("s") || res.equals("n")) {
				flag = false;
			}
		}
		if (res.equals("n")) {
			flag = true;
			while(flag) {
				System.out.print("Qúe fecha quiere que empiece el sprint? [dd-mm-aaaa]");
				fini = sc.nextLine();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					ini.setTime(sdf.parse(fini));
					flag = false;
				}catch(ParseException ex) {
					System.out.println("El formato introducido es erróneo");
				}
			}
		}
		System.out.print("Introduzca el nombre del Sprint: ");
		nom = sc.nextLine();
		ControllerBacklog cb = cf.getControllerBacklog();
		SprintBacklog sp = cb.crearSprint(nom, ini);
		this.mostrar(sp);
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
				vt.mostrarReducido(t);
			}
			i++;
		}
			
	}

	@Override
	public boolean moverProductSprint() {
		ProductBacklog pb = ProductBacklog.getInstance();
		Scanner sc = CliMenu.sc;
		int idt, ids;
		this.mostrar(pb);
		System.out.print("Introduzca el número del identificador de la tarea que quiere mover al Sprint: ");
		idt = sc.nextInt();
		sc.nextLine();
		ControllerBacklog cb = cf.getControllerBacklog();
		Collection<SprintBacklog> col = cb.getList();
		this.mostrarReducido(col);
		System.out.print("Introduzca el identificador del Sprint al que quieres mover esta tarea: ");
		ids = sc.nextInt();
		sc.nextLine();
		return cb.tareaSprint(ids, idt);
	}

	@Override
	public boolean moverSprint() {
		Scanner sc = CliMenu.sc;
		int ids,idestado=0,idestfinal=0,idtarea;
		boolean flag = true;
		ControllerBacklog cb = cf.getControllerBacklog();
		Collection<SprintBacklog> listlog = cb.getList();
		this.mostrarReducido(listlog);
		System.out.print("Introduzca el identificador del Sprint del cuál desea mover un tarea: ");
		ids = sc.nextInt();
		this.mostrar(cb.getElement(ids));
		while(flag) {
			System.out.print("Introduzca el identificador de la lista en la que está la tarea que quiere mover: PorHacer[0], Haciendo[1], Validación[2], Completada[3]");
			idestado = sc.nextInt();
			if (idestado >= 0 && idestado<=3) {
				flag = false;
			}else {
				System.out.println("Ha introducido mal el identifiacador del estado");
			}
		}
		sc.nextLine();
		flag = true;
		//this.mostrar(cb.getElement(ids));
		System.out.print("Introduzca el identificador de la tarea que quiere mover: ");
		idtarea = sc.nextInt();
		while(flag) {
			System.out.print("Introduzca el identificador de la lista a donde quiere mover la tarea seleccionada: PorHacer[0], Haciendo[1], Validación[2], Completada[3]");
			idestfinal = sc.nextInt();
			if (idestfinal >= 0 && idestfinal<=3) {
				flag = false;
			}else {
				System.out.println("Ha introducido mal el identifiacador del estado");
			}
		}
		sc.nextLine();
		return cb.moverEnSprint(ids, SprintStatus.values()[idestado], SprintStatus.values()[idestfinal], idtarea);
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

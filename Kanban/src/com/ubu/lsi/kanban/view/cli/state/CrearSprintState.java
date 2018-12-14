package com.ubu.lsi.kanban.view.cli.state;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerBacklog;
import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.SprintBacklog;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliBacklog;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class CrearSprintState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
		Scanner sc = CliMenu.sc;
		boolean flag = true;
		String res = null;
		String fini,nom;
		Calendar ini = Calendar.getInstance();
		while(flag) {
			System.out.print("Desea introducir otra fecha de inicio que no sea el día de hoy?[s/n]: ");
			res = sc.nextLine();
			if (res.equals("s") || res.equals("n")) {
				flag = false;
			}
		}
		if (res.equals("n")) {
			flag = true;
			while(flag) {
				System.out.print("¿Qué fecha quiere que empiece el sprint? [dd-mm-aaaa]: ");
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
		CliBacklog.getInstance().mostrar(sp);
		
		return new MenuState();
	}

}

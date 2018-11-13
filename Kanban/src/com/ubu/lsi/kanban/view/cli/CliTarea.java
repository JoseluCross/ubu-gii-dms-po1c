package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerMiembro;
import com.ubu.lsi.kanban.controller.ControllerRequisito;
import com.ubu.lsi.kanban.controller.ControllerTarea;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.ViewTarea;

public class CliTarea implements ViewTarea {

	private static CliTarea instance;

	public static CliTarea getInstance() {
		if (CliTarea.instance == null) {
			instance = new CliTarea();
		}
		return instance;
	}

	private CliTarea() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crearTarea() {
		Scanner sc = CliMenu.sc;
		String titulo, desc;
		int coste, beneficio, idr = 0, idm = 0;
		ControllerTarea ct = ControllerTarea.getInstance();
		ControllerRequisito cr = ControllerRequisito.getInstance();
		ControllerMiembro cm = ControllerMiembro.getInstance();
		CliRequisito clr = CliRequisito.getInstance();
		CliMiembro clm = CliMiembro.getInstance();
		System.out.println("Introduzca el t�tulo que quiere dar a la nueva tarea: ");
		titulo = sc.nextLine();
		System.out.println("Introduzca la descripci�n de la tarea: ");
		desc = sc.nextLine();
		System.out.println("Introduzca el coste de la tarea: ");
		coste = sc.nextInt();
		System.out.println("Introduzca el beneficio de la tarea: ");
		beneficio = sc.nextInt();
		Collection<Requisito> listreq = cr.getList();
		clr.mostrarRequisitos(listreq);
		System.out.println("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
		idr = sc.nextInt();
		Collection<MiembroEquipo> listmiembro = cm.getList();
		clm.mostrarMiembros(listmiembro);
		System.out.println("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
		idm = sc.nextInt();
		return ct.nuevaTarea(titulo, desc, coste, beneficio, idr, idm);
	}

	@Override
	public void modificarTarea() {
		Scanner sc = CliMenu.sc;
		ControllerTarea ct = ControllerTarea.getInstance();
		ControllerRequisito cr = ControllerRequisito.getInstance();
		ControllerMiembro cm = ControllerMiembro.getInstance();
		CliRequisito clr = CliRequisito.getInstance();
		CliMiembro clm = CliMiembro.getInstance();
		int id, opc = 0, idr, idm;
		boolean flag = true, mod = true, flag2 = true;
		String seguir = null;

		Collection<Tarea> tareas = ct.getList();
		this.mostratTareas(tareas);
		System.out.println("Introduzca el identificador de la Tarea que desa modificar: ");
		id = sc.nextInt();
		Tarea tarea = ct.getElement(id);
		while (mod) {
			System.out.println("La tarea que quiere modificar es la siguiente: ");
			this.mostrar(tarea);
			while (flag) {
				System.out.println(
						"Introduzca el valor relacionado con el cambio que desea hacer: T�tulo[0], Descripci�n[1], Coste[2], Beneficio[3], Requisito[4] y Miembro[5]");
				opc = sc.nextInt();
				if (opc >= 0 && opc <= 5) {
					flag = false;
				}
			}
			switch (opc) {
			case 0:
				System.out.println("Introduzca el nuevo t�tulo que se quiere dar a la tarea. (el t�tulo actual es: "
						+ tarea.getTitulo() + ")");
				tarea.setTitulo(sc.nextLine());
				break;
			case 1:
				System.out.println(
						"Introduzca la nueva descripci�n que se quiere dar a la tarea. (la descripci�n actual es: "
								+ tarea.getDescripcion() + ")");
				tarea.setDescripcion(sc.nextLine());
				break;
			case 2:
				System.out.println("Introduzca el nuevo coste que se quiere dar a la tarea. (el coste actual es: "
						+ tarea.getCoste() + ")");
				tarea.setCoste(sc.nextInt());
				break;
			case 3:
				System.out
						.println("Introduzca el nuevo beneficio que se quiere dar a la tarea. (el beneficio actual es: "
								+ tarea.getBeneficio() + ")");
				tarea.setBeneficio(sc.nextInt());
				break;
			case 4:
				System.out.println("Estos son los Requisitos que se pueden asignar a una tarea: ");
				Collection<Requisito> listreq = cr.getList();
				clr.mostrarRequisitos(listreq);
				System.out.println("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
				idr = sc.nextInt();
				if (!ct.editarRequisito(tarea, idr)) {
					System.out.println("El Requisito seleccionado no es posible.");
				}
				break;
			case 5:
				System.out.println("Estos son los Miembros que se pueden asignar a una tarea: ");
				Collection<MiembroEquipo> listmiembro = cm.getList();
				clm.mostrarMiembros(listmiembro);
				System.out.println("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
				idm = sc.nextInt();
				if (!ct.asignarMiembro(tarea, idm)) {
					System.out.println("El Miembro seleccionado no es posible.");
				}
				break;
			default:
				System.out.println("Error en el bucle de las posibles opciones");
			}
			while (flag2) {
				System.out.println("Desea seguir modificando esta Tarea? [s/n]");
				seguir = sc.nextLine();
				if (seguir.equals("s") || seguir.equals("n")) {
					flag2 = false;
				} else {
					System.out.println("Debes introducir s o n.");
				}
			}
			if (seguir == "n") {
				mod = false;
			}
		}
	}

	@Override
	public void mostrar(Tarea tarea) {
		System.out.println("TAREA" + tarea.getId() + "{");
		System.out.println("Identificador: " + tarea.getId());
		System.out.println("T�tulo: " + tarea.getTitulo());
		System.out.println("Descripci�n: " + tarea.getDescripcion());
		System.out.println("Coste: " + tarea.getCoste());
		System.out.println("Beneficio: " + tarea.getBeneficio());
		CliRequisito req = CliRequisito.getInstance();
		req.mostrar(tarea.getRequisito());
		CliMiembro mie = CliMiembro.getInstance();
		mie.mostrar(tarea.getMiembroEquipo());
		System.out.println("}");
	}

	@Override
	public void mostrarReducido(Tarea tarea) {
		System.out.println("Identificador: " + tarea.getId() + "\tT�tulo: " + tarea.getTitulo());
	}

	@Override
	public void mostratTareas(Collection<Tarea> tareas) {
		System.out.println("IDENTIFICADOR\t\tT�TULO");
		for (Tarea tarea : tareas) {
			this.mostrarReducido(tarea);
		}
	}
}

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

	/*
	 * ControllerFactory.
	 */
	private ControllerFactory cf;
	
	/*
	 * ViewMiembro.
	 */
	private ViewMiembro vm;
	
	/*
	 * ViewRequisito.
	 */
	private ViewRequisito vr;

	/*
	 * Constructor protected.
	 * 
	 * @param1: cf, ControllerFactory.
	 * @param2: vm, ViewMiembro.
	 * @param3: vr, ViewRequisito.
	 */
	protected CliTarea(ControllerFactory cf, ViewMiembro vm, ViewRequisito vr) {
		super(cf);
		this.vm = vm;
		this.vr = vr;
	}

	@Override
	public boolean crearTarea() {
		Scanner sc = CliMenu.sc;
		String titulo, desc;
		int coste, beneficio, idr = 0, idm = 0;
		ControllerTarea ct = cf.getControllerTarea();
		ControllerRequisito cr = cf.getControllerRequisito();
		ControllerMiembro cm = cf.getControllerMiembro();
		System.out.print("Introduzca el t�tulo que quiere dar a la nueva tarea: ");
		titulo = sc.nextLine();
		System.out.print("Introduzca la descripci�n de la tarea: ");
		desc = sc.nextLine();
		System.out.print("Introduzca el coste de la tarea: ");
		coste = sc.nextInt();
		System.out.print("Introduzca el beneficio de la tarea: ");
		beneficio = sc.nextInt();
		Collection<Requisito> listreq = cr.getList();
		vr.mostrarRequisitos(listreq);
		System.out.print("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
		idr = sc.nextInt();
		Collection<MiembroEquipo> listmiembro = cm.getList();
		vm.mostrarMiembros(listmiembro);
		System.out.print("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
		idm = sc.nextInt();
		return ct.nuevaTarea(titulo, desc, coste, beneficio, idr, idm);
	}

	@Override
	public void modificarTarea() {
		Scanner sc = CliMenu.sc;
		ControllerTarea ct = cf.getControllerTarea();
		ControllerRequisito cr = cf.getControllerRequisito();
		ControllerMiembro cm = cf.getControllerMiembro();
		int id, opc = 0, idr, idm;
		boolean flag = true, mod = true, flag2 = true;
		String seguir = null;

		Collection<Tarea> tareas = ct.getList();
		this.mostratTareas(tareas);
		System.out.print("Introduzca el identificador de la Tarea que desea modificar: ");
		id = sc.nextInt();
		Tarea tarea = ct.getElement(id);
		while (mod) {
			System.out.println("La tarea que quiere modificar es la siguiente: ");
			this.mostrar(tarea);
			while (flag) {
				System.out.print(
						"Introduzca el valor relacionado con el cambio que desea hacer: T�tulo[0], Descripci�n[1], Coste[2], Beneficio[3], Requisito[4] y Miembro[5]");
				opc = sc.nextInt();
				if (opc >= 0 && opc <= 5) {
					flag = false;
				}
			}
			switch (opc) {
			case 0:
				System.out.print("Introduzca el nuevo t�tulo que se quiere dar a la tarea. (el t�tulo actual es: "
						+ tarea.getTitulo() + ")");
				tarea.setTitulo(sc.nextLine());
				break;
			case 1:
				System.out.print(
						"Introduzca la nueva descripci�n que se quiere dar a la tarea. (la descripci�n actual es: "
								+ tarea.getDescripcion() + ")");
				tarea.setDescripcion(sc.nextLine());
				break;
			case 2:
				System.out.print("Introduzca el nuevo coste que se quiere dar a la tarea. (el coste actual es: "
						+ tarea.getCoste() + ")");
				tarea.setCoste(sc.nextInt());
				break;
			case 3:
				System.out
						.print("Introduzca el nuevo beneficio que se quiere dar a la tarea. (el beneficio actual es: "
								+ tarea.getBeneficio() + ")");
				tarea.setBeneficio(sc.nextInt());
				break;
			case 4:
				System.out.println("Estos son los Requisitos que se pueden asignar a una tarea: ");
				Collection<Requisito> listreq = cr.getList();
				vr.mostrarRequisitos(listreq);
				System.out.print("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
				idr = sc.nextInt();
				if (!ct.editarRequisito(tarea, idr)) {
					System.out.println("El Requisito seleccionado no es posible.");
				}
				break;
			case 5:
				System.out.print("Estos son los Miembros que se pueden asignar a una tarea: ");
				Collection<MiembroEquipo> listmiembro = cm.getList();
				vm.mostrarMiembros(listmiembro);
				System.out.print("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
				idm = sc.nextInt();
				if (!ct.asignarMiembro(tarea, idm)) {
					System.out.println("El Miembro seleccionado no es posible.");
				}
				break;
			default:
				System.out.println("Error en el bucle de las posibles opciones");
			}
			this.cf.getControllerTarea().actualizaTarea(tarea);
			while (flag2) {
				System.out.print("Desea seguir modificando esta Tarea? [s/n]");
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
		vr.mostrar(tarea.getRequisito());
		vm.mostrar(tarea.getMiembroEquipo());
		System.out.println("}");
	}

	@Override
	public void mostrarReducido(Tarea tarea) {
		System.out.println(tarea.getId() + "\t\t" + tarea.getTitulo());
	}

	@Override
	public void mostratTareas(Collection<Tarea> tareas) {
		System.out.println("IDENTIFICADOR\tT�TULO");
		for (Tarea tarea : tareas) {
			this.mostrarReducido(tarea);
		}
	}
}

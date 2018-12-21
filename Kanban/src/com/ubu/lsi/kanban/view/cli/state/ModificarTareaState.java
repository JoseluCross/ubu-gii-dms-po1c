package com.ubu.lsi.kanban.view.cli.state;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.controller.ControllerMiembro;
import com.ubu.lsi.kanban.controller.ControllerRequisito;
import com.ubu.lsi.kanban.controller.ControllerTarea;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.model.Tarea;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;
import com.ubu.lsi.kanban.view.cli.CliMiembro;
import com.ubu.lsi.kanban.view.cli.CliRequisito;
import com.ubu.lsi.kanban.view.cli.CliTarea;

public class ModificarTareaState implements ViewState {

	@Override
	public ViewState haz(ControllerFactory cf) {
			
		Scanner sc = CliMenu.sc;
		ControllerTarea ct = cf.getControllerTarea();
		ControllerRequisito cr = cf.getControllerRequisito();
		ControllerMiembro cm = cf.getControllerMiembro();
		int id, opc = 0, idr, idm;
		boolean flag = true, flag2 = true;
		String seguir = null;
	
		Collection<Tarea> tareas = ct.getList();
		CliTarea.getInstance().mostrarTareas(tareas);
		System.out.print("Introduzca el identificador de la Tarea que desea modificar: ");
		id = Integer.parseInt(sc.nextLine());
		Tarea tarea = ct.getElement(id);

		System.out.println("La tarea que quiere modificar es la siguiente: ");
		CliTarea.getInstance().mostrar(tarea);
		while (flag) {
			System.out.println(
					"Introduzca el valor relacionado con el cambio que desea hacer: Título[0], Descripción[1], Coste[2], Beneficio[3], Requisito[4] y Miembro[5]");
			opc = Integer.parseInt(sc.nextLine());
			if (opc >= 0 && opc <= 5) {
				flag = false;
			}
		}
		switch (opc) {
		case 0:
			System.out.print("Introduzca el nuevo título que se quiere dar a la tarea. (el título actual es: "
					+ tarea.getTitulo() + ")\nNuevo Nombre: ");
			tarea.setTitulo(sc.nextLine());
			break;
		case 1:
			System.out.print(
					"Introduzca la nueva descripción que se quiere dar a la tarea. (la descripción actual es: "
							+ tarea.getDescripcion() + ")\nNueva Descripción: ");
			tarea.setDescripcion(sc.nextLine());
			break;
		case 2:
			System.out.print("Introduzca el nuevo coste que se quiere dar a la tarea. (el coste actual es: "
					+ tarea.getCoste() + ")\nNuevo Coste: ");
			tarea.setCoste(Integer.parseInt(sc.nextLine()));
			break;
		case 3:
			System.out
					.print("Introduzca el nuevo beneficio que se quiere dar a la tarea. (el beneficio actual es: "
							+ tarea.getBeneficio() + ")\nNuevo Beneficio: ");
			tarea.setBeneficio(Integer.parseInt(sc.nextLine()));
			break;
		case 4:
			System.out.println("Estos son los Requisitos que se pueden asignar a una tarea: ");
			Collection<Requisito> listreq = cr.getList();
			CliRequisito.getInstance().mostrarRequisitos(listreq);
			System.out.print("Introduzca el identificador del Requisito que quiera relacionar con esta Tarea: ");
			idr = Integer.parseInt(sc.nextLine());
			if (!ct.editarRequisito(tarea, idr)) {
				System.out.println("El Requisito seleccionado no es posible.");
			}
			break;
		case 5:
			System.out.println("Estos son los Miembros que se pueden asignar a una tarea: ");
			Collection<MiembroEquipo> listmiembro = cm.getList();
			CliMiembro.getInstance().mostrarMiembros(listmiembro);
			System.out.print("Introduzca el identificador del Miembro al que quiera asignar esta Tarea: ");
			idm = Integer.parseInt(sc.nextLine());
			if (!ct.asignarMiembro(tarea, idm)) {
				System.out.println("El Miembro seleccionado no es posible.");
			}
			break;
		default:
			System.out.println("Error en el bucle de las posibles opciones");
		}
		cf.getControllerTarea().actualizaTarea(tarea);
		while (flag2) {
			System.out.print("Desea seguir modificando Tareas? [s/n]: ");
			seguir = sc.nextLine();
			if (seguir.equals("s") || seguir.equals("n")) {
				flag2 = false;
			} else {
				System.out.println("Debes introducir s o n.");
			}
		}
		if (seguir.equals("s")) {
			return this;
		}else {
			return new MenuState();
		}
		
	}

}

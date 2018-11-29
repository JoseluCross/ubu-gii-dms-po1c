/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.view.cli;

import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.*;

/*
 * Clase de Cli de Menu
 */
public class CliMenu extends Menu{
	
	/*
	 * ViewBacklog.
	 */
	private ViewBacklog vb;
	
	/*
	 * ViewMiembro.
	 */
	private ViewMiembro vm;
	
	/*
	 * ViewRequisito.
	 */
	private ViewRequisito vr;
	
	/*
	 * ViewTarea.
	 */
	private ViewTarea vt;
	
	/*
	 * Scanner para coger los inputs del teclado.
	 */
	protected static Scanner sc;

	/*
	 * Constructor.
	 *
	 * @param: cf, ControlllerFactory.
	 */
	public CliMenu(ControllerFactory cf) {
		super(cf);
		vm = new CliMiembro(cf);
		vr = new CliRequisito(cf);
		vt = new CliTarea(cf,vm,vr);
		vb = new CliBacklog(cf,vt);
		sc = new Scanner(System.in);
	}

	@Override
	public boolean start() {
		int option = 0;
		System.out.println("Bienvenido a KanBan, la mejor aplicación del mundo");
		do {
			try {
				System.out.println("\nElija una opción");
				
				System.out.println(" [1] Crear Tarea");
				System.out.println(" [2] Modificar Tarea");
				System.out.println(" [3] Crear Sprint");
				System.out.println(" [4] Asignar Tarea en Sprint");
				System.out.println(" [5] Mover Tarea");
				System.out.println(" [6] Crear Requisito");
				System.out.println(" [7] Crear Miembro");
				System.out.println(" [8] Ver Product Backlog");
				System.out.println(" [9] Ver Sprint");
				System.out.println(" [10] Ver Tarea");
				System.out.println(" [11] Ver Requisitos");
				System.out.println(" [12] Ver Miembros");
				System.out.println("----------------------------");
				System.out.println(" [0] Cerrar aplicación");
				
				System.out.print("Tu opción: ");
				option = sc.nextInt();
				sc.nextLine();
				if(option != 0)
					executeOption(option);
			}catch(Exception ex) {
				System.err.println("Error "+ex.getMessage());
				ex.printStackTrace();
				sc.nextLine();
			}
				
		}while(option != 0);	
		
		
		boolean sq = saveQ();
		sc.close();
		return sq;
	}
	
	/*
	 * Método que nos permite dar la opción de guardar los cambios que hemos hecho en el sistema.
	 * 
	 * @return: true si guardamos los cambios.
	 */
	private boolean saveQ() {
		boolean flag = true;
		boolean save = false;
		while(flag) {
			System.out.print("Quieres guardar las modificaciones [S]i, [n]o: ");
			String s = sc.next();
			if(s.toUpperCase().equals("N")) {
				save = false;
				flag = false;
			}else if(s.isEmpty() || s.toUpperCase().equals("S")) {
				save = true;
				flag = false;
			}
		}
		return save;
	}
	
	/*
	 * M�todo que ejecuta una opci�n de las posibles en el men�.
	 * 
	 * @param: option, entero que representa la opci�n a realizar.
	 */
	private void executeOption(int option) {
		boolean ct;
		switch(option) {
		case 1: //Crear Tarea
			ct = vt.crearTarea();
			if(!ct)
				System.err.println("La tarea ha fallado al crearse, comprueba que tiene requisito");
			break;
		case 2: //Modificar Tarea
			vt.modificarTarea();
			break;
		case 3: //Crear sprint
			vb.nuevoSprint();
			break;
		case 4: //Asignar Tarea en Sprint
			vb.moverProductSprint();
			break;
		case 5: //Mover Tarea
			vb.moverSprint();
			break;
		case 6: //Crear requisito
			ct = vr.crearRequisito();
			if(!ct)
				System.err.println("No se ha podido crear el requisito");
			break;
		case 7: //Crear miembro
			vm.crearMiembro();
			break;
		case 8: //Ver Product Backlog
			vb.mostrar(ProductBacklog.getInstance());
			break;
		case 9: //Ver sprint
			SprintBacklog sb = seleccionarSprint();
			if(sb != null)
				vb.mostrar(sb);
			else
				System.err.println("El Sprint seleccionado no existe");
			break;
		case 10: //Ver tarea
			Tarea tt = seleccionarTarea();
			if(tt != null)
				vt.mostrar(tt);
			else
				System.err.println("La tarea seleccionado no existe");
			break;
		case 11: //Ver requisitos
			vr.mostrarRequisitos(cf.getControllerRequisito().getList());
			break;
		case 12: //Ver miembros
			vm.mostrarMiembros(cf.getControllerMiembro().getList());
			break;
		default:
			System.err.println("Por favor, elige un número de 0 al 12");
		}
	}
	
	/*
	 * M�todo que nos permite seleccionar un Sprint.
	 * 
	 * @return: SprintBacklog seleccionado.
	 */
	private SprintBacklog seleccionarSprint() {
		Scanner sc = CliMenu.sc;
		int ids;
		vb.mostrarReducido(cf.getControllerBacklog().getList());
		System.out.print("Elige que Sprint quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return cf.getControllerBacklog().getElement(ids);
	}
	
	/*
	 * M�todo que nos permite seleccionar una Tarea,
	 * 
	 * @return: Tarea seleccionada.
	 */
	private Tarea seleccionarTarea() {
		Scanner sc = CliMenu.sc;
		int ids;
		vt.mostratTareas(cf.getControllerTarea().getList());
		System.out.print("Elige que Tarea quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return cf.getControllerTarea().getElement(ids);
	}

}

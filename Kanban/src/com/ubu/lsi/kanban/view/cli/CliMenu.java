package com.ubu.lsi.kanban.view.cli;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.view.*;

public class CliMenu implements Menu{
	
	private static CliMenu instance;
	private ViewBacklog vb;
	private ViewMiembro vm;
	private ViewRequisito vr;
	private ViewTarea vt;
	protected static Scanner sc;
	
	public static CliMenu getInstance() {
		if (instance == null)
			instance = new CliMenu();
		return instance;
	}
	
	private CliMenu() {
		vb = CliBacklog.getInstance();
		vm = CliMiembro.getInstance();
		vr = CliRequisito.getInstance();
		vt = CliTarea.getInstance();
		sc = new Scanner(System.in);
	}

	@Override
	public boolean start() {
		int option = 0;
		System.out.println("Bienvenido a KanBan, la mejor aplicación del mundo");
		do {
			//clean();
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
			//clean();
			if(option != 0)
				executeOption(option);
			
			
		}while(option != 0);			
		
		boolean sq = saveQ();
		sc.close();
		return sq;
	}
	
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
	
	private void clean() {
		while(sc.hasNext())
			sc.next();
	}
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
			vr.mostrarRequisitos(ControllerRequisito.getInstance().getList());
			break;
		case 12: //Ver miembros
			vm.mostrarMiembros(ControllerMiembro.getInstance().getList());
			break;
		default:
			System.out.println("Pedazo subnormal, te he dicho un número de 0 al 12");
		}
	}
	
	private SprintBacklog seleccionarSprint() {
		Scanner sc = CliMenu.sc;
		int ids;
		vb.mostrarReducido(ControllerBacklog.getInstance().getList());
		System.out.print("Elige que Sprint quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return ControllerBacklog.getInstance().getElement(ids);
	}
	
	private Tarea seleccionarTarea() {
		Scanner sc = CliMenu.sc;
		int ids;
		vt.mostratTareas(ControllerTarea.getInstance().getList());
		System.out.print("Elige que Tarea quieres ver: ");
		ids = sc.nextInt();
		sc.nextLine();
		return ControllerTarea.getInstance().getElement(ids);
	}

}

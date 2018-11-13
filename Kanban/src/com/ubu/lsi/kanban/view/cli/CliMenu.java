package com.ubu.lsi.kanban.view.cli;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import com.ubu.lsi.kanban.model.ProductBacklog;
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
			System.out.println("Elija una opción");
			System.out.println(" [1] Ver Product Backlog");
			System.out.println(" [2] Crear Tarea");
			System.out.println(" [3] Modificar Tarea");
			System.out.println(" [4] Crear Sprint");
			System.out.println(" [5] Asignar Tarea en Sprint");
			System.out.println(" [6] Mover Tarea");
			System.out.println(" [7] Crear Requisito");
			System.out.println(" [8] Crear Miembro");
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
		case 1: //Ver Product Backlog
			vb.mostrar(ProductBacklog.getInstance());
			break;
		case 2: //Crear Tarea
			ct = vt.crearTarea();
			if(!ct)
				System.err.println("La tarea ha fallado al crearse, comprueba que tiene requisito");
			break;
		case 3: //Modificar Tarea
			vt.modificarTarea();
			break;
		case 4: //Crear sprint
			vb.nuevoSprint();
			break;
		case 5: //Asignar Tarea en Sprint
			vb.moverProductSprint();
			break;
		case 6: //Mover Tarea
			vb.moverSprint();
			break;
		case 7: //Crear requisito
			ct = vr.crearRequisito();
			if(!ct)
				System.err.println("No se ha podido crear el requisito");
			break;
		case 8: //Crear miembro
			vm.crearMiembro();
			break;
		default:
			System.out.println("Pedazo subnormal, te he dicho un número de 0 al 8");
		}
	}

}

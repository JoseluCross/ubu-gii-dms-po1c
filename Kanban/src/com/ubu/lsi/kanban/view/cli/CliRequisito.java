package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.ControllerRequisito;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.view.ViewRequisito;

public class CliRequisito implements ViewRequisito {

	private static CliRequisito instance;
	
	public static CliRequisito getInstance() {
		if(instance == null) {
			instance = new CliRequisito();
		}
		return instance;
	}
	
	private CliRequisito() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean crearRequisito() {
		Scanner sc = CliMenu.sc;
		ControllerRequisito cr = ControllerRequisito.getInstance();
		String nombre,desc, of;
		int prioridad, tipo=0;
		boolean flag = true;
		while(flag) {
			System.out.println("Desea que su Requisito sea una Historia de Usuario [0] o Defecto[1]");
			tipo = sc.nextInt();
			if (tipo == 0 || tipo ==1) {
				flag = false;
			}else {
				System.out.println("Se ha introducido mal el n�mero, ha de ser 0 o 1");
			}
		}
		sc.nextLine();
		System.out.println("Introduzca el nombre que le quiere dar al nuevo Requisito: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca la descripci�n que le quiere dar al nuevo Requisito");
		desc = sc.nextLine();
		System.out.println("Introduzca la prioridad que le quiere dar el nuevo Requisito");
		prioridad = sc.nextInt();
		sc.nextLine();
		if(tipo == 0) {
			System.out.println("Introduzca el actor que se quiere dar a la Historia de usuario: ");
		}else {
			System.out.println("Introduzca el commit con el que est� relacionado el Defecto: ");
		}
		of = sc.nextLine();
		return cr.nuevoRequisito(tipo, nombre, desc, prioridad, of);
	}

	@Override
	public void mostrar(Requisito requisito) {
		System.out.println("REQUISITO" + requisito.getId() + "{");
		System.out.println("Identificador: " + requisito.getId());
		System.out.println("Nombre: " + requisito.getNombre());
		System.out.println("Descripci�n: " + requisito.getDescripcion());
		System.out.println("Prioridad: " + requisito.getPrioridad());
		System.out.println("}");
	}

	@Override
	public void mostrarRequisitos(Collection<Requisito> requisitos) {
		System.out.println("IDENTIFICADOR\t\tNOMBRE\t\tPRIORIDAD");
		for (Requisito requisito : requisitos) {
			this.mostrarReducido(requisito);
		}
	}

	@Override
	public void mostrarReducido(Requisito requisito) {
		System.out.println("Identificador " + requisito.getId() + "\tNombre: " + requisito.getNombre() + "\tPrioridad: " + requisito.getPrioridad());
	}
}

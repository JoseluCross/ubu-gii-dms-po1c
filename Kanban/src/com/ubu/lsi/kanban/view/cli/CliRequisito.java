package com.ubu.lsi.kanban.view.cli;

import java.util.Collection;
import java.util.Scanner;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.Defecto;
import com.ubu.lsi.kanban.model.HistoriaUsuario;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.view.ViewRequisito;

public class CliRequisito implements ViewRequisito {

	private ControllerFactory cf;
	
	protected CliRequisito(ControllerFactory cf) {
		this.cf = cf;
	}
	
	@Override
	public boolean crearRequisito() {
		Scanner sc = CliMenu.sc;
		ControllerRequisito cr = cf.getControllerRequisito();
		String nombre,desc, of;
		int prioridad, tipo=0;
		boolean flag = true;
		while(flag) {
			System.out.print("Desea que su Requisito sea una Historia de Usuario [0] o Defecto[1]: ");
			tipo = sc.nextInt();
			if (tipo == 0 || tipo ==1) {
				flag = false;
			}else {
				System.out.println("Se ha introducido mal el número, ha de ser 0 o 1");
			}
		}
		sc.nextLine();
		System.out.print("Introduzca el nombre que le quiere dar al nuevo Requisito: ");
		nombre = sc.nextLine();
		System.out.print("Introduzca la descripción que le quiere dar al nuevo Requisito: ");
		desc = sc.nextLine();
		System.out.print("Introduzca la prioridad que le quiere dar el nuevo Requisito: ");
		prioridad = sc.nextInt();
		sc.nextLine();
		if(tipo == 0) {
			System.out.print("Introduzca el actor que se quiere dar a la Historia de usuario: ");
		}else {
			System.out.print("Introduzca el commit con el que está relacionado el Defecto: ");
		}
		of = sc.nextLine();
		return cr.nuevoRequisito(tipo, nombre, desc, prioridad, of);
	}

	@Override
	public void mostrar(Requisito requisito) {
		System.out.println("REQUISITO" + requisito.getId() + "{");
		System.out.println("Identificador: " + requisito.getId());
		System.out.println("Nombre: " + requisito.getNombre());
		System.out.println("Descripción: " + requisito.getDescripcion());
		System.out.println("Prioridad: " + requisito.getPrioridad());
		System.out.println("}");
	}

	@Override
	public void mostrarRequisitos(Collection<Requisito> requisitos) {
		System.out.println("IDENTIFICADOR\tNOMBRE\tPRIORIDAD\tTIPO\t\tDATOS ADICIONALES");
		for (Requisito requisito : requisitos) {
			this.mostrarReducido(requisito);
		}
	}

	@Override
	public void mostrarReducido(Requisito requisito) {
		System.out.print(requisito.getId() + "\t\t" + requisito.getNombre() + "\t\t" + requisito.getPrioridad());
		if(requisito instanceof HistoriaUsuario) {
			HistoriaUsuario aux = (HistoriaUsuario) requisito;
			System.out.println("\t\tHistoria de Usuario\tActor: " + aux.getActor());
		}else {
			Defecto aux2 = (Defecto) requisito;
			System.out.println("\t\tDefecto\tcommit: " + aux2.getCommit());
		}
	}
}

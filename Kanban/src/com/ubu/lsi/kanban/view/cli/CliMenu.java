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
import com.ubu.lsi.kanban.view.cli.state.MenuState;

/*
 * Clase de Cli de Menu
 */
public class CliMenu extends Menu{
	

	/*
	 * Scanner para coger los inputs del teclado.
	 */
	public static Scanner sc;
	
	private ViewState currentState;

	/*
	 * Constructor.
	 *
	 * @param: cf, ControlllerFactory.
	 */
	public CliMenu(ControllerFactory cf) {
		super(cf);
		sc = new Scanner(System.in);
		this.currentState = new MenuState();
	}

	@Override
	public boolean start() {
		int option = 0;
		System.out.println("Bienvenido a KanBan, la mejor aplicación del mundo");
		do {
			try {
				currentState = currentState.haz(cf);
			}catch(Exception ex) {
				currentState = new MenuState();
				System.err.println("Error: "+ex.getMessage());
				System.err.flush();
			}
		}while(currentState!=null);	
				
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
	
}

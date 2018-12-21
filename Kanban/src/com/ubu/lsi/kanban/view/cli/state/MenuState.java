package com.ubu.lsi.kanban.view.cli.state;

import com.ubu.lsi.kanban.controller.ControllerFactory;
import java.util.*;
import com.ubu.lsi.kanban.view.ViewState;
import com.ubu.lsi.kanban.view.cli.CliMenu;

public class MenuState implements ViewState {

	private static Map<Integer,ViewState> states = new HashMap<>();
	
	private static void create() {
		states.put(0, null);
		states.put(1, new CrearTareaState());
		states.put(2, new ModificarTareaState());
		states.put(3, new CrearSprintState());
		states.put(4, new AsignarTareaState());
		states.put(5, new MoverTareaState());
		states.put(6, new CrearRequistoState());
		states.put(7, new CrearMiembroState());
		states.put(8, new VerPBState());
		states.put(9, new VerSprintState());
		states.put(10, new VerTareaState());
		states.put(11, new VerRequisitoState());
		states.put(12, new VerMiembroState());
	}
	
	public MenuState() {
		if (states.isEmpty())
			create();
	}
	
	@Override
	public ViewState haz(ControllerFactory cf) {
		int option = 0;
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
			option = Integer.parseInt(CliMenu.sc.nextLine());
			if(option > states.size() || option < 0) {
				System.err.println("Por favor, introduzca una opción correcta");
			}
			
			return states.get(option);
		}catch(Exception ex) {
			System.err.println("Error "+ex.getMessage());
			//ex.printStackTrace();
			//CliMenu.sc.nextLine();
			return this;
		}		
	}

}

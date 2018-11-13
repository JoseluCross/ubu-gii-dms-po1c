 

package view.cli;

import java.util.Set;

import model.*;
import view.ViewBacklog;

public class CliBacklog implements ViewBacklog {

	private static CliBacklog instance;
	
	public static CliBacklog getInstance() {
		if(instance == null) {
			instance = new CliBacklog();
		}
		return instance;
	}
	
	private CliBacklog() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void nuevoSprint() {
		
	}

	@Override
	public void cerrarSprint(SprintBacklog sprint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrar(Backlog log) {
		CliTarea ct = CliTarea.getInstance();
		SprintStatus[] spt = {SprintStatus.PorHacer,SprintStatus.Haciendo,SprintStatus.Validacion,SprintStatus.Completada};
		if(log instanceof ProductBacklog) {
			System.out.println("PRODUCTBACKLOG{");
		}else {
			System.out.println("SPRINTBACKLOG " + ((SprintBacklog)log).getNombre());
		}
		int i = 0;
		for (Set<Tarea> st : log.getLista()) {
			if(log instanceof SprintBacklog) {
				System.out.println(spt[i]);
			}
			System.out.println("IDENTIFICADOR\t\tTÍTULO");
			for( Tarea t : st) {
				ct.mostrarReducido(t);
			}
			i++;
		}
			
	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

}

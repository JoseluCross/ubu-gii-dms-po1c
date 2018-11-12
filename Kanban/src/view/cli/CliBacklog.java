package view.cli;

import model.Backlog;
import model.SprintBacklog;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void cerrarSprint(SprintBacklog sprint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrar(Backlog log) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

}

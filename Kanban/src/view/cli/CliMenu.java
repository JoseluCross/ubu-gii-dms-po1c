package view.cli;

import persistence.Persistence;

public class CliMenu {
	
	private static CliMenu instance;
	private Persistence persistence;
	
	public static CliMenu getInstance() {
		if (instance == null)
			instance = new CliMenu();
		return instance;
	}
	
	private CliMenu() {
	}
	
	public Persistence getPersistence() {
		return this.persistence;
	}
	
	public void setPersistance(Persistence persist) {
		this.persistence = persist;
	}

}

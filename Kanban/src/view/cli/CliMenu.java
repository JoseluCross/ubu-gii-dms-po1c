package view.cli;

import persistence.Persistence;

public class CliMenu {
	
	private Persistence persistence;
	
	public CliMenu(Persistence persist) {
		persistence = persist;
	}
	
	public Persistence getPersistence() {
		return this.persistence;
	}

}

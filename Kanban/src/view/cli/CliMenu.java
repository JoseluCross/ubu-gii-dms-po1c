package view.cli;

import persistence.Persistence;

public class CliMenu {
	
	private static CliMenu instance;
	
	public static CliMenu getInstance() {
		if (instance == null)
			instance = new CliMenu();
		return instance;
	}
	
	private CliMenu() {
	}

}

package com.ubu.lsi.kanban.start;
import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.persistence.*;
import com.ubu.lsi.kanban.view.Menu;
import com.ubu.lsi.kanban.view.cli.CliMenu;

import java.io.File;

public class Main {

	private static Persistence persist;
	
	public static void main(String[] args) throws PersistenceException {
		config();
		Menu menu = CliMenu.getInstance();
		boolean save = menu.start();
		if (save)
			persist.save();
	}
	
	private static void config() throws PersistenceException {
		persist = CSVPersistence.getInstance();
		
		Map<String,String> config = new HashMap<>();
		config.put("folder", System.getProperty("user.home")+File.separator+".config"+File.separator+"KanBan");
		persist.config(config);
		persist.start();
				
		AbstractController.initializePersistence(persist);
	}
	
}

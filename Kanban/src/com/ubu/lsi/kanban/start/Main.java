package com.ubu.lsi.kanban.start;
import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.controller.basic.BasicControllerFactory;
import com.ubu.lsi.kanban.persistence.*;
import com.ubu.lsi.kanban.view.Menu;
import com.ubu.lsi.kanban.view.cli.CliMenu;

import java.io.File;

public class Main {

	private static Persistence persist;
	
	public static void main(String[] args) throws PersistenceException {
		ControllerFactory cf = config();
		Menu menu = new CliMenu(cf);
		boolean save = menu.start();
		if (save)
			persist.save();
	}
	
	private static ControllerFactory config() throws PersistenceException {
		persist = CSVPersistenceFactory.getInstance().getPersistence();
		
		Map<String,String> config = new HashMap<>();
		config.put("folder", System.getProperty("user.home")+File.separator+".config"+File.separator+"KanBan");
		persist.config(config);
		persist.start();
		
		ControllerFactory cf = new BasicControllerFactory(persist);
		return cf;
				
		
	}
	
}

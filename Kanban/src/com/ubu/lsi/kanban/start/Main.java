/*
 * Asignatura: Diseño y Mantenimiento del Software.
 * 4º Grado en Ingeniería Informática.
 * Alumnos: José Miguel Ramírez Sanz y José Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.start;
import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.controller.basic.BasicControllerFactory;
import com.ubu.lsi.kanban.persistence.*;
import com.ubu.lsi.kanban.view.Menu;
import com.ubu.lsi.kanban.view.cli.CliMenu;

import java.io.File;

/*
 * Clase para la ejecución.
 */
public class Main {

	/*
	 * Persistencia.
	 */
	private static Persistence persist;
	
	/*
	 * main.
	 */
	public static void main(String[] args) throws PersistenceException {
		ControllerFactory cf = config();
		Menu menu = new CliMenu(cf);
		boolean save = menu.start();
		if (save)
			persist.save();
	}
	
	/*
	 * Configuración.
	 * 
	 * @return: ControllerFactory.
	 * @throws PersistenceException.
	 */
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

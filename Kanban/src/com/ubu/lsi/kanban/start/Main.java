/*
 * Asignatura: Dise�o y Mantenimiento del Software.
 * 4� Grado en Ingenier�a Inform�tica.
 * Alumnos: Jos� Miguel Ram�rez Sanz y Jos� Luis Garrido Labrador.
 */

package com.ubu.lsi.kanban.start;
import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.controller.basic.BasicControllerFactory;
import com.ubu.lsi.kanban.persistence.*;
import com.ubu.lsi.kanban.view.Menu;
import com.ubu.lsi.kanban.view.cli.CliMenu;
import com.jkanetwork.kson.*;

import java.io.IOException;

/*
 * Clase para la ejecuci�n.
 */
public class Main {

	/*
	 * Persistencia.
	 */
	private static Persistence persist;
	
	/*
	 * main.
	 */
	public static void main(String[] args) throws PersistenceException, KsonException, IOException {
		ControllerFactory cf = config();
		Menu menu = new CliMenu(cf);
		boolean save = menu.start();
		if (save)
			persist.save();
	}
	
	/*
	 * Configuraci�n.
	 * 
	 * @return: ControllerFactory.
	 * @throws PersistenceException.
	 */
	private static ControllerFactory config() throws PersistenceException, KsonException, IOException {
		persist = CSVPersistenceFactory.getInstance().getPersistence();
		
		Map<String,String> config = Kson.parse("settings.kson");
		persist.config(config);
		persist.start();
		
		ControllerFactory cf = new BasicControllerFactory(persist);
		return cf;
				
		
	}
	
}

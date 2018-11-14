package com.ubu.lsi.kanban.persistence;

public class CSVPersistenceFactory implements PersistenceFactory {

	private static CSVPersistenceFactory instance;
	
	public static CSVPersistenceFactory getInstance() {
		if (instance == null)
			instance = new CSVPersistenceFactory();
		return instance;
	}
	
	private CSVPersistenceFactory() {
		
	}
	
	@Override
	public Persistence getPersistence() {
		return new CSVPersistence();
	}

}

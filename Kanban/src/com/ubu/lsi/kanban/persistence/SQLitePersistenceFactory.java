package com.ubu.lsi.kanban.persistence;

public class SQLitePersistenceFactory implements PersistenceFactory {

	@Override
	public Persistence getPersistence() {
		return new SQLitePersistence();
	}
	
	private static SQLitePersistenceFactory instance;
	
	private SQLitePersistenceFactory() {
		
	}
	
	public static SQLitePersistenceFactory getInstance() {
		if(instance == null)
			instance = new SQLitePersistenceFactory();
		return instance;
	}

}

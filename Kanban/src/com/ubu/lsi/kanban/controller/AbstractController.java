package com.ubu.lsi.kanban.controller;

import com.ubu.lsi.kanban.persistence.Persistence;

public abstract class AbstractController<E> implements Controller<E> {

	protected static Persistence persist;
	
	public static void initializePersistence(Persistence p) {
		if (persist == null)
			persist= p;
	}
	
}

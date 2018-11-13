package controller;

import persistence.Persistence;

public abstract class AbstractController<E> implements Controller<E> {

	protected static Persistence persist;
	
	public static void initializePersistence(Persistence p) {
		if (persist == null)
			persist= p;
	}
	
}

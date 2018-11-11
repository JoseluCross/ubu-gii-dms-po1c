package model;

import java.util.Collection;
import java.util.LinkedList;

public class SprintBacklog extends Backlog {
	private SprintBacklog() {
		super();
		super.log = new LinkedList<Collection<Tarea>>();
		//Por hacer ~ 0
		super.log.add(new LinkedList<Tarea>());
		//Haciendo ~ 1
		super.log.add(new LinkedList<Tarea>());
		//Validación ~ 2
		super.log.add(new LinkedList<Tarea>());
		//Completadas ~ 3
		super.log.add(new LinkedList<Tarea>());
	}
}

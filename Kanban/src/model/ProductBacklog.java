package model;

import java.util.Collection;
import java.util.LinkedList;

public class ProductBacklog extends Backlog {
	private static ProductBacklog instance;
	
	public ProductBacklog getInstance() {
		if(instance == null) {
			instance = new ProductBacklog();
		}
		return instance;
	}
	
	private ProductBacklog() {
		super();
		super.log = new LinkedList<Collection<Tarea>>();
		super.log.add(new LinkedList<Tarea>());
	}
}

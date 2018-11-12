package model;

import java.util.*;

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
	
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
	
	public Collection<Tarea> getLista() {
		return super.log.get(0);
	}
}

package model;

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
		super.log = new LinkedList<LinkedList<Tarea>>();
		super.log.add(new LinkedList<Tarea>());
	}
	
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
	
	public LinkedList<Tarea> getLista() {
		return super.log.get(0);
	}
}

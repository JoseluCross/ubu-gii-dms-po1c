package model;

import java.util.*;

public class ProductBacklog extends Backlog {
	private static ProductBacklog instance;
	
	public static ProductBacklog getInstance() {
		if(instance == null) {
			instance = new ProductBacklog();
		}
		return instance;
	}
	
	private ProductBacklog() {
		super();
		super.log = new ArrayList<Set<Tarea>>(1);
		super.log.add(new HashSet<Tarea>());
	}
	
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
}

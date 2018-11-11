package model;

import java.util.LinkedList;

public class SprintBacklog extends Backlog {
	private SprintBacklog() {
		super();
		super.log = new LinkedList<LinkedList<Tarea>>();
		//Por hacer ~ 0
		super.log.add(new LinkedList<Tarea>());
		//Haciendo ~ 1
		super.log.add(new LinkedList<Tarea>());
		//Validación ~ 2
		super.log.add(new LinkedList<Tarea>());
		//Completadas ~ 3
		super.log.add(new LinkedList<Tarea>());
	}
	
	public boolean add(Tarea tarea) {
		return super.log.get(0).add(tarea);
	}
	
	public boolean moverTarea(Tarea tarea, SprintStatus desde, SprintStatus hacia) {
		if(!super.log.get(desde.getNum()).contains(tarea)){
			return false;
		}
		super.log.get(desde.getNum()).remove(tarea);
		super.log.get(hacia.getNum()).add(tarea);
		return true;
	}
	
	public LinkedList<Tarea> getLista(SprintStatus opc){
		return super.log.get(opc.getNum());
	}
}

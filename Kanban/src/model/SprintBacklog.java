package model;

import java.util.*;

public class SprintBacklog extends Backlog {
	
	private Calendar start;
	private Calendar end;
	private static int DAYS=30;
	
	public SprintBacklog() {
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
		
		this.start = Calendar.getInstance();
		this.end = (Calendar) start.clone();
		this.end.add(Calendar.DATE,DAYS);
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
	
	public Collection<Tarea> getLista(SprintStatus opc){
		return super.log.get(opc.getNum());
	}
	
	public Calendar getStart() {
		return this.start;
	}
	
	public Calendar getEnd() {
		return this.end;
	}
	
	public void setStart(Calendar start) {
		this.start = start;
	}
	
	public void setEnd(Calendar end) {
		this.end = end;
	}
}

package model;

import java.util.*;

public class SprintBacklog extends Backlog {
	
	private Date start;
	private Date end;
	
	private SprintBacklog(Date start, Date end) {
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
		
		this.start = start;
		this.end = end;
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
	
	public Date getStart() {
		return this.start;
	}
	
	public Date getEnd() {
		return this.end;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
}

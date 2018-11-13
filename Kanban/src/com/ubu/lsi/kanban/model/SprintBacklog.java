package com.ubu.lsi.kanban.model;

import java.util.*;

public class SprintBacklog extends Backlog {
	
	private Calendar start;
	private Calendar end;
	private int ids;
	private String nombre;
	private static int DAYS=30;
	
	public SprintBacklog(int ids, Calendar start, String nombre) {
		super();
		this.ids = ids;
		super.log = new ArrayList<Set<Tarea>>(4);
		//Por hacer ~ 0
		super.log.add(new HashSet<Tarea>());
		//Haciendo ~ 1
		super.log.add(new HashSet<Tarea>());
		//Validación ~ 2
		super.log.add(new HashSet<Tarea>());
		//Completadas ~ 3
		super.log.add(new HashSet<Tarea>());
		
		this.start = start;
		this.end = (Calendar) start.clone();
		this.end.add(Calendar.DATE,DAYS);
		this.nombre = nombre;
	}
	
	public SprintBacklog(int ids, String nombre) {
		this(ids, Calendar.getInstance(), nombre);
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
	
	public Set<Tarea> getLista(SprintStatus opc){
		return super.log.get(opc.getNum());
	}
	
	public int getId() {
		return this.ids;
	}
	
	public Calendar getStart() {
		return this.start;
	}
	
	public Calendar getEnd() {
		return this.end;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

package com.ubu.lsi.kanban.model;
import java.util.*;

public abstract class Backlog {
	protected List<Set<Tarea>> log;
	public List<Set<Tarea>> getLista(){
		return this.log;
	}
}

package com.ubu.lsi.kanban.controller.basic;

import java.util.Collection;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerRequisito extends ControllerRequisito {
	
	protected BasicControllerRequisito(Persistence p) {
		super(p);
	}
		
	@Override
	public Collection<Requisito> getList() {
		return persist.loadRequisitos(); 
	}

	@Override
	public Requisito getElement(int index) {
		return persist.loadRequisito(index);
	}
	
	@Override
	public boolean nuevoRequisito(int tipo, String nombre, String descripcion, int prioridad, String of) {
		if(nombre == null || descripcion == null || nombre.isEmpty() || descripcion.isEmpty() || of == null || of.isEmpty())
			return false;
		Requisito r;
		switch(tipo) {
		case 0:
			r = new HistoriaUsuario(persist.newIdr(), nombre, descripcion, prioridad, of);
			break;
		case 1:
			r = new Defecto(persist.newIdr(), nombre, descripcion, prioridad, of);
			break;
		default:
				return false;
		}
		persist.nuevoRequisito(r);
		return true;
	}

}

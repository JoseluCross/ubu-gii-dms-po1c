package com.ubu.lsi.kanban.controller;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

public class ControllerTarea extends AbstractController<Tarea>{
	
	private static ControllerTarea instance;
	
	private ControllerTarea() {
		
	}
	
	public static ControllerTarea getInstance() {
		if (instance == null)
			instance = new ControllerTarea();
		return instance;
	}
	
	public boolean nuevaTarea(String titulo, String descripcion, int coste, int beneficio, int requisito, int miembro) {
		try {
			int index = persist.newIds();
			Requisito r = persist.loadRequisito(requisito);
			MiembroEquipo m = persist.loadMiembro(miembro);
			Tarea t = new Tarea(index, titulo, descripcion, coste, beneficio, r, m);
			persist.nuevaTarea(t);
			ControllerBacklog.getInstance().introducirTarea(t);
			return true;
		}catch(IllegalArgumentException ex) {
			return false;
		}
	}
	
	public boolean editarRequisito(Tarea tarea, int requisito) {
		try {
			Requisito r = persist.loadRequisito(requisito);
			tarea.setRequisito(r);
			return true;
		}catch(IllegalArgumentException ex) {
			return false;
		}
	}
	
	public boolean asignarMiembro(Tarea  t, int miembro) {
		MiembroEquipo m = persist.loadMiembro(miembro);
		t.setMiembro(m);
		return true;
	}

	@Override
	public Collection<Tarea> getList() {
		return persist.loadTareas();
	}

	@Override
	public Tarea getElement(int index) {
		return persist.loadTarea(index);
	}

}

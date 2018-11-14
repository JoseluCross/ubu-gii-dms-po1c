package com.ubu.lsi.kanban.controller.basic;
import java.util.Collection;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerTarea extends AbstractController implements ControllerTarea{
	
	
	protected BasicControllerTarea(Persistence p) {
		super(p);
	}
	
	@Override
	public boolean nuevaTarea(String titulo, String descripcion, int coste, int beneficio, int requisito, int miembro) {
		try {
			int index = persist.newIdt();
			Requisito r = persist.loadRequisito(requisito);
			MiembroEquipo m = persist.loadMiembro(miembro);
			Tarea t = new Tarea(index, titulo, descripcion, coste, beneficio, r, m);
			persist.nuevaTarea(t);
			
			ProductBacklog prod = ProductBacklog.getInstance();
			prod.add(t);

			return true;
		}catch(IllegalArgumentException ex) {
			return false;
		}
	}
	
	@Override
	public boolean editarRequisito(Tarea tarea, int requisito) {
		try {
			Requisito r = persist.loadRequisito(requisito);
			tarea.setRequisito(r);
			return true;
		}catch(IllegalArgumentException ex) {
			return false;
		}
	}
	
	@Override
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

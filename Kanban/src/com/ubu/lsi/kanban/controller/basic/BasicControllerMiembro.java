package com.ubu.lsi.kanban.controller.basic;

import java.util.*;

import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.model.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerMiembro extends ControllerMiembro {

	protected BasicControllerMiembro(Persistence p) {
		super(p);
	}
	
	@Override
	public Collection<MiembroEquipo> getList() {
		return persist.loadMiembros();
	}

	@Override
	public MiembroEquipo getElement(int index) {
		return persist.loadMiembro(index);
	}
	
	@Override
	public boolean nuevoMiembro(String nombre, String puesto) {
		if(nombre == null || puesto == null || nombre.isEmpty() || puesto.isEmpty())
			return false;
		MiembroEquipo mb = new MiembroEquipo(persist.newIdm(), nombre, puesto);
		persist.nuevoMiembro(mb);
		return true;
	}

}

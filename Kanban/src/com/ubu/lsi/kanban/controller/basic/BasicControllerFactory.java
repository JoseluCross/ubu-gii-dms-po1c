package com.ubu.lsi.kanban.controller.basic;


import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerFactory implements ControllerFactory {

	Persistence p;
	ControllerBacklog cb;
	ControllerTarea ct;
	ControllerMiembro cm;
	ControllerRequisito cr;

	public BasicControllerFactory(Persistence p) {
		this.p = p;
		this.cb = new BasicControllerBacklog(p);
		this.ct = new BasicControllerTarea(p);
		this.cm = new BasicControllerMiembro(p);
		this.cr = new BasicControllerRequisito(p);
	}

	@Override
	public ControllerBacklog getControllerBacklog() {
		return this.cb;
	}

	@Override
	public ControllerTarea getControllerTarea() {
		return this.ct;
	}

	@Override
	public ControllerMiembro getControllerMiembro() {
		return this.cm;
	}

	@Override
	public ControllerRequisito getControllerRequisito() {
		return this.cr;
	}

}

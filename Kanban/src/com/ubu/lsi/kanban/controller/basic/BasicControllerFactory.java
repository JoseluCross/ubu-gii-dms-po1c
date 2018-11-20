package com.ubu.lsi.kanban.controller.basic;


import com.ubu.lsi.kanban.controller.*;
import com.ubu.lsi.kanban.persistence.Persistence;

public class BasicControllerFactory extends ControllerFactory {

	ControllerBacklog cb;
	ControllerTarea ct;
	ControllerMiembro cm;
	ControllerRequisito cr;

	public BasicControllerFactory(Persistence p) {
		super(p);
		this.cb = new BasicControllerBacklog(this.persitence);
		this.ct = new BasicControllerTarea(this.persitence);
		this.cm = new BasicControllerMiembro(this.persitence);
		this.cr = new BasicControllerRequisito(this.persitence);
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

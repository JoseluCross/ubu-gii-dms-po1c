package controller;

import java.util.Collection;

import model.*;

public class ControllerRequisito extends AbstractController<Requisito> {

	private static ControllerRequisito instance;
	
	private ControllerRequisito() {
		
	}
	
	public static ControllerRequisito getInstance() {
		if (instance == null)
			instance = new ControllerRequisito();
		return instance;
	}
	
	
	@Override
	public Collection<Requisito> getList() {
		return persist.loadRequisitos(); 
	}

	@Override
	public Requisito getElement(int index) {
		return persist.loadRequisito(index);
	}

}

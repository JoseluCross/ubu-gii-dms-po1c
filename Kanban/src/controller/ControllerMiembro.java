package controller;

import java.util.*;
import model.*;
import persistence.Persistence;

public class ControllerMiembro extends AbstractController<MiembroEquipo> {

	private static ControllerMiembro instance;
	
	private ControllerMiembro() {
		
	}
	
	public static ControllerMiembro getInstance() {
		if (instance == null)
			instance = new ControllerMiembro();
		return instance;
	}
	
	@Override
	public Collection<MiembroEquipo> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroEquipo getElement(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

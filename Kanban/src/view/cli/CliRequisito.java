package view.cli;

import model.Requisito;
import view.ViewRequisito;

public class CliRequisito implements ViewRequisito {

	private static CliRequisito instance;
	
	public static CliRequisito getInstance() {
		if(instance == null) {
			instance = new CliRequisito();
		}
		return instance;
	}
	
	private CliRequisito() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean crearRequisito() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar(Requisito requisito) {
		// TODO Auto-generated method stub

	}

}

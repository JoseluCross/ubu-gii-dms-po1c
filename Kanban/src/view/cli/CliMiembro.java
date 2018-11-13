package view.cli;

import model.MiembroEquipo;
import view.ViewMiembro;

public class CliMiembro implements ViewMiembro {

	private static CliMiembro instance;
	
	public static CliMiembro getInstance() {
		if(instance == null) {
			instance = new CliMiembro();
		}
		return instance;
	}
	
	private CliMiembro() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean crearMiembro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar(MiembroEquipo miembro) {
		System.out.println("MIEMBRO " + miembro.getId() +"{");
		System.out.println("Identificador: " + miembro.getId());
		System.out.println("Nombre: " + miembro.getNombre());
		System.out.println("Puesto: " + miembro.getPuesto());
		System.out.println("}");
	}

}

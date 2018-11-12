package view.cli;

import model.Tarea;
import view.ViewTarea;

public class CliTarea implements ViewTarea {

	private static CliTarea instance;
	
	public static CliTarea getInstance() {
		if(CliTarea.instance == null) {
			instance = new CliTarea();
		}
		return instance;
	}
	
	private CliTarea() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean crearTarea() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar(Tarea tarea) {
		System.out.println("Identificador: " + tarea.getID());
		System.out.println("Título: " + tarea.getTitulo());
		System.out.println("Descripción: " + tarea.getDescripcion());
		System.out.println("Coste: " + tarea.getCoste());
		System.out.println("Beneficio: " + tarea.getBeneficio());
		CliRequisito req = CliRequisito.getInstance();
		req.mostrar(tarea.getRequisito());
		CliMiembro mie = CliMiembro.getInstance();
		mie.mostrar(tarea.getMiembroEquipo());
	}

}

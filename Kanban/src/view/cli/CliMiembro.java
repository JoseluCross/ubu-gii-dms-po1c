package view.cli;

import java.util.Collection;
import java.util.Scanner;

import controller.ControllerMiembro;
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
		Scanner sc = new Scanner(System.in);
		ControllerMiembro cm = ControllerMiembro.getInstance();
		String nombre, puesto;
		System.out.println("Introduzca el nombre del nuevo Miembro: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca el puesto del nuevo Miembro");
		puesto = sc.nextLine();
		sc.close();
		return cm.nuevoMiembro(nombre, puesto);
	}

	@Override
	public void mostrar(MiembroEquipo miembro) {
		System.out.println("MIEMBRO " + miembro.getId() +"{");
		System.out.println("Identificador: " + miembro.getId());
		System.out.println("Nombre: " + miembro.getNombre());
		System.out.println("Puesto: " + miembro.getPuesto());
		System.out.println("}");
	}

	@Override
	public void mostrarMiembros(Collection<MiembroEquipo> miembros) {
		System.out.println("IDENTIFICADOR\t\tNOMBRE\t\tPUESTO");
		for (MiembroEquipo miembro : miembros) {
			this.mostrarReducido(miembro);
		}
		
	}

	@Override
	public void mostrarReducido(MiembroEquipo miembro) {
		System.out.println("Identificador: " + miembro.getId() + "\tNombre: " + miembro.getNombre() + "\tPuesto: " + miembro.getPuesto());
	}

}

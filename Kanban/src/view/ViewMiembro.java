package view;
import java.util.Collection;

import model.*;

public interface ViewMiembro extends Mostrable<MiembroEquipo>{
	public boolean crearMiembro();
	public void mostrarMiembros(Collection<MiembroEquipo> miembros);
	public void mostrarReducido(MiembroEquipo miembro);
}

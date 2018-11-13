package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

public interface ViewMiembro extends Mostrable<MiembroEquipo>{
	public boolean crearMiembro();
	public void mostrarMiembros(Collection<MiembroEquipo> miembros);
	public void mostrarReducido(MiembroEquipo miembro);
}

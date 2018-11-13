package com.ubu.lsi.kanban.view;
import java.util.Collection;

import com.ubu.lsi.kanban.model.*;

public interface ViewBacklog extends Mostrable<Backlog>{
	public void nuevoSprint();
	public boolean moverProductSprint();
	public boolean moverSprint();
	public void mostrarReducido(Collection<SprintBacklog> sp);
}

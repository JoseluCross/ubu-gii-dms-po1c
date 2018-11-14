package com.ubu.lsi.kanban.controller;
import java.util.Calendar;

import com.ubu.lsi.kanban.model.*;

public interface ControllerBacklog extends Controller<SprintBacklog> {

	boolean tareaSprint(int sprint, int tarea);
	boolean moverEnSprint(int sprint, SprintStatus desde, SprintStatus hacia, int tarea);
	SprintBacklog crearSprint(String name, Calendar cal);
	
}

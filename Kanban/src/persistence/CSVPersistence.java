package persistence;

import java.util.*;
import model.*;

public class CSVPersistence implements Persistence {

	
	private Map<String,String> config;
	private Map<Integer,Requisito> requisitos;
	private Map<Integer,Tarea> tareas;
	private Map<Integer,SprintBacklog> sprints;
	private Map<Integer,MiembroEquipo> miembros;
	private static CSVPersistence instance;
	
	private CSVPersistence() {
	}
	
	public static CSVPersistence getInstance() {
		if (instance == null)
			instance = new CSVPersistence();
		return instance;
	}
	
	@Override
	public void start() throws PersistenceException {
		if (config == null) 
			throw new PersistenceException("No se ha configurado");
	}

	@Override
	public void config(Map<String, String> options) {
		this.config = options;

	}

	@Override
	public Tarea loadTarea(int idt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadProductBacklog() {
		// TODO Auto-generated method stub

	}

	@Override
	public SprintBacklog loadSprint(int ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SprintBacklog> loadSprints(boolean close) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MiembroEquipo loadMiembro(int idm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Requisito loadRequisito(int idr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}

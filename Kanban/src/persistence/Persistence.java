package persistence;
import java.util.*;
import model.*;

public interface Persistence {
	
	public void start() throws PersistenceException;
	public void save() throws PersistenceException;
	public void config(Map<String,String> options);
	public Tarea loadTarea(int idt) throws PersistenceException;
	public void loadProductBacklog() throws PersistenceException;
	public SprintBacklog loadSprint(int ids) throws PersistenceException;
	public List<SprintBacklog> loadSprints(boolean close) throws PersistenceException;
	public MiembroEquipo loadMiembro(int idm) throws PersistenceException;
	public Requisito loadRequisito(int idr) throws PersistenceException;

}

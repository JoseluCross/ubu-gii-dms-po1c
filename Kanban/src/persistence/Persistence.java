package persistence;
import java.util.*;
import model.*;

public interface Persistence {
	
	void start() throws PersistenceException;
	void save() throws PersistenceException;
	void config(Map<String,String> options);
	Tarea loadTarea(int idt) throws PersistenceException;
	int newIdt();
	SprintBacklog loadSprint(int ids) throws PersistenceException;
	List<SprintBacklog> loadSprints(boolean close) throws PersistenceException;
	int newIds();
	MiembroEquipo loadMiembro(int idm) throws PersistenceException;
	int newIdm();
	Requisito loadRequisito(int idr) throws PersistenceException;
	int newIdr();

}

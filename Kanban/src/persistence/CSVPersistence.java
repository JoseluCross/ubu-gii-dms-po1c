package persistence;

import java.util.*;
import model.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class CSVPersistence implements Persistence {

	private static final String TAREAFILE = "tareas.csv";
	private static final String MIEMBROFILE = "miembros.csv";
	private static final String SPRINTFILE = "sprints.csv";
	private static final String REQUISITOFILE = "requisitos.csv";
	private static final String SPRINTTAREA = "sprint-tareas.csv";
	private static final String SPLIT = ",";
	
	private int idt;
	private int ids;
	private int idm;
	private int idr;
	private Map<String,String> config;
	private Map<Integer,Requisito> requisitos;
	private Map<Integer,Tarea> tareas;
	private Map<Integer,SprintBacklog> sprints;
	private Map<Integer,MiembroEquipo> miembros;
	private static CSVPersistence instance;
	
	private CSVPersistence() {
		this.requisitos = new HashMap<>();
		this.tareas = new HashMap<>();
		this.sprints = new HashMap<>();
		this.miembros = new HashMap<>();
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
		
		String folder = config.get("folder");
		if (folder == null)
			throw new PersistenceException("No se ha configurado el campo \"folder\"");
		BufferedReader br = null;
		String superpath = folder+File.separator; 
		String path = "";
		try {
			/*Carga sprints*/
			path = superpath+SPRINTFILE;
			br = new BufferedReader(new FileReader(path));
			cargaSprints(br);
			this.idm = this.newID(sprints.keySet());
			/*Carga de requisitos*/
			path = superpath+REQUISITOFILE;
			br = new BufferedReader(new FileReader(path));
			cargaRequisitos(br);
			this.idr = this.newID(requisitos.keySet());
			/*Carga de miembros*/
			path = superpath+MIEMBROFILE;
			br = new BufferedReader(new FileReader(path));
			cargaMiembros(br);
			this.idm = this.newID(miembros.keySet());
			/*Carga de tareas*/
			path = superpath+TAREAFILE;
			br = new BufferedReader(new FileReader(path));
			cargaTareas(br);
			this.idt = this.newID(tareas.keySet());
			/*Carga tareas en los sprints*/
			path = superpath+SPRINTTAREA;
			br = new BufferedReader(new FileReader(path));
			cargaTareasSprint(br);
			
		}catch(FileNotFoundException ex) {
			File f = new File(path);
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				throw new PersistenceException("El fichero "+f.getPath()+" no se puede crear", e);
			}
		}catch(IOException ex) {
			throw new PersistenceException("El fichero "+path+" no se puede leer",ex);
		}
	}
	
	private void cargaTareas(BufferedReader br) throws IOException, PersistenceException {
        String line = "";
		while((line = br.readLine()) != null) {
			String[] task = line.split(SPLIT);
			try {
				Tarea t = new Tarea(
						Integer.parseInt(task[0]),
						task[1], 
						task[2],
						Integer.parseInt(task[3]),
						Integer.parseInt(task[4]),
						this.requisitos.get(Integer.parseInt(task[5])),
						this.miembros.get(Integer.parseInt(task[6])));
				this.tareas.put(t.getId(), t);
			}catch(Exception ex) {
				throw new PersistenceException("Las tareas guardadas son inconcistentes",ex);
			}			
		}
		br.close();
	}
	
	private void cargaTareasSprint(BufferedReader br) throws IOException, PersistenceException {
		String line = "";
		while((line = br.readLine()) != null) {
			try {
				String [] as = line.split(SPLIT);
				int idt = Integer.parseInt(as[0]);
				int ids = Integer.parseInt(as[1]);
				SprintStatus ss = SprintStatus.valueOf(as[2]);
				Tarea tt = tareas.get(idt);
				SprintBacklog sb = sprints.get(ids);
				if (sb == null) {
					ProductBacklog pb = ProductBacklog.getInstance();
					pb.add(tt);
				}else {
					sb.add(tt);
					sb.moverTarea(tt, SprintStatus.PorHacer, ss);
				}
			
			}catch(Exception ex) {
				throw new PersistenceException("Error fatal en la carga de tareas en sprints",ex);
			}
		}
		br.close();
	}

	private void cargaSprints(BufferedReader br) throws IOException, PersistenceException {
		String line = "";
		while((line = br.readLine()) != null) {
			try {
				String[] sprint = line.split(SPLIT);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
				cal.setTime(sdf.parse(sprint[1]));
			
				SprintBacklog s = new SprintBacklog(Integer.parseInt(sprint[0]),cal, sprint[2]);
				this.sprints.put(s.getId(), s);
			}catch (Exception ex) {
				throw new PersistenceException("Los sprints guardados son inconcistentes", ex);
			}
			
		}
		br.close();
	}

	private void cargaMiembros(BufferedReader br) throws PersistenceException, IOException {
		String line = "";
		while((line = br.readLine()) != null) {
			try {
				String[] miembro = line.split(SPLIT);
				
				MiembroEquipo r = new MiembroEquipo(Integer.parseInt(miembro[0]),miembro[1],miembro[2]);
				this.miembros.put(r.getId(), r);
			}catch(Exception ex) {
				throw new PersistenceException("Los miembros almacenados son inconcistentes",ex);
			}
		}
		br.close();
	}
	
	private void cargaRequisitos(BufferedReader br) throws PersistenceException, IOException {
		String line = "";
		while((line = br.readLine()) != null) {
			try {
				String[] requisito = line.split(SPLIT);
				Requisito r;
				int type = Integer.parseInt(requisito[0]);
				switch(type) {
				case 0:
					r = new HistoriaUsuario(Integer.parseInt(requisito[1]), requisito[2], requisito[3], Integer.parseInt(requisito[4]), requisito[5]);
					break;
				case 1:
					r = new HistoriaUsuario(Integer.parseInt(requisito[1]), requisito[2], requisito[3], Integer.parseInt(requisito[4]), requisito[5]);
					break;
				default:
					throw new PersistenceException();
				}		
				this.requisitos.put(r.getId(), r);
			}catch(Exception ex) {
				throw new PersistenceException("Los miembros almacenados son inconcistentes",ex);
			}
		}
		br.close();
	}

	@Override
	public void config(Map<String, String> options) {
		this.config = options;
	}

	@Override
	public Tarea loadTarea(int idt) {
		return tareas.get(idt);
	}

	@Override
	public SprintBacklog loadSprint(int ids) {
		return sprints.get(ids);
	}

	@Override
	public MiembroEquipo loadMiembro(int idm) {
		return this.miembros.get(idm);
	}

	@Override
	public Requisito loadRequisito(int idr) {
		return this.requisitos.get(idr);
	}

	@Override
	public void save() throws PersistenceException {
		/*Primero se crean los ficheros .csv.new*/
		if (config == null) 
			throw new PersistenceException("No se ha configurado");
		
		String folder = config.get("folder");
		if (folder == null)
			throw new PersistenceException("No se ha configurado el campo \"folder\"");
		BufferedWriter bw = null;
		String superpath = folder+File.separator; 
		String path = "";
		try {
			/*Guarda sprints*/
			path = superpath+SPRINTFILE;
			bw = new BufferedWriter(new FileWriter(path+".new"));
			guardaSprint(bw);
			/*Guarda de requisitos*/
			path = superpath+REQUISITOFILE;
			bw = new BufferedWriter(new FileWriter(path+".new"));
			guardaRequisitos(bw);
			this.idr = this.newID(requisitos.keySet());
			/*Guarda de miembros*/
			path = superpath+MIEMBROFILE;
			bw = new BufferedWriter(new FileWriter(path+".new"));
			guardaMiembros(bw);
			this.idm = this.newID(miembros.keySet());
			/*Guarda de tareas*/
			path = superpath+TAREAFILE;
			bw = new BufferedWriter(new FileWriter(path+".new"));
			guardaTareas(bw);
			this.idt = this.newID(tareas.keySet());
			/*Guarda tareas en los sprints*/
			path = superpath+SPRINTTAREA;
			bw = new BufferedWriter(new FileWriter(path+".new"));
			guardaTareasSprint(bw);
			
		}catch(IOException ex) {
			throw new PersistenceException("El fichero "+path+" no se puede escribir",ex);
		}
		/*Al crearse bien se copia la versi�n anterior a .old*/
		/*Los csv.new pasan a llamarse .csv*/
	}
	
	private void guardaTareasSprint(BufferedWriter bw) {
		// TODO Auto-generated method stub
		
	}

	private void guardaSprint(BufferedWriter bw) throws IOException {
		for(SprintBacklog sb : this.sprints.values()) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String start = sdf.format(sb.getStart().getTime());
			String end = sdf.format(sb.getEnd().getTime());
			bw.write(String.join(SPLIT, ""+sb.getId(),sb.getNombre(),start,end)+"\n");
		}
		bw.close();
	}
	
	private void guardaRequisitos(BufferedWriter bw) throws IOException {
		for(Requisito rb : this.requisitos.values()) {
			String of;
			int type;
			if(rb instanceof HistoriaUsuario) {
				type = 0;
				of = ((HistoriaUsuario)rb).getActor();
			}else {
				type = 1;
				of = ((Defecto)rb).getCommit();
			}
			bw.write(String.join(SPLIT,""+type,""+rb.getId(),rb.getNombre(),rb.getDescripcion(),rb.getPrioridad()+"")+"\n");
		}
		bw.close();
	}
	
	private void guardaMiembros(BufferedWriter bw) throws IOException {
		for(MiembroEquipo mb : this.miembros.values()) {
			bw.write(String.join(SPLIT, ""+mb.getId(),mb.getNombre(),mb.getPuesto())+"\n");
		}
		bw.close();
	}
	
	private void guardaTareas(BufferedWriter bw) throws IOException {
		for(Tarea tr : this.tareas.values()) {
			MiembroEquipo mb = tr.getMiembroEquipo();
			if (mb == null)
				mb = new MiembroEquipo(-1, "AAA", "EEE");
			bw.write(String.join(
					SPLIT, 
					""+tr.getId(),
					tr.getTitulo(),
					tr.getDescripcion(),
					""+tr.getCoste(),
					""+tr.getBeneficio(),
					""+tr.getRequisito().getId(),
					""+mb.getId()
					)+"\n");
		}
		bw.close();
	}
	
	private int newID(Set<Integer> integer) {
		int max=0;
		for (Integer it : integer) {
			if (it.intValue() > max)
				max = it.intValue();
		}
		return max;
	}

	@Override
	public int newIdt() {
		this.idt++;
		return idt;
	}

	@Override
	public int newIds() {
		this.ids++;
		return ids;
	}

	@Override
	public int newIdm() {
		this.idm++;
		return this.idm;
	}

	@Override
	public int newIdr() {
		this.idr++;
		return idr;
	}

	@Override
	public void nuevaTarea(Tarea t) {
		this.tareas.put(t.getId(), t);	
	}

	@Override
	public void nuevoMiembro(MiembroEquipo m) {
		this.miembros.put(m.getId(), m);
	}

	@Override
	public void nuevoRequisito(Requisito r) {
		this.requisitos.put(r.getId(), r);
	}

	@Override
	public void nuevoSprint(SprintBacklog s) {
		this.sprints.put(s.getId(), s);
	}

	@Override
	public Collection<SprintBacklog> loadSprints() {
		return this.sprints.values();
	}

	@Override
	public Collection<Tarea> loadTareas() {
		return this.tareas.values();
	}

	@Override
	public Collection<MiembroEquipo> loadMiembros() {
		return this.miembros.values();
	}

	@Override
	public Collection<Requisito> loadRequisitos() {
		return this.requisitos.values();
	}

}

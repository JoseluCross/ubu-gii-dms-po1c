package com.ubu.lsi.kanban.persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ubu.lsi.kanban.model.Defecto;
import com.ubu.lsi.kanban.model.HistoriaUsuario;
import com.ubu.lsi.kanban.model.MiembroEquipo;
import com.ubu.lsi.kanban.model.ProductBacklog;
import com.ubu.lsi.kanban.model.Requisito;
import com.ubu.lsi.kanban.model.SprintBacklog;
import com.ubu.lsi.kanban.model.SprintStatus;
import com.ubu.lsi.kanban.model.Tarea;

public class SQLitePersistence extends Persistence {
	
	@Override
	public void start() throws PersistenceException {
		try {
			Connection con = getConnection();
			load(con);
			con.close();
		} catch (Exception e) {
			throw new PersistenceException("La conexión con la base de datos no se puede realizar", e);
		}
				
	}
	
	private Connection getConnection() throws SQLException, PersistenceException{
		Connection conn = null;
		String folder = config.get("folder");
		if (folder == null)
			throw new PersistenceException("No se ha configurado el campo \"folder\"");
		
		String route = folder+File.separator+"kanban.sql";
		File f = new File(route);
		boolean noExistia = false;
		if (!f.exists()) {
			
			noExistia = true;
		}
		
		String url = "jdbc:sqlite:"+route;

		conn = DriverManager.getConnection(url);
		if (noExistia) {
			createTable(conn);
		}
		return conn;
	}
			

	private void createTable(Connection conn) throws SQLException, PersistenceException {
		String miembro = 
				"CREATE TABLE `Miembros` (\r\n" + 
				"	`idm`	INTEGER,\r\n" + 
				"	`nombre`	TEXT,\r\n" + 
				"	`puesto`	TEXT,\r\n" + 
				"	PRIMARY KEY(`idm`)\r\n" + 
				");";
		String requisito = 
				"CREATE TABLE `Requisitos` (\r\n" + 
				"	`idr`	INTEGER,\r\n" + 
				"	`type`	INTEGER NOT NULL,\r\n" + 
				"	`nombre`	TEXT,\r\n" + 
				"	`descripcion`	TEXT,\r\n" + 
				"	`prioridad`	INTEGER,\r\n" + 
				"	`anadido`	TEXT,\r\n" + 
				"	PRIMARY KEY(`idr`)\r\n" + 
				");";
		String tarea = 
				"CREATE TABLE `Tarea` (\r\n" + 
				"	`idt`	INTEGER,\r\n" + 
				"	`titulo`	TEXT,\r\n" + 
				"	`descripcion`	TEXT,\r\n" + 
				"	`coste`	INTEGER,\r\n" + 
				"	`beneficio`	INTEGER,\r\n" + 
				"	`idm`	INTEGER,\r\n" + 
				"	`idr`	INTEGER NOT NULL,\r\n" + 
				"	PRIMARY KEY(`idt`),\r\n" + 
				"	FOREIGN KEY(`idm`) REFERENCES `Miembros`(`idm`),\r\n" + 
				"	FOREIGN KEY(`idr`) REFERENCES `Requisitos`(`idr`)\r\n" + 
				");";
		String sprint =
				"CREATE TABLE `Sprint` (\r\n" + 
				"	`ids`	INTEGER,\r\n" + 
				"	`nombre`	TEXT,\r\n" + 
				"	`fecha-ini`	TEXT,\r\n" + 
				"	`fecha-fin`	TEXT,\r\n" + 
				"	PRIMARY KEY(`ids`)\r\n" + 
				");";
		String tareaSprint =
				"CREATE TABLE `TareaSprint` (\r\n" + 
				"	`idt`	INTEGER,\r\n" + 
				"	`ids`	INTEGER,\r\n" + 
				"	`estado`	TEXT,\r\n" + 
				"	FOREIGN KEY(`ids`) REFERENCES `Sprint`(`ids`),\r\n" + 
				"	PRIMARY KEY(`idt`),\r\n" + 
				"	FOREIGN KEY(`idt`) REFERENCES `Tarea`(`idt`)\r\n" + 
				");";
		
		String[] tablas = {miembro,requisito,tarea,sprint,tareaSprint};
		for(String tabla : tablas) {
			PreparedStatement st = null;
			boolean fallo = false;
			Throwable error = null;
			try {
				st = conn.prepareStatement(tabla);
				st.executeUpdate();
				st.close();
			} catch (SQLException e) {
				fallo = true;
				error = e;
			}finally {
				if (st != null)
					st.close();
			}
			if (fallo)
				throw new PersistenceException("La tabla "+tabla+"no se puede crear",error);
		}
	}
	
	private void load(Connection con) throws SQLException, ParseException {
		loadMiembros(con);
		this.idm = this.newID(miembros.keySet());
		loadRequisitos(con);
		this.idr = this.newID(requisitos.keySet());
		loadTareas(con);
		this.idt = this.newID(tareas.keySet());
		loadSprints(con);
		this.ids = this.newID(sprints.keySet());
		loadSprintTareas(con);
	}
	
	private void loadMiembros(Connection con) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM Miembros");
			rs = st.executeQuery();
			while(rs.next()) {
				MiembroEquipo me = new MiembroEquipo(rs.getInt("idm"), rs.getString("nombre"), rs.getString("puesto"));
				this.miembros.put(me.getId(), me);
			}			
		}catch(SQLException ex) {
			
		}finally {
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		}
	}
	
	private void loadRequisitos(Connection con) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM Requisitos");
			rs = st.executeQuery();
			while(rs.next()) {
				Requisito re = null;
				
				int type = rs.getInt("type");
				switch(type) {
				case 0:
					re = new HistoriaUsuario(rs.getInt("idr"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("prioridad"), rs.getString("anadido"));
					break;
				case 1:
					re = new Defecto(rs.getInt("idr"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("prioridad"), rs.getString("anadido"));
					break;
				}				
				this.requisitos.put(re.getId(), re);
			}			
		}catch(SQLException ex) {
			
		}finally {
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		}
	}
	
	private void loadTareas(Connection con) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM Tarea");
			rs = st.executeQuery();
			while(rs.next()) {
				int idm = rs.getInt("idm");
				if (rs.wasNull()){
					idm = -1;
				}
				Tarea te = new Tarea(rs.getInt("idt"), rs.getString("titulo"), rs.getString("descripcion"), rs.getInt("coste"), rs.getInt("beneficio"),
						this.loadRequisito(rs.getInt("idr")),this.loadMiembro(idm));
				this.tareas.put(te.getId(), te);
			}			
		}catch(SQLException ex) {
			
		}finally {
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		}
	}
	
	private void loadSprints(Connection con) throws SQLException, ParseException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM Sprint");
			rs = st.executeQuery();
			while(rs.next()) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
				cal.setTime(sdf.parse(rs.getString("fecha-ini")));
				SprintBacklog sb = new SprintBacklog(rs.getInt("ids"), cal, rs.getString("nombre"));
				this.sprints.put(sb.getId(), sb);
			}			
		}catch(SQLException ex) {
			
		}finally {
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		}
	}
	
	private void loadSprintTareas(Connection con) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("SELECT * FROM TareaSprint");
			rs = st.executeQuery();
			while(rs.next()) {
				int ids = rs.getInt("ids");
				Tarea t = this.tareas.get(rs.getInt("idt"));
				if (ids == -1) { //Product Backolog
					ProductBacklog.getInstance().add(t);
				}else {
					SprintBacklog sb = this.sprints.get(ids);
					sb.add(t);
					sb.moverTarea(t, SprintStatus.PorHacer, SprintStatus.valueOf(rs.getString("estado")));					
				}
			}			
		}catch(SQLException ex) {
			
		}finally {
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		}
	}
	

	@Override
	public void save() throws PersistenceException {
		
		try {
			Connection conn = this.getConnection();
			dropTable(conn);
			createTable(conn);
			saveMiembros(conn);
			saveRequisitos(conn);
			saveSprints(conn);
			saveTareas(conn);
			saveTareaSprint(conn);
			conn.close();
		}catch(Exception ex) {
			throw new PersistenceException("Error fatal guardando la base de datos",ex);
		}	
	}
	
	private void saveMiembros(Connection conn) throws SQLException{
		PreparedStatement st = null;
		for (MiembroEquipo me : this.miembros.values()) {
			st = conn.prepareStatement("INSERT INTO Miembros VALUES (?,?,?)");
			int idx = 1;
			st.setInt(idx++, me.getId());
			st.setString(idx++, me.getNombre());
			st.setString(idx++, me.getPuesto());
			st.executeUpdate();			
		}
	}
	
	private void saveRequisitos(Connection conn) throws SQLException{
		PreparedStatement st = null;
		for (Requisito me : this.requisitos.values()) {
			st = conn.prepareStatement("INSERT INTO Requisitos VALUES (?,?,?,?,?,?)");
			int idx = 1;
			int type = 0;
			String anadido = "";
			if(me instanceof HistoriaUsuario) {
				type = 0;
				anadido = ((HistoriaUsuario)me).getActor();
			}else if(me instanceof Defecto) {
				type = 1;
				anadido = ((Defecto)me).getCommit();				
			}
			st.setInt(idx++, me.getId());
			st.setInt(idx++, type);
			st.setString(idx++, me.getNombre());
			st.setString(idx++, me.getDescripcion());
			st.setInt(idx++, me.getPrioridad());			
			st.setString(idx++, anadido);
			st.executeUpdate();			
		}
	}
	
	private void saveSprints(Connection conn) throws SQLException{
		PreparedStatement st = null;
		for (SprintBacklog me : this.sprints.values()) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String start = sdf.format(me.getStart().getTime());
			String end = sdf.format(me.getEnd().getTime());
			
			st = conn.prepareStatement("INSERT INTO Sprint VALUES (?,?,?,?)");
			int idx = 1;
			st.setInt(idx++, me.getId());
			st.setString(idx++, me.getNombre());
			st.setString(idx++, start);
			st.setString(idx++, end);
			st.executeUpdate();			
		}
	}
	
	private void saveTareas(Connection conn) throws SQLException{
		PreparedStatement st = null;
		for (Tarea me : this.tareas.values()) {
			st = conn.prepareStatement("INSERT INTO Tarea VALUES (?,?,?,?,?,?,?)");
			int idx = 1;
			st.setInt(idx++, me.getId());
			st.setString(idx++, me.getTitulo());
			st.setString(idx++, me.getDescripcion());
			st.setInt(idx++, me.getCoste());
			st.setInt(idx++, me.getBeneficio());
			st.setInt(idx++, me.getMiembroEquipo().getId());
			st.setInt(idx++, me.getRequisito().getId());
			st.executeUpdate();			
		}
	}
	
	private void saveTareaSprint(Connection conn) throws SQLException{
		PreparedStatement st = null;
		for (SprintBacklog me : this.sprints.values()) {
			
			for(SprintStatus ss : SprintStatus.values()) {
				for (Tarea t : me.getLista(ss)) {
					st = conn.prepareStatement("INSERT INTO TareaSprint VALUES (?,?,?)");
					int idx = 1;
					st.setInt(idx++, t.getId());
					st.setInt(idx++, me.getId());
					st.setString(idx++, ss.toString());
					st.executeUpdate();
					st.close();
				}
			}			
		}
		for (Tarea t : ProductBacklog.getInstance().getLista().get(0)) {
			st = conn.prepareStatement("INSERT INTO TareaSprint VALUES (?,?,?)");
			int idx = 1;
			st.setInt(idx++, t.getId());
			st.setInt(idx++, -1);
			st.setString(idx++, SprintStatus.PorHacer.toString());
			st.executeUpdate();
			st.close();
		}
		
	}
	
	
	private void dropTable(Connection conn) throws SQLException {
		PreparedStatement st = null;
		String[] tables = {"TareaSprint","Sprint","Tarea","Miembros","Requisitos"};
		
		for (String table : tables) {
			st = conn.prepareStatement("DROP TABLE "+table);
			st.executeUpdate();
			st.close();
		}

	}

//	@Override
//	public Tarea loadTarea(int idt) {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		Tarea t = null;
//		try {
//			st = this.conn.prepareStatement("SELECT * FROM Tarea WHERE idt=?");
//			st.setInt(1, idt);
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = new Tarea(idt, rs.getString("titulo"), rs.getString("descripcion"),
//						rs.getInt("coste"), rs.getInt("beneficio"),
//						this.loadRequisito(rs.getInt("idr")), this.loadMiembro(rs.getInt("idm")));
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return null;
//			}
//		}
//		return t;
//	}

//	@Override
//	public int newIdt() {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		int t = 0;
//		try {
//			st = this.conn.prepareStatement("SELECT MAX(idt) FROM Tarea");
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = rs.getInt(1)+1;
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return -1;
//			}
//		}
//		return t;
//	}
//
//	private void cargaTareasParaSprint(SprintBacklog sb) {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		try {
//			st = this.conn.prepareStatement("SELECT idt,estado FROM TareaSprint WHERE ids=?");
//			if(sb != null)
//				st.setInt(1,sb.getId());
//			else
//				st.setNull(1, java.sql.Types.INTEGER);
//			rs = st.executeQuery();
//			while(rs.next()) {
//				Tarea t = this.loadTarea(rs.getInt("idt"));
//				SprintStatus ss = SprintStatus.valueOf(rs.getString("estado"));
//				if (sb != null) {
//					sb.add(t);
//					sb.moverTarea(t, SprintStatus.PorHacer, ss);
//				}else {
//					ProductBacklog.getInstance().add(t);
//				}
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				//PASS
//			}
//		}
//	}
//	
//	@Override
//	public SprintBacklog loadSprint(int ids) {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		SprintBacklog t = null;
//		try {
//			st = this.conn.prepareStatement("SELECT * FROM Sprint WHERE ids=?");
//			st.setInt(1, ids);
//			rs = st.executeQuery();
//			if(rs.next()) {
//				Calendar cal = Calendar.getInstance();
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//			
//				cal.setTime(sdf.parse(rs.getString(2)));
//			
//				t = new SprintBacklog(ids,cal, rs.getString("nombre"));
//				cargaTareasParaSprint(t);
//			}
//		}catch(Exception ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return null;
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public int newIds() {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		int t = 0;
//		try {
//			st = this.conn.prepareStatement("SELECT MAX(ids) FROM Sprint");
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = rs.getInt(1)+1;
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return -1;
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public MiembroEquipo loadMiembro(int idm) {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		MiembroEquipo t = null;
//		try {
//			st = this.conn.prepareStatement("SELECT * FROM Miembros WHERE idm=?");
//			st.setInt(1, idm);
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = new MiembroEquipo(idm, rs.getString("nombre"), rs.getString("puesto"));
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return null;
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public int newIdm() {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		int t = 0;
//		try {
//			st = this.conn.prepareStatement("SELECT MAX(idm) FROM Miembros");
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = rs.getInt(1)+1;
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return -1;
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public Requisito loadRequisito(int idr) {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		Requisito t = null;
//		try {
//			st = this.conn.prepareStatement("SELECT * FROM Requisitos WHERE idr=?");
//			st.setInt(1, idr);
//			rs = st.executeQuery();
//			if(rs.next()) {
//				int type = rs.getInt("type");
//				switch(type) {
//				case 0:
//					t = new HistoriaUsuario(idr, rs.getString("nombre"),
//							rs.getString("descripcion"), rs.getInt("prioridad"),
//							rs.getString("anadido"));
//					break;
//				case 1:
//					t = new Defecto(idr, rs.getString("nombre"),
//							rs.getString("descripcion"), rs.getInt("prioridad"),
//							rs.getString("anadido"));
//					break;
//				}
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return null;
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public int newIdr() {
//		ResultSet rs = null;
//		PreparedStatement st = null;
//		int t = 0;
//		try {
//			st = this.conn.prepareStatement("SELECT MAX(idr) FROM Requisitos");
//			rs = st.executeQuery();
//			if(rs.next()) {
//				t = rs.getInt(1)+1;
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			}catch(SQLException ex) {
//				return -1;
//			}
//		}
//		return t;
//	}

//	@Override
//	public void nuevaTarea(Tarea t) {
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		try {
//			st = conn.prepareStatement("SELECT * FROM Tarea WHERE idt = ?");
//			st.setInt(1, t.getId());
//			rs = st.executeQuery();
//			if(rs.next()) {
//				updateTarea(t);
//			}else {
//				insertTarea(t);
//			}
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				st.close();
//				rs.close();
//			} catch (Exception e) {
//				//PASS
//			}
//		}
//	}
//	
//	private void updateTarea(Tarea t) {
//		PreparedStatement st = null;
//		try {
//			st = this.conn.prepareStatement("UPDATE Tarea\r\n"
//					+ "SET titulo = ?, descripcion = ?, coste = ?, beneficio = ?, idm = ?, idr = ?\r\n"
//					+ "WHERE idt = ?");
//			int idx = 1;
//			st.setString(idx++, t.getTitulo());
//			st.setString(idx++, t.getDescripcion());
//			st.setInt(idx++, t.getCoste());
//			st.setInt(idx++, t.getBeneficio());
//			if(t.getMiembroEquipo() == null)
//				st.setNull(idx++, java.sql.Types.INTEGER);
//			else
//				st.setInt(idx++, t.getMiembroEquipo().getId());
//			st.setInt(idx++, t.getRequisito().getId());
//			st.setInt(idx++, t.getId());
//			st.executeUpdate();
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				st.close();
//			} catch (Exception e) {
//				//PASS
//			}
//		}
//	}
//	
//	private void insertTarea(Tarea t) {
//		PreparedStatement st = null;
//		try {
//			st = this.conn.prepareStatement("INSERT INTO Tarea\r\n"
//					+ "VALUES (idt = ?, titulo = ?, descripcion = ?, coste = ?, beneficio = ?, idm = ?, idr = ?)");
//			int idx = 1;
//			st.setString(idx++, t.getId());
//			st.setString(idx++, t.getTitulo());
//			st.setString(idx++, t.getDescripcion());
//			st.setInt(idx++, t.getCoste());
//			st.setInt(idx++, t.getBeneficio());
//			if(t.getMiembroEquipo() == null)
//				st.setNull(idx++, java.sql.Types.INTEGER);
//			else
//				st.setInt(idx++, t.getMiembroEquipo().getId());
//			st.setInt(idx++, t.getRequisito().getId());
//			st.executeUpdate();
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				st.close();
//			} catch (Exception e) {
//				//PASS
//			}
//		}
//	}
//
//	@Override
//	public void nuevoMiembro(MiembroEquipo m) {
//		PreparedStatement st = null;
//		try {
//			st = this.conn.prepareStatement("INSERT INTO Miembros\r\n"
//					+ "VALUES (idm = ?, nombre = ?, puesto = ?)");
//			int idx = 1;
//			st.setInt(idx++, m.getId());
//			st.setString(idx++, m.getNombre());
//			st.setString(idx++, m.getPuesto());
//			st.executeUpdate();
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				st.close();
//			} catch (Exception e) {
//				//PASS
//			}
//		}
//	}
//
//	@Override
//	public void nuevoRequisito(Requisito r) {
//		PreparedStatement st = null;
//		try {
//			st = this.conn.prepareStatement("INSERT INTO Requisitos\r\n"
//					+ "VALUES (idr = ?, type = ?, nombre = ?, descripcion = ?, prioridad = ?, anadido = ?)");
//			int idx = 1;
//			st.setInt(idx++, r.getId());
//			if(r instanceof HistoriaUsuario)
//				st.setInt(idx++, 0);
//			else if(r instanceof Defecto)
//				st.setInt(idx++, 1);
//			st.setString(idx++, r.getNombre());
//			st.setString(idx++, r.getDescripcion());
//			st.setInt(idx++, r.getPrioridad());
//			if(r instanceof HistoriaUsuario)
//				st.setString(idx++, ((HistoriaUsuario)r).getActor());
//			else if(r instanceof Defecto)
//				st.setString(idx++, ((Defecto)r).getCommit());
//			st.executeUpdate();
//		}catch(SQLException ex) {
//			//PASS
//		}finally {
//			try {
//				st.close();
//			} catch (Exception e) {
//				//PASS
//			}
//		}
//	}
//
//	@Override
//	public void nuevoSprint(SprintBacklog s) {
//		
//	}

}

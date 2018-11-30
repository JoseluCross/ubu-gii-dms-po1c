```java
  @Override
	public Tarea loadTarea(int idt) {
		ResultSet rs = null;
		PreparedStatement st = null;
		Tarea t = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM Tarea WHERE idt=?");
			st.setInt(1, idt);
			rs = st.executeQuery();
			if(rs.next()) {
				t = new Tarea(idt, rs.getString("titulo"), rs.getString("descripcion"),
						rs.getInt("coste"), rs.getInt("beneficio"),
						this.loadRequisito(rs.getInt("idr")), this.loadMiembro(rs.getInt("idm")));
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return null;
			}
		}
		return t;
	}

	@Override
	public int newIdt() {
		ResultSet rs = null;
		PreparedStatement st = null;
		int t = 0;
		try {
			st = this.conn.prepareStatement("SELECT MAX(idt) FROM Tarea");
			rs = st.executeQuery();
			if(rs.next()) {
				t = rs.getInt(1)+1;
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return -1;
			}
		}
		return t;
	}

	private void cargaTareasParaSprint(SprintBacklog sb) {
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("SELECT idt,estado FROM TareaSprint WHERE ids=?");
			if(sb != null)
				st.setInt(1,sb.getId());
			else
				st.setNull(1, java.sql.Types.INTEGER);
			rs = st.executeQuery();
			while(rs.next()) {
				Tarea t = this.loadTarea(rs.getInt("idt"));
				SprintStatus ss = SprintStatus.valueOf(rs.getString("estado"));
				if (sb != null) {
					sb.add(t);
					sb.moverTarea(t, SprintStatus.PorHacer, ss);
				}else {
					ProductBacklog.getInstance().add(t);
				}
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				PASS
			}
		}
	}
	
	@Override
	public SprintBacklog loadSprint(int ids) {
		ResultSet rs = null;
		PreparedStatement st = null;
		SprintBacklog t = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM Sprint WHERE ids=?");
			st.setInt(1, ids);
			rs = st.executeQuery();
			if(rs.next()) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
				cal.setTime(sdf.parse(rs.getString(2)));
			
				t = new SprintBacklog(ids,cal, rs.getString("nombre"));
				cargaTareasParaSprint(t);
			}
		}catch(Exception ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return null;
			}
		}
		return t;
	}

	@Override
	public int newIds() {
		ResultSet rs = null;
		PreparedStatement st = null;
		int t = 0;
		try {
			st = this.conn.prepareStatement("SELECT MAX(ids) FROM Sprint");
			rs = st.executeQuery();
			if(rs.next()) {
				t = rs.getInt(1)+1;
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return -1;
			}
		}
		return t;
	}

	@Override
	public MiembroEquipo loadMiembro(int idm) {
		ResultSet rs = null;
		PreparedStatement st = null;
		MiembroEquipo t = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM Miembros WHERE idm=?");
			st.setInt(1, idm);
			rs = st.executeQuery();
			if(rs.next()) {
				t = new MiembroEquipo(idm, rs.getString("nombre"), rs.getString("puesto"));
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return null;
			}
		}
		return t;
	}

	@Override
	public int newIdm() {
		ResultSet rs = null;
		PreparedStatement st = null;
		int t = 0;
		try {
			st = this.conn.prepareStatement("SELECT MAX(idm) FROM Miembros");
			rs = st.executeQuery();
			if(rs.next()) {
				t = rs.getInt(1)+1;
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return -1;
			}
		}
		return t;
	}

	@Override
	public Requisito loadRequisito(int idr) {
		ResultSet rs = null;
		PreparedStatement st = null;
		Requisito t = null;
		try {
			st = this.conn.prepareStatement("SELECT * FROM Requisitos WHERE idr=?");
			st.setInt(1, idr);
			rs = st.executeQuery();
			if(rs.next()) {
				int type = rs.getInt("type");
				switch(type) {
				case 0:
					t = new HistoriaUsuario(idr, rs.getString("nombre"),
							rs.getString("descripcion"), rs.getInt("prioridad"),
							rs.getString("anadido"));
					break;
				case 1:
					t = new Defecto(idr, rs.getString("nombre"),
							rs.getString("descripcion"), rs.getInt("prioridad"),
							rs.getString("anadido"));
					break;
				}
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return null;
			}
		}
		return t;
	}

	@Override
	public int newIdr() {
		ResultSet rs = null;
		PreparedStatement st = null;
		int t = 0;
		try {
			st = this.conn.prepareStatement("SELECT MAX(idr) FROM Requisitos");
			rs = st.executeQuery();
			if(rs.next()) {
				t = rs.getInt(1)+1;
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			}catch(SQLException ex) {
				return -1;
			}
		}
		return t;
	}

	@Override
	public void nuevaTarea(Tarea t) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM Tarea WHERE idt = ?");
			st.setInt(1, t.getId());
			rs = st.executeQuery();
			if(rs.next()) {
				updateTarea(t);
			}else {
				insertTarea(t);
			}
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				st.close();
				rs.close();
			} catch (Exception e) {
				PASS
			}
		}
	}
	
	private void updateTarea(Tarea t) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("UPDATE Tarea\r\n"
					+ "SET titulo = ?, descripcion = ?, coste = ?, beneficio = ?, idm = ?, idr = ?\r\n"
					+ "WHERE idt = ?");
			int idx = 1;
			st.setString(idx++, t.getTitulo());
			st.setString(idx++, t.getDescripcion());
			st.setInt(idx++, t.getCoste());
			st.setInt(idx++, t.getBeneficio());
			if(t.getMiembroEquipo() == null)
				st.setNull(idx++, java.sql.Types.INTEGER);
			else
				st.setInt(idx++, t.getMiembroEquipo().getId());
			st.setInt(idx++, t.getRequisito().getId());
			st.setInt(idx++, t.getId());
			st.executeUpdate();
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				st.close();
			} catch (Exception e) {
				PASS
			}
		}
	}
	
	private void insertTarea(Tarea t) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("INSERT INTO Tarea\r\n"
					+ "VALUES (idt = ?, titulo = ?, descripcion = ?, coste = ?, beneficio = ?, idm = ?, idr = ?)");
			int idx = 1;
			st.setString(idx++, t.getId());
			st.setString(idx++, t.getTitulo());
			st.setString(idx++, t.getDescripcion());
			st.setInt(idx++, t.getCoste());
			st.setInt(idx++, t.getBeneficio());
			if(t.getMiembroEquipo() == null)
				st.setNull(idx++, java.sql.Types.INTEGER);
			else
				st.setInt(idx++, t.getMiembroEquipo().getId());
			st.setInt(idx++, t.getRequisito().getId());
			st.executeUpdate();
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				st.close();
			} catch (Exception e) {
				PASS
			}
		}
	}

	@Override
	public void nuevoMiembro(MiembroEquipo m) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("INSERT INTO Miembros\r\n"
					+ "VALUES (idm = ?, nombre = ?, puesto = ?)");
			int idx = 1;
			st.setInt(idx++, m.getId());
			st.setString(idx++, m.getNombre());
			st.setString(idx++, m.getPuesto());
			st.executeUpdate();
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				st.close();
			} catch (Exception e) {
				PASS
			}
		}
	}

	@Override
	public void nuevoRequisito(Requisito r) {
		PreparedStatement st = null;
		try {
			st = this.conn.prepareStatement("INSERT INTO Requisitos\r\n"
					+ "VALUES (idr = ?, type = ?, nombre = ?, descripcion = ?, prioridad = ?, anadido = ?)");
			int idx = 1;
			st.setInt(idx++, r.getId());
			if(r instanceof HistoriaUsuario)
				st.setInt(idx++, 0);
			else if(r instanceof Defecto)
				st.setInt(idx++, 1);
			st.setString(idx++, r.getNombre());
			st.setString(idx++, r.getDescripcion());
			st.setInt(idx++, r.getPrioridad());
			if(r instanceof HistoriaUsuario)
				st.setString(idx++, ((HistoriaUsuario)r).getActor());
			else if(r instanceof Defecto)
				st.setString(idx++, ((Defecto)r).getCommit());
			st.executeUpdate();
		}catch(SQLException ex) {
			PASS
		}finally {
			try {
				st.close();
			} catch (Exception e) {
				PASS
			}
		}
	}

	@Override
	public void nuevoSprint(SprintBacklog s) {
		
	}
```

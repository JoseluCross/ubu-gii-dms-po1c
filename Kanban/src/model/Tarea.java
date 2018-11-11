package model;

public class Tarea {
	
	private String titulo;
	private String descripcion;
	private int coste;
	private int beneficio;
	private Requisito requisito;
	private MiembroEquipo miembro;
	
	public Tarea(String titulo, String descripcion, int coste, int beneficio, Requisito requisito) {
		assert requisito != null: "El requisito no puede ser nulo";
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.coste = coste;
		this.beneficio = beneficio;
		this.requisito = requisito;
	}
	
	public Tarea(String titulo, String descripcion, int coste, int beneficio, Requisito requisito, MiembroEquipo miembro) {
		this(titulo, descripcion, coste, beneficio, requisito);
	}
	
	/*Getters*/
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getCoste() {
		return this.coste;
	}
	
	public int getBeneficio() {
		return this.beneficio;
	}
	
	public Requisito getRequisito() {
		return this.requisito;
	}
	
	public MiembroEquipo getMiembroEquipo() {
		return this.miembro;
	}
	
	/*Setters*/
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	public void setBeneficio(int beneficio) {
		this.beneficio = beneficio;
	}
	
	public void setMiembro(MiembroEquipo miembro) {
		this.miembro = miembro;
	}
	
	public void setRequisito(Requisito requisito) {
		assert requisito != null: "El requisito no puede ser nulo";
		this.requisito = requisito;
	}

	
}

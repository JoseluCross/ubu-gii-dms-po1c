package com.ubu.lsi.kanban.model;

import java.util.Objects;

public class Tarea {
	
	private int idt;
	private String titulo;
	private String descripcion;
	private int coste;
	private int beneficio;
	private Requisito requisito;
	private MiembroEquipo miembro;
	
	public Tarea(int idt, String titulo, String descripcion, int coste, int beneficio, Requisito requisito) {
		if (requisito == null)
			throw new IllegalArgumentException("Toda tarea ha de estar asociada a un requisito");
		
		this.idt = idt;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.coste = coste;
		this.beneficio = beneficio;
		this.requisito = requisito;
	}
	
	public Tarea(int idt,String titulo, String descripcion, int coste, int beneficio, Requisito requisito, MiembroEquipo miembro) {
		this(idt, titulo, descripcion, coste, beneficio, requisito);
		this.miembro = miembro;
	}
	
	/*Getters*/
	
	public int getId() {
		return this.idt;
	}
	
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
		if (requisito == null)
			throw new IllegalArgumentException("Toda tarea ha de estar asociada a un requisito");
		this.requisito = requisito;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Tarea)
			return ((Tarea)o).getId()==this.idt;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idt);
	}

	
}

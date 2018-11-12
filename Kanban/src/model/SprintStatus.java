package model;

public enum SprintStatus {
	PorHacer(0),
	Haciendo(1),
	Validacion(2),
	Completada(3);
	
	private int num;
	
	private SprintStatus(int num) {
		this.num = num;
	}
	
	//Getters
	public int getNum() {
		return this.num;
	}
}

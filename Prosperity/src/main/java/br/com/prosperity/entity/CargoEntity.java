package br.com.prosperity.entity;

public class CargoEntity {
	private int id;
	private String nmCargo;
	
	public CargoEntity(){
		
	}
	
	public CargoEntity(int id, String nmCargo){
		this.id=id;
		this.nmCargo=nmCargo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNmCargo() {
		return nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}
}

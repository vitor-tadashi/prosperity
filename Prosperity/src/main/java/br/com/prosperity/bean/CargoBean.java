package br.com.prosperity.bean;

public class CargoBean {
	private int id;
	private String nomeCargo;
	
	public CargoBean(){
		
	}
	
	public CargoBean(int id, String nomeCargo){
		this.id=id;
		this.nomeCargo=nomeCargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}

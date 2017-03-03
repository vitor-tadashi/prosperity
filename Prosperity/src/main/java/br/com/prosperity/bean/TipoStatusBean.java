package br.com.prosperity.bean;

public class TipoStatusBean {

	private int id;
	private char Status;
	
	
	public TipoStatusBean(int id, char status) {
		this.id = id;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getStatus() {
		return Status;
	}
	public void setStatus(char status) {
		Status = status;
	}
	
	
	
}

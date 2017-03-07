package br.com.prosperity.bean;

public class TipoStatusBean {

	private int id;
	private String Status;
	
	public TipoStatusBean() {
	}
	public TipoStatusBean(int id, String status) {
		this.id = id;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}

package br.com.prosperity.entity;

public class ClienteEntity {
	private int id;
	private String nmCliente;

	public ClienteEntity() {

	}

	public ClienteEntity(int id, String nmCliente) {
		this.id = id;
		this.nmCliente = nmCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

}

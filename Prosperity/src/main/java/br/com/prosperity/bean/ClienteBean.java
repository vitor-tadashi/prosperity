package br.com.prosperity.bean;

public class ClienteBean {
	private int id;
	private String nomeCliente;

	public ClienteBean() {

	}

	public ClienteBean(int id, String nomeCliente) {
		this.id = id;
		this.nomeCliente = nomeCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}

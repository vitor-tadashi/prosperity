package br.com.prosperity.bean;

public class PerfilBean {

	private int id;
	private String nome;

	public PerfilBean(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public PerfilBean(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}

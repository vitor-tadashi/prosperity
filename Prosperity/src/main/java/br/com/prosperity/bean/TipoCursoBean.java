package br.com.prosperity.bean;

public class TipoCursoBean {
	
	private int id;
	private String descricao;
	
	public TipoCursoBean(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public TipoCursoBean(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}

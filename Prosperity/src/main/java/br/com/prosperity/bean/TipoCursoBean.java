package br.com.prosperity.bean;

import java.util.List;

public class TipoCursoBean {
	
	private int id;
	private String descricao;
	private List<FormacaoBean> formacao; //relacionamento entre TipoCurso e Forma��o
	
	public List<FormacaoBean> getFormacao() {
		return formacao;
	}

	public void setFormacao(List<FormacaoBean> formacao) {
		this.formacao = formacao;
	}

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

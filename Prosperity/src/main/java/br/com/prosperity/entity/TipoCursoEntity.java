package br.com.prosperity.entity;

import java.util.List;

public class TipoCursoEntity {
	
	private int id;
	private String descricao;
	private List<FormacaoEntity> formacao; //relacionamento entre TipoCurso e Formação
	
	public List<FormacaoEntity> getFormacao() {
		return formacao;
	}

	public void setFormacao(List<FormacaoEntity> formacao) {
		this.formacao = formacao;
	}

	public TipoCursoEntity(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public TipoCursoEntity(){

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

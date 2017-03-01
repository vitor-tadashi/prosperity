package br.com.prosperity.bean;

import java.util.List;

public class SituacaoAtualBean {
	private int id;
	private String descricao;
	private List<FormacaoBean> formacao;
	
	public List<FormacaoBean> getFormacao() {
		return formacao;
	}
	public void setFormacao(List<FormacaoBean> formacao) {
		this.formacao = formacao;
	}
	public int getId() {
		return id;
	}
	public void setIdSituacaoAtual(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

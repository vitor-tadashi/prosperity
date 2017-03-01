package br.com.prosperity.entity;

import java.util.List;

public class SituacaoAtualEntity {
	private int idSituacaoAtual;
	private String descricao;
	private List<FormacaoEntity> formacao;
	
	public List<FormacaoEntity> getFormacao() {
		return formacao;
	}
	public void setFormacao(List<FormacaoEntity> formacao) {
		this.formacao = formacao;
	}
	public int getIdSituacaoAtual() {
		return idSituacaoAtual;
	}
	public void setIdSituacaoAtual(int idSituacaoAtual) {
		this.idSituacaoAtual = idSituacaoAtual;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

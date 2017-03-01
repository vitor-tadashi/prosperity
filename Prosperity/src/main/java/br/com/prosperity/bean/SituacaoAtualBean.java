package br.com.prosperity.bean;

import java.util.List;

public class SituacaoAtualBean {
	private int idSituacaoAtual;
	private String descricao;
	private List<FormacaoBean> formacao;
	
	public List<FormacaoBean> getFormacao() {
		return formacao;
	}
	public void setFormacao(List<FormacaoBean> formacao) {
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

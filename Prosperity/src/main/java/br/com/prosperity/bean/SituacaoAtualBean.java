package br.com.prosperity.bean;

import java.util.List;

public class SituacaoAtualBean {

	private Integer id;
	private String descricao;
	private List<FormacaoBean> formacao;
	
	public List<FormacaoBean> getFormacao() {
		return formacao;
	}
	public void setFormacao(List<FormacaoBean> formacao) {
		this.formacao = formacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

package br.com.prosperity.entity;

import java.util.Calendar;

public class FormacaoEntity {
	private int id;
	private String instituicao;
	private Calendar conclusao;
	private TipoCursoEntity tipoCursoBean;
	private SituacaoAtualEntity situacaoAtualBean;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public Calendar getConclusao() {
		return conclusao;
	}
	public void setConclusao(Calendar conclusao) {
		this.conclusao = conclusao;
	}
	public TipoCursoEntity getTipoCursoBean() {
		return tipoCursoBean;
	}
	public void setTipoCursoBean(TipoCursoEntity tipoCursoBean) {
		this.tipoCursoBean = tipoCursoBean;
	}
	public SituacaoAtualEntity getSituacaoAtualBean() {
		return situacaoAtualBean;
	}
	public void setSituacaoAtualBean(SituacaoAtualEntity situacaoAtualBean) {
		this.situacaoAtualBean = situacaoAtualBean;
	}
}

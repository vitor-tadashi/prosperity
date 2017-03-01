package br.com.prosperity.bean;

import java.util.Calendar;

public class FormacaoBean {
	private int id;
	private String instituicao;
	private Calendar conclusao;
	private TipoCursoBean tipoCursoBean;
	private SituacaoAtualBean situacaoAtualBean;
	
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
	public TipoCursoBean getTipoCursoBean() {
		return tipoCursoBean;
	}
	public void setTipoCursoBean(TipoCursoBean tipoCursoBean) {
		this.tipoCursoBean = tipoCursoBean;
	}
	public SituacaoAtualBean getSituacaoAtualBean() {
		return situacaoAtualBean;
	}
	public void setSituacaoAtualBean(SituacaoAtualBean situacaoAtualBean) {
		this.situacaoAtualBean = situacaoAtualBean;
	}
}

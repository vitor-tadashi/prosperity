package br.com.prosperity.bean;

import java.util.Calendar;

public class FormacaoBean {
	private int id;
	private String nomeInstituicao;
	private Calendar dataConclusao;
	private TipoCursoBean tipoCursoBean;
	private SituacaoAtualBean situacaoAtualBean;

	public FormacaoBean() {

	}

	public FormacaoBean(int id, String nomeInstituicao, Calendar dataConclusao, TipoCursoBean tipoCursoBean,
			SituacaoAtualBean situacaoAtualBean) {
		this.id = id;
		this.nomeInstituicao = nomeInstituicao;
		this.dataConclusao = dataConclusao;
		this.tipoCursoBean = tipoCursoBean;
		this.situacaoAtualBean = situacaoAtualBean;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
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

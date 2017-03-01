package br.com.prosperity.bean;

import java.util.Calendar;

public class FormacaoBean {
	private int id;
	private String nomeInstituicao;
	private Calendar dataConclusao;
	private TipoCursoBean tipoCurso;
	private SituacaoAtualBean situacaoAtual;

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

	public TipoCursoBean getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCursoBean tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public SituacaoAtualBean getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(SituacaoAtualBean situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

}

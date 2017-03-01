package br.com.prosperity.bean;

import java.util.Calendar;

public class FormacaoBean {
	private int id;
	private String instituicao;
	private Calendar conclusao;
	private TipoCursoBean tipoCurso;
	private SituacaoAtualBean situacaoAtual;
	
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
	public TipoCursoBean getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(TipoCursoBean tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	public SituacaoAtualBean getSituacaoAtual() {
		return situacaoAtual;
	}
	public void setsituacaoAtual(SituacaoAtualBean situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}
}

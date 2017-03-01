package br.com.prosperity.bean;

import java.util.Calendar;

public class FormacaoBean {
	private int id;
	private String instituicao;
	private Calendar conclusao;
	
	TipoCursoBean tipoCursoBean = new TipoCursoBean();
	SituacaoAtualBean situacaoAtualBean = new SituacaoAtualBean();
	
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
}

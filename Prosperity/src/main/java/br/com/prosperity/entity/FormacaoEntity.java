package br.com.prosperity.entity;

import java.util.Calendar;

public class FormacaoEntity {
	private int id;
	private String nmInstituicao;
	private Calendar dtConclusao;
	private TipoCursoEntity tipoCursoEntity;
	private SituacaoAtualEntity situacaoAtualEntity;

	public FormacaoEntity() {

	}

	public FormacaoEntity(int id, String nmInstituicao, Calendar dtConclusao, TipoCursoEntity tipoCursoEntity,
			SituacaoAtualEntity situacaoAtualEntity) {
		this.id = id;
		this.nmInstituicao = nmInstituicao;
		this.dtConclusao = dtConclusao;
		this.tipoCursoEntity = tipoCursoEntity;
		this.situacaoAtualEntity = situacaoAtualEntity;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNmInstituicao() {
		return nmInstituicao;
	}

	public void setNmInstituicao(String nmInstituicao) {
		this.nmInstituicao = nmInstituicao;
	}

	public Calendar getDtConclusao() {
		return dtConclusao;
	}

	public void setDtConclusao(Calendar dtConclusao) {
		this.dtConclusao = dtConclusao;
	}

	public TipoCursoEntity getTipoCursoEntity() {
		return tipoCursoEntity;
	}

	public void setTipoCursoEntity(TipoCursoEntity tipoCursoEntity) {
		this.tipoCursoEntity = tipoCursoEntity;
	}

	public SituacaoAtualEntity getSituacaoAtualEntity() {
		return situacaoAtualEntity;
	}

	public void setSituacaoAtualEntity(SituacaoAtualEntity situacaoAtualEntity) {
		this.situacaoAtualEntity = situacaoAtualEntity;
	}

}

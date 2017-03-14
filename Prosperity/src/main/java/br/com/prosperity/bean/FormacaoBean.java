package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FormacaoBean {
	private Integer id;
	private String nomeInstituicao;
	private String nomeCurso;
	private Date dataConclusao;
	private TipoCursoBean tipoCursoBean;
	private SituacaoAtualBean situacaoAtualBean;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}

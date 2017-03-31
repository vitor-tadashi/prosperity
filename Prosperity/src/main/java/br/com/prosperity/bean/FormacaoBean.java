package br.com.prosperity.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "FormacaoBean")
public class FormacaoBean {
	private Integer id;
	private String nomeInstituicao;
	private String nomeCurso;
	private Date dataConclusao;
	private TipoCursoBean tipoCurso;
	private SituacaoAtualBean situacaoAtual;

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}

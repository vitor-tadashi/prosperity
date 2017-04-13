package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbFormacao")
public class FormacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFormacao", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmInstituicao")
	private String nome;

	@Column(name = "nmCurso")
	private String nomeCurso;

	@Column(name = "dtConclusao")
	private Date dataConclusao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoCurso")
	private TipoCursoEntity tipoCurso;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSituacaoAtual")
	private SituacaoAtualEntity situacaoAtual;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public TipoCursoEntity getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCursoEntity tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public SituacaoAtualEntity getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(SituacaoAtualEntity situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}

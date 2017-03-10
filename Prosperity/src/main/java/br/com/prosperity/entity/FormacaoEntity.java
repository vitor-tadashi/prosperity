package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbFormacao")
public class FormacaoEntity {

	/* Mapeamento de Atributos */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idFormacao", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmInstituicao")
	private String nome;

	@Column(name = "dtConclusao")
	private Date dataConclusao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idTipoCurso")
	private TipoCursoEntity tipoCursoEntity;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idSituacaoAtual")
	private SituacaoAtualEntity situacaoAtualEntity;

	

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

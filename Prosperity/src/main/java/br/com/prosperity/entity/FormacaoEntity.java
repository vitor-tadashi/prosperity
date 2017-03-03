package br.com.prosperity.entity;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@Table(name = "tbFormacao")
public class FormacaoEntity {

	/* Mapeamento de Atributos */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idFormacao", unique = true, nullable = false)
	private int id;

	@Column(name = "nmInstituicao")
	private String nome;

	@Column(name = "dtConclusao")
	private Calendar dataConclusao;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idTipoCurso")
	private TipoCursoEntity tipoCursoEntity;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idSituacaoAtual")
	private SituacaoAtualEntity situacaoAtualEntity;

	public FormacaoEntity() {

	}

	public FormacaoEntity(int id, String nome, Calendar dataConclusao, TipoCursoEntity tipoCursoEntity,
			SituacaoAtualEntity situacaoAtualEntity) {
		this.id = id;
		this.nome = nome;
		this.dataConclusao = dataConclusao;
		this.tipoCursoEntity = tipoCursoEntity;
		this.situacaoAtualEntity = situacaoAtualEntity;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
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

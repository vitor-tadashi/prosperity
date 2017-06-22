package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbCandidatoCompetencia")
@NamedQuery(name = "obterCompetencias", query = "SELECT cc FROM CandidatoCompetenciaEntity cc")
public class CandidatoCompetenciaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCandidatoCompetencia", unique = true, nullable = false)
	private Integer idCandidatoCompetencia;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idAvaliacao")
	private AvaliacaoEntity avaliacao;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCompetencia")
	private CompetenciaEntity competencia;
	
	@Column(name="nmAvaliador")
	private String nmAvaliador;
	
	@Column(name="idCandidato")
	private Integer idCandidato;
	
	@Column(name = "idVaga")
	private Integer idVaga;

	public Integer getIdCandidatoCompetencia() {
		return idCandidatoCompetencia;
	}

	public void setIdCandidatoCompetencia(Integer idCandidatoCompetencia) {
		this.idCandidatoCompetencia = idCandidatoCompetencia;
	}

	public AvaliacaoEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public CompetenciaEntity getCompetencia() {
		return competencia;
	}

	public void setCompetencia(CompetenciaEntity competencia) {
		this.competencia = competencia;
	}

	public String getNmAvaliador() {
		return nmAvaliador;
	}

	public void setNmAvaliador(String nmAvaliador) {
		this.nmAvaliador = nmAvaliador;
	}

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
}
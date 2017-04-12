package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idCandidatoCompetencia", unique = true, nullable = false)
	private Integer idCandidatoCompetencia;

	@OneToOne
	@JoinColumn(name = "idAvaliacao")
	private AvaliacaoEntity avaliacao;

	@OneToOne
	@JoinColumn(name = "idCompetencia")
	private CompetenciaEntity competencia;

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

}

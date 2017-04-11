package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbCandidatoCompetencia")
@NamedQuery(name="obterCompetencias", query="SELECT cc FROM CandidatoCompetenciaEntity cc")
public class CandidatoCompetenciaEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idCandidatoCompetencia", unique = true, nullable = false)
	private Integer idCandidatoCompetencia;

	@OneToMany
	@JoinColumn(name = "idAvaliacao")
	private List<AvaliacaoEntity> avaliacao;

	@OneToMany
	@JoinColumn(name = "idCompetencia")
	private List<CompetenciaEntity> competencia;

	public Integer getIdCandidatoCompetencia() {
		return idCandidatoCompetencia;
	}

	public void setIdCandidatoCompetencia(Integer idCandidatoCompetencia) {
		this.idCandidatoCompetencia = idCandidatoCompetencia;
	}

	public List<AvaliacaoEntity> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<AvaliacaoEntity> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<CompetenciaEntity> getCompetencia() {
		return competencia;
	}

	public void setCompetencia(List<CompetenciaEntity> competencia) {
		this.competencia = competencia;
	}

}

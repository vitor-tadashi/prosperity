package br.com.prosperity.entity;

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
@Table(name = "tbCandidatoCompetencia")
public class CandidatoCompetenciaEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idCandidatoCompetencia", unique = true, nullable = false)
	private Integer idCandidatoCompetencia;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidatoEntity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idAvaliacao")
	private AvaliacaoEntity avaliacaoEntity;

	public Integer getIdCandidatoCompetencia() {
		return idCandidatoCompetencia;
	}

	public void setIdCandidatoCompetencia(Integer idCandidatoCompetencia) {
		this.idCandidatoCompetencia = idCandidatoCompetencia;
	}

	public CandidatoEntity getCandidatoEntity() {
		return candidatoEntity;
	}

	public void setCandidatoEntity(CandidatoEntity candidatoEntity) {
		this.candidatoEntity = candidatoEntity;
	}

	public AvaliacaoEntity getAvaliacaoEntity() {
		return avaliacaoEntity;
	}

	public void setAvaliacaoEntity(AvaliacaoEntity avaliacaoEntity) {
		this.avaliacaoEntity = avaliacaoEntity;
	}

}

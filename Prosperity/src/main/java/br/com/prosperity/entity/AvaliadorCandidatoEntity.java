package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliadorCandidato")
@NamedQueries({
		@NamedQuery(name = "obterAvaliadoresCandidato", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.status = null")})

public class AvaliadorCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@OneToOne
	@JoinColumn(name = "idAvaliadorVaga")
	private AvaliadorVagaEntity avaliadorVaga;

	@Column(name = "idStatus")
	private Integer status = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public AvaliadorVagaEntity getAvaliadorVaga() {
		return avaliadorVaga;
	}

	public void setAvaliadorVaga(AvaliadorVagaEntity avaliadorVaga) {
		this.avaliadorVaga = avaliadorVaga;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

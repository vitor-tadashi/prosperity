package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliadorCandidato")
@NamedQuery(name = "obterAvaliadoresCandidato", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.idStatus = null")
public class AvaliadorCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idAvaliador")
	private AvaliadorEntity idAvaliador;

	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity idCandidato;

	@Column(name = "idStatus")
	private Integer idStatus = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AvaliadorEntity getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(AvaliadorEntity idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public CandidatoEntity getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(CandidatoEntity idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
}

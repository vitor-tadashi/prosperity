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
@Table(name = "tbProvaCandidato")
@NamedQuery(name = "queryProva", query = "SELECT u FROM ProvaCandidatoEntity u LEFT OUTER JOIN u.provas c WHERE u.candidato.id = ?1")

public class ProvaCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProvaCandidato", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idProva")
	private ProvaEntity provas;

	@Column(name = "cmProva")
	private String caminhoProva;
	
	@Column(name="idVaga")
	private Integer idVaga;

	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

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

	public String getCaminhoProva() {
		return caminhoProva;
	}

	public void setCaminhoProva(String caminhoProva) {
		this.caminhoProva = caminhoProva;
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}

	public ProvaEntity getProvas() {
		return provas;
	}

	public void setProvas(ProvaEntity provas) {
		this.provas = provas;
	}
}
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
@Table(name = "tbProvaCandidato")
@NamedQueries({
 @NamedQuery(name = "queryProva", query = "SELECT u FROM ProvaCandidatoEntity u LEFT OUTER JOIN u.provas c WHERE u.candidato.id = ?1")
})

public class ProvaCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProvaCandidato", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idProva")
	private ProvaEntity provas;

	@Column(name = "dsProva")
	private String descricaoProva;
	
	@Column(name = "cmProva")
	private String caminhoProva;

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

	public String getDescricaoProva() {
		return descricaoProva;
	}

	public void setDescricaoProva(String descricaoProva) {
		this.descricaoProva = descricaoProva;
	}

	public String getCaminhoProva() {
		return caminhoProva;
	}

	public void setCaminhoProva(String caminhoProva) {
		this.caminhoProva = caminhoProva;
	}

	public ProvaEntity getProvas() {
		return provas;
	}

	public void setProvas(ProvaEntity provas) {
		this.provas = provas;
	}

}

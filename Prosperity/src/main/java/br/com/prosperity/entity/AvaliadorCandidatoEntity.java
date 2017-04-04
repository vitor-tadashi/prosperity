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
@NamedQuery(name = "obterAvaliadoresCandidato", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.idStatus = null"),
@NamedQuery(name = "obterAvaliadoresDaVaga", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.vaga = ?1")
})

public class AvaliadorCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@OneToOne
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@OneToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@Column(name = "idStatus")
	private Integer idStatus = null;

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

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
}

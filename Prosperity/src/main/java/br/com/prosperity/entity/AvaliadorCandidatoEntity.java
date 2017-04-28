package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
		@NamedQuery(name = "atualizarAvaliador", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.status is null AND u.usuario.id = ?1 AND u.candidato = ?2"),
		@NamedQuery(name = "obterAvaliadoresCandidato", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.status is null AND u.candidato = ?1"),
		@NamedQuery(name = "obterProposta", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.candidato.id = ?1"),
		@NamedQuery(name = "desativarAvaliadores", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.candidato.id = ?1 AND u.status IS NULL"),
		@NamedQuery(name = "desativarAvaliadoresPorVaga", query = "SELECT u FROM AvaliadorCandidatoEntity u WHERE u.vaga.id = ?1")})

public class AvaliadorCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}

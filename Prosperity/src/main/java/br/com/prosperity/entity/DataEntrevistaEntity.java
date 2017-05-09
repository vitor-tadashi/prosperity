package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbDataEntrevista")
public class DataEntrevistaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDataEntrevista", unique = true, nullable = false)
	private Integer idDataEntrevista;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dtEntrevista")
	private Date dtEntrevista;

	public Integer getIdDataEntrevista() {
		return idDataEntrevista;
	}

	public void setIdDataEntrevista(Integer idDataEntrevista) {
		this.idDataEntrevista = idDataEntrevista;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
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

	public Date getDtEntrevista() {
		return dtEntrevista;
	}

	public void setDtEntrevista(Date dtEntrevista) {
		this.dtEntrevista = dtEntrevista;
	}

}

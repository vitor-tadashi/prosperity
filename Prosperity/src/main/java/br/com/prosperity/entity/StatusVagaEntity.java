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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbStatusVaga")
@NamedQueries({
		@NamedQuery(name = "obterStatusVaga", query = "SELECT v FROM StatusVagaEntity v WHERE v.vaga = ?1 AND v.situacao = TRUE"),
		@NamedQuery(name = "desativarStatusVaga", query = "SELECT sv FROM StatusVagaEntity sv WHERE sv.vaga = ?1") })

public class StatusVagaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStatusVaga", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@Column(name = "flSituacao")
	private Boolean situacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
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

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
}
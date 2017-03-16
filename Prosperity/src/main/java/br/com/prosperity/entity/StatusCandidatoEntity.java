
package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbStatusCandidato")

public class StatusCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatusCandidato", unique = true, nullable = false)
	private Integer idSatusCandidato;
	/* fim */

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtAlteracao;

	@Column(name = "dsParecer")
	private String dsParecer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	public Integer getIdSatusCandidato() {
		return idSatusCandidato;
	}

	public void setIdSatusCandidato(Integer idSatusCandidato) {
		this.idSatusCandidato = idSatusCandidato;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getDsParecer() {
		return dsParecer;
	}

	public void setDsParecer(String dsParecer) {
		this.dsParecer = dsParecer;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}

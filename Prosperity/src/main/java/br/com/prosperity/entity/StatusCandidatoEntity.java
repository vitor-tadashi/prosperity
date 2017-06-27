
package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "tbStatusCandidato")
@NamedQueries({
		@NamedQuery(name = "obterStatusCandidato", query = "SELECT sc FROM StatusCandidatoEntity sc WHERE sc.candidato.id = ?1 AND sc.flSituacao = true"),
		@NamedQuery(name = "desativarStatus", query = "SELECT sc FROM StatusCandidatoEntity sc WHERE sc.candidato.id = ?1"),
		@NamedQuery(name = "obterStatusCandidatos", query = "SELECT sc FROM StatusCandidatoEntity sc WHERE sc.candidato IN (?1) AND sc.flSituacao = true") })
public class StatusCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStatusCandidato", unique = true, nullable = false)
	private Integer idStatusCandidato;

	@ManyToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtAlteracao;

	@Column(name = "dsParecer")
	private String dsParecer;

	@Column(name = "flSituacao")
	private Boolean flSituacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCancelamento")
	private CancelamentoEntity cancelamento;

	@Column(name = "dsCancelamento")
	private String dsCancelamento;
	
	@Column(name = "nmVaga")
	private String nmVaga;
	
	@Column(name = "idVaga")
	private Integer idVaga;

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
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

	public Integer getIdStatusCandidato() {
		return idStatusCandidato;
	}

	public void setIdStatusCandidato(Integer idStatusCandidato) {
		this.idStatusCandidato = idStatusCandidato;
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

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

	public CancelamentoEntity getCancelamento() {
		return cancelamento;
	}

	public void setCancelamento(CancelamentoEntity cancelamento) {
		this.cancelamento = cancelamento;
	}

	public String getDsCancelamento() {
		return dsCancelamento;
	}

	public void setDsCancelamento(String dsCancelamento) {
		this.dsCancelamento = dsCancelamento;
	}

	public String getNmVaga() {
		return nmVaga;
	}

	public void setNmVaga(String nmVaga) {
		this.nmVaga = nmVaga;
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
}
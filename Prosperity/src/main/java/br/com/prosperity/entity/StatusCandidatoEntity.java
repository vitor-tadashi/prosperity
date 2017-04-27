
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tbStatusCandidato")
@NamedQuery(name="obterStatusCandidato",query="SELECT sc FROM StatusCandidatoEntity sc WHERE sc.candidato.id = ?1 AND sc.flSituacao = true")
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
	
	//TODO vereficar relacionamento IGOR
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@Column(name = "proposta")
	private String proposta;
	
	public String getProposta() {
		return proposta;
	}
	
	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

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

}

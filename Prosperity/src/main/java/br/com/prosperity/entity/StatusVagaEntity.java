package br.com.prosperity.entity;

import java.awt.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbStatusVaga")
public class StatusVagaEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatusVaga", unique = true, nullable = false)
	private Integer id;
	/* fim */

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@Column(name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	@Column(name = "idVaga")
	private Integer vaga;

	/* fim dos mapeamentos */

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

	public Integer getVaga() {
		return vaga;
	}

	public void setVaga(Integer vaga) {
		this.vaga = vaga;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}

package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatus")

public class StatusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus", unique = true, nullable = false)
	private Integer id;
	/* fim */

	@Column(name = "nmStatus")
	private String nome;

	@Column(name = "tpCss")
	private String tipoCss;

	@ManyToOne
	@JoinColumn(name="idTpStatus")
	private TipoStatusEntity tipoStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatusCandidato")
	private StatusCandidatoEntity statusCandidatoEntity;

	
	
	public StatusCandidatoEntity getStatusCandidatoEntity() {
		return statusCandidatoEntity;
	}

	public void setStatusCandidatoEntity(StatusCandidatoEntity statusCandidatoEntity) {
		this.statusCandidatoEntity = statusCandidatoEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCss() {
		return tipoCss;
	}

	public void setTipoCss(String tipoCss) {
		this.tipoCss = tipoCss;
	}

	public TipoStatusEntity getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(TipoStatusEntity tipoStatus) {
		this.tipoStatus = tipoStatus;
	}
	
	

}

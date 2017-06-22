package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "obterComunicacao", query = "SELECT c FROM ComunicacaoEntity c WHERE c.candidatoEntity.id =?1")
@Entity
@Table(name = "tbComunicacao")
public class ComunicacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComunicacao", unique = true, nullable = false)
	private Integer id;

	@Column(name = "dtContato")
	private Date dataContato;

	@Column(name = "dsObservacao")
	private String observacao;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuarioEntity;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidatoEntity;
	
	@Column(name = "idVaga")
	private Integer idVaga;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataContato() {
		return dataContato;
	}

	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public CandidatoEntity getCandidatoEntity() {
		return candidatoEntity;
	}

	public void setCandidatoEntity(CandidatoEntity candidatoEntity) {
		this.candidatoEntity = candidatoEntity;
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
}
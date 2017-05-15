package br.com.prosperity.entity;

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
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliadorVaga")
@NamedQueries({ 
@NamedQuery(name = "obterAvaliadores", query = "SELECT u FROM AvaliadorVagaEntity u "),
@NamedQuery(name = "obterAvaliadoresDaVaga", query = "SELECT u FROM AvaliadorVagaEntity u WHERE u.vaga.id = ?1"),
@NamedQuery(name = "queryAvaliador", query = "select v.nome from AvaliadorVagaEntity u LEFT OUTER JOIN u.usuario v LEFT OUTER JOIN u.vaga x WHERE u.vaga.id = ?1")
})
public class AvaliadorVagaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliadorVaga", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.DETACH)
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

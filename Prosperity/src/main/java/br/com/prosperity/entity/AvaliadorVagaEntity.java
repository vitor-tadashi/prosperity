package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliadorVaga")
@NamedQueries({ 
@NamedQuery(name = "obterAvaliadores", query = "SELECT u FROM AvaliadorVagaEntity u "),
@NamedQuery(name = "obterAvaliadoresDaVaga", query = "SELECT u FROM AvaliadorVagaEntity u WHERE u.vaga = ?1")
})
public class AvaliadorVagaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliadorVaga", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@OneToOne
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

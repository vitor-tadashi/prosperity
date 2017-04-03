package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliador")
@NamedQueries({ 
@NamedQuery(name = "obterAvaliadores", query = "SELECT u FROM AvaliadorEntity u "),
@NamedQuery(name = "obterAvaliadoresDaVaga", query = "SELECT u FROM AvaliadorEntity u WHERE u.vaga = ?1")
})
public class AvaliadorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliador", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

}

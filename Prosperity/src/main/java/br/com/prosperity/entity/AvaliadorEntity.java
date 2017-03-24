package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliador")
@NamedQuery(name = "obterAvaliadores", query = "SELECT u FROM AvaliadorEntity u WHERE u.status = false")
public class AvaliadorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliador", unique = true, nullable = false)
	private Integer id;

	@Column(name = "status")
	private Boolean status;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

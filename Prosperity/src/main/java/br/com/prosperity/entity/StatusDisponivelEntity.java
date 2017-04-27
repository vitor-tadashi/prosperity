package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatusDisponivel")
public class StatusDisponivelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStatusHabilitado", unique = true, nullable = false)
	private Integer id;

	@Column(name = "idStatusDisponivel")
	private Integer idStatusDisponivel;

	@Column(name = "nmOpcao")
	private String nome;

	@Column(name = "nmClasse")
	private String classe;

	@ManyToOne
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdStatusDisponivel() {
		return idStatusDisponivel;
	}

	public void setIdStatusDisponivel(Integer idStatusDisponivel) {
		this.idStatusDisponivel = idStatusDisponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

}

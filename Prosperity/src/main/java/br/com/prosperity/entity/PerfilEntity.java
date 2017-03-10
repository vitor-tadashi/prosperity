package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbPerfil")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM PerfilEntity p")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	@Column(name="idPerfil", unique=true, nullable=false)
	private Integer id;

	@Column(name="nmPerfil")
	private String nome;

	@ManyToMany
	@JoinTable(name="tbFuncionalidade", joinColumns={@JoinColumn(name="idFuncionalidade")}, inverseJoinColumns={@JoinColumn(name="idPerfil")})
	private List<FuncionalidadeEntity> funcionalidade;

	public PerfilEntity() {

	}

	public PerfilEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;

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

	public List<FuncionalidadeEntity> getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(List<FuncionalidadeEntity> funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	
}

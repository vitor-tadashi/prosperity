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
@NamedQuery(name = "obterNomePerfil", query = "SELECT p FROM PerfilEntity p WHERE p .nome = ?1")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idPerfil", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmPerfil")
	private String nome;

	@ManyToMany
	@JoinTable(name = "tbPerfilFuncionalidade", joinColumns = { @JoinColumn(name = "idPerfil") }, inverseJoinColumns = {
			@JoinColumn(name = "idFuncionalidade") })
	private List<FuncionalidadeEntity> funcionalidades;

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

	public List<FuncionalidadeEntity> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadeEntity> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}

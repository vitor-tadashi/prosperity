package br.com.prosperity.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbPerfil")
public class PerfilEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idPerfil", unique = true)
	private Integer id;

	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;


	/*
	 * Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga
	 * 1-N
	 */
	@ManyToMany
	 @JoinTable(name="tbPerfilFuncionalidade", joinColumns={@JoinColumn(name="idPerfil")}, inverseJoinColumns={@JoinColumn(name="idFuncionalidade")})
	 private List<FuncionalidadeEntity> funcionalidadeEntity;


	
/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	/*@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;*/
	

	// relacionamento avaliadores
	/* fim dos mapeamentos */


	public PerfilEntity(Integer idPerfil, String nome, List<FuncionalidadeEntity> funcionalidadeEntity) {
		this.id = idPerfil;
		this.nome = nome;
		this.funcionalidadeEntity = funcionalidadeEntity;
	}

	public PerfilEntity() {

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

	public List<FuncionalidadeEntity> getFuncionalidadeEntity() {
		return funcionalidadeEntity;
	}

	public void setFuncionalidadeEntity(List<FuncionalidadeEntity> funcionalidade) {
		this.funcionalidadeEntity = funcionalidade;
	}
	
}

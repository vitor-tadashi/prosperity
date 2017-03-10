package br.com.prosperity.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbPerfil")
public class PerfilEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)

//	@Column(name = "idPerfil", unique = true, nullable = false)
//	private Integer idPerfil;

	@Column(name="idPerfil", unique = true, nullable = false)
	private Integer id;

	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;


	/*
	 * Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga
	 * 1-N
	 */

	@ManyToMany()
	@JoinColumn(name="idFuncionalidade")
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

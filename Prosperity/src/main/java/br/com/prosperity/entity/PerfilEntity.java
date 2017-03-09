package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbPerfil")
public class PerfilEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	private int idPerfil;
	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;

	/*
	 * Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga
	 * 1-N
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	private FuncionalidadeEntity funcionalidadeEntity;

	// relacionamento avaliadores
	/* fim dos mapeamentos */

	public PerfilEntity(int idPerfil, String nome, FuncionalidadeEntity funcionalidadeEntity) {
		this.idPerfil = idPerfil;
		this.nome = nome;
		this.funcionalidadeEntity = funcionalidadeEntity;
	}

	public PerfilEntity() {

	}

	public FuncionalidadeEntity getFuncionalidadeEntity() {
		return funcionalidadeEntity;
	}

	public void setFuncionalidadeEntity(FuncionalidadeEntity funcionalidadeEntity) {
		this.funcionalidadeEntity = funcionalidadeEntity;
	}

	public int getId() {
		return idPerfil;
	}

	public void setId(int id) {
		this.idPerfil = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

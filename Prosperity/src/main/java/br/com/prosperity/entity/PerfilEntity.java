package br.com.prosperity.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbPerfil")
public class PerfilEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)

	@Column(name = "idUsuario", unique = true, nullable = false)
	private int idPerfil;

	@Column(name="idPerfil", unique = true, nullable = false)
	private Integer id;

	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;


	/*
	 * Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga
	 * 1-N
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	private FuncionalidadeEntity funcionalidadeEntity;


	
/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	/*@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;*/
	

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
	/*public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}*/

	public PerfilEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;

	}

	public void setFuncionalidadeEntity(FuncionalidadeEntity funcionalidadeEntity) {
		this.funcionalidadeEntity = funcionalidadeEntity;
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
}

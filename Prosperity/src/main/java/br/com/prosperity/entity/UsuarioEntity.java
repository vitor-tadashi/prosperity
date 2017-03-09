package br.com.prosperity.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: PerfilFuncionalidadeEntity
 *
 */
@Entity
@Table(name="tbUsuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idUsuario", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private FuncionarioEntity funcionarioEntity;
	
	@Column(name = "nmUsuario")
	private String nome;
	
	@Column(name = "senha")
	private String senha;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}

	public FuncionarioEntity getFuncionarioEntity() {
		return funcionarioEntity;
	}

	public void setFuncionarioEntity(FuncionarioEntity funcionarioEntity) {
		this.funcionarioEntity = funcionarioEntity;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

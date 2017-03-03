package br.com.prosperity.entity;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PerfilFuncionalidadeEntity
 *
 */
@Entity
@Table(name="tbUsuario")

public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCliente", unique = true)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PerfilEntity idPerfil;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idFuncionario")
	private FuncionarioEntity idFuncionario;
	
	//classes
	@Column(name="nmUsuario")
	private String nome;
	
	@Column(name="senha")
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PerfilEntity getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(PerfilEntity idPerfil) {
		this.idPerfil = idPerfil;
	}

	public FuncionarioEntity getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(FuncionarioEntity idFuncionario) {
		this.idFuncionario = idFuncionario;
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

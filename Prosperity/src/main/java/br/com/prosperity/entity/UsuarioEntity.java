package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: PerfilFuncionalidadeEntity
 *
 */
@Entity
@Table(name = "tbUsuario")
@NamedQueries({
	@NamedQuery(name = "obterPorUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.nome = ?1"),
	@NamedQuery(name="populaTabela", query="SELECT u FROM UsuarioEntity u")
	})
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerfil")
	private PerfilEntity perfilEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFuncionario")
	private FuncionarioEntity funcionarioEntity;

	@Column(name = "nmUsuario")
	private String nome;
	
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "flPrimeiroAcesso")
	private Boolean primeiroAcesso;
	
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

	public Boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

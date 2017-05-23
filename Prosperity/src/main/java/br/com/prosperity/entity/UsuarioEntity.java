package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbUsuario")
@NamedQueries({
	@NamedQuery(name = "obterPorUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.nome = ?1 AND u.ativo = true"),
	@NamedQuery(name="obterGestor", query="SELECT u FROM UsuarioEntity u LEFT OUTER JOIN u.perfilEntity p WHERE p.nome like 'Gestor%'"),
	@NamedQuery(name = "existeUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.nome = ?1"),
	@NamedQuery(name = "obterUsuariosAtivos", query = "SELECT u FROM UsuarioEntity u WHERE u.ativo = true"),
	@NamedQuery(name = "existeUsuarioAlterar", query = "SELECT u FROM UsuarioEntity u WHERE u.nome = ?2 AND u.id NOT LIKE ?1")
	

})
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerfil")
	private PerfilEntity perfilEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFuncionario")
	private FuncionarioEntity funcionarioEntity;
	
	@NotNull
	@Size(min=5, message="O usuário não pode ter menos que 5 caracteres!")
	@Column(name = "nmUsuario")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "flPrimeiroAcesso")
	private Boolean primeiroAcesso;

	@Column(name = "ativo")
	private Boolean ativo;

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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}

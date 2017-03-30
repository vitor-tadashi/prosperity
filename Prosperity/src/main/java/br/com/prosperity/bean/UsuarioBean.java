package br.com.prosperity.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBean {

	private final String SENHA_PADRAO = "verity@123";

	private Integer id;

	@NotNull
	private PerfilBean perfil;

	@NotNull
	private FuncionarioBean funcionario;

	@NotNull
	@Size(min = 5, max = 20)
	private String nome;

	private String senha = SENHA_PADRAO;

	private Boolean autenticado;

	private Boolean primeiroAcesso = true;

	@NotNull
	@Email
	private String email;

	private Boolean ativo = true;

	public UsuarioBean() {
		autenticado = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PerfilBean getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}

	public FuncionarioBean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
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

	public String getSENHA_PADRAO() {
		return SENHA_PADRAO;
	}
}

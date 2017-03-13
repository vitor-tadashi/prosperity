package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class UsuarioBean {
	private Integer id;
	private PerfilBean perfil;
	private FuncionarioBean funcionario;
	private String nome;
	private String senha = "verity@123";
	private Boolean autenticado;
	private Boolean primeiroAcesso = true;
	private String email;
	
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
		this.nome = nome;
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
	
	
}

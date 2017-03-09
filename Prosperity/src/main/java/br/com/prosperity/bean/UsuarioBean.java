package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class UsuarioBean {
	private Integer id;
	private PerfilBean perfil;
	private FuncionarioBean funcionario;
	private String nome;
	private String senha;
	
	//métodos
	public UsuarioBean() {
		
	}
	public UsuarioBean(PerfilBean perfil, FuncionarioBean funcionario, String nome, String senha) {
		this.perfil = perfil;
		this.funcionario = funcionario;
		this.nome = nome;
		this.senha = senha;
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
}

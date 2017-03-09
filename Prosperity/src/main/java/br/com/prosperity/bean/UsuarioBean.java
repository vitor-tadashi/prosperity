package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class UsuarioBean {
	private Integer id;
	private PerfilBean perfil;
	private FuncionarioBean funcionario;
	private String nome;
	private String senha;
	
	public PerfilBean getPerfil() {
		return perfil;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

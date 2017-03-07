package br.com.prosperity.bean;

public class UsuarioBean {
	private int IdUsuario;
	private PerfilBean perfil;
	private FuncionarioBean funcionario;
	//classes
	private String nome;
	private String senha;
	
	//métodos
	
	public UsuarioBean() {
		
	}
	public PerfilBean getPerfil() {
		return perfil;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}
	public FuncionarioBean getFuncionario() {
		return funcionario;
	}
	public UsuarioBean(PerfilBean perfil, FuncionarioBean funcionario, String nome	, String senha) {
		this.perfil = perfil;
		this.funcionario = funcionario;
		this.nome = nome;
		this.senha = senha;
	}
	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}
	public String getnome() {
		return nome;
	}
	public void setUsuario(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}

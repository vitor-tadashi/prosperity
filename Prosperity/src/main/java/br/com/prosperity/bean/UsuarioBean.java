package br.com.prosperity.bean;

public class UsuarioBean {

	private UsuarioBean idusuario;
	private PerfilBean idperfil;
	private FuncionarioBean idfuncionario;
	//classes
	private String usuario;
	private String senha;
	
	
	public UsuarioBean getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(UsuarioBean idusuario) {
		this.idusuario = idusuario;
	}
	public PerfilBean getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(PerfilBean idperfil) {
		this.idperfil = idperfil;
	}
	public FuncionarioBean getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(FuncionarioBean idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}

package br.com.prosperity.entity;

public class UsuarioEntity {

	private UsuarioEntity idusuario;
	private PerfilEntity idperfil;
	private FuncionarioEntity idfuncionario;
	//classes
	private String usuario;
	private String senha;
	
	
	public UsuarioEntity getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(UsuarioEntity idusuario) {
		this.idusuario = idusuario;
	}
	public PerfilEntity getIdperfil() {
		return idperfil;
	}
	public void setIdperfil(PerfilEntity idperfil) {
		this.idperfil = idperfil;
	}
	public FuncionarioEntity getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(FuncionarioEntity idfuncionario) {
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

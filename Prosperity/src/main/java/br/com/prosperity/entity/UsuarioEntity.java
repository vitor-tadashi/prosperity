package br.com.prosperity.entity;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name= "tbUsuario")
public class UsuarioEntity {
/* Mapeamento dos Atributos */
	
	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idUsuario", unique = true, nullable = false)
	private int id;
	/* fim Id */
	
	@Column(name = "nmUsuario")
	private String nomeUsuario;
	
	@Column(name = "nmUsuario")
	private String senhaUsuario;

	/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private FuncionarioEntity funcionarioEntity;

	// relacionamento avaliadores
				/* fim dos mapeamentos */
	
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

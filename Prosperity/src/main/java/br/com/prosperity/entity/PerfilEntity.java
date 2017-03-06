package br.com.prosperity.entity;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "tbPerfil")
public class PerfilEntity {
/* Mapeamento dos Atributos */
	
	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idUsuario", unique = true, nullable = false)
	private int id;
	/* fim Id */

	@Column(name = "nmPerfil")
	private String nomePerfil;
	
/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity avaliadorEntity;
	
	// relacionamento avaliadores
	/* fim dos mapeamentos */
	
	
	private List<FuncionalidadeEntity> permissoes; //relacionamento entre Perfil e Permiss�es

	public List<FuncionalidadeEntity> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<FuncionalidadeEntity> permissoes) {
		this.permissoes = permissoes;
	}

	public PerfilEntity(int id, String nome) {
		this.id = id;
		this.nomePerfil = nome;
	}
	
	public PerfilEntity(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nomePerfil;
	}

	public void setNome(String nome) {
		this.nomePerfil = nome;
	}
}

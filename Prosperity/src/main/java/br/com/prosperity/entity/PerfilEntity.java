package br.com.prosperity.entity;


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
	private int idPerfil;
	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;
	
/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;
	
	// relacionamento avaliadores
	/* fim dos mapeamentos */
	


	public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}

	public PerfilEntity(int idPerfil, String nome) {
		this.idPerfil = idPerfil;
		this.nome = nome;
	}
	
	public PerfilEntity(){
		
	}

	public int getId() {
		return idPerfil;
	}

	public void setId(int id) {
		this.idPerfil = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

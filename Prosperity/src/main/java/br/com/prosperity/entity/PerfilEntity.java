package br.com.prosperity.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tbPerfil")
public class PerfilEntity {
/* Mapeamento dos Atributos */
	
	/* Mapeamento do ID */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="idPerfil", unique = true, nullable = false)
	private Integer id;
	/* fim Id */

	@Column(name = "nmPerfil")
	private String nome;
	
/* Mapeamento de Relacionamentos Tudo o que estiver ligado na tabela Vaga 1-N*/
	
	/*@ManyToOne (cascade = CascadeType.ALL)
	private PerfilEntity perfilEntity;*/
	
	// relacionamento avaliadores
	/* fim dos mapeamentos */
	


	/*public PerfilEntity getPerfilEntity() {
		return perfilEntity;
	}

	public void setPerfilEntity(PerfilEntity perfilEntity) {
		this.perfilEntity = perfilEntity;
	}*/

	public PerfilEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public PerfilEntity(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

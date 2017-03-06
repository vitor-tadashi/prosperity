package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name= "tbStatus")

public class StatusEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/* fim */
	
	@Column(name = "nmStatus")
	private String nome;
	
	@Column(name = "tpCss")
	private String tipoCss;
	
	@Column(name = "id")
	private int idTpStatus;
	

	/* Mapeamento de Relacionamentos */
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTpStatus")
	private TipoStatusEntity status;


	/* fim dos mapeamentos */

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCss() {
		return tipoCss;
	}
	public void setTipoCss(String tipoCss) {
		this.tipoCss = tipoCss;
	}
	public int getIdTpStatus() {
		return idTpStatus;
	}
	public void setIdTpStatus(int idTpStatus) {
		this.idTpStatus = idTpStatus;
	}
	
	
}

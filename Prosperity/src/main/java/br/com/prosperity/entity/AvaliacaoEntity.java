package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbAvaliacao")
public class AvaliacaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliacao", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmAvaliacao")
	private String nome;
	@Column(name="tpCss")
	private String tipoCss;
	
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
	
	public String getTipoCss() {
		return tipoCss;
	}

	public void setTipoCss(String tipoCss) {
		this.tipoCss = tipoCss;
	}	
}
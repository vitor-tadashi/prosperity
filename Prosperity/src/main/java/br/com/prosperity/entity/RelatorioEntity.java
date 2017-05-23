package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbRelatorio")
public class RelatorioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRelatorio", unique = true)
	private Integer id;

	@Column(name = "nmRelatorio")
	private String nome;

	@Column(name = "cmRelatorio")
	private String caminho;

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

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
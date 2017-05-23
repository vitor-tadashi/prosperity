package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbFuncionalidade")
@NamedQuery(name = "obterPerfilFuncionalidade", query = "SELECT f FROM FuncionalidadeEntity f WHERE f.id IN (?1)")
public class FuncionalidadeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFuncionalidade", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmFuncionalidade")
	private String nome;

	@Column(name = "url")
	private String url;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
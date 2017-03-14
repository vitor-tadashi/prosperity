package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class ClienteBean {
	private Integer id;
	private String nome;

	public ClienteBean() {

	}

	public ClienteBean(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

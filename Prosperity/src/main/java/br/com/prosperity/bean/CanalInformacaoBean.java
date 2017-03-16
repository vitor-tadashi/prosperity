package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class CanalInformacaoBean {
	private String nome;
	private Integer id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}





}

package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliacaoBean {
	private Integer id;
	private String nome;
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
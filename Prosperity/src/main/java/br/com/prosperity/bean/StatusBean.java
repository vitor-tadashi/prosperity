package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class StatusBean {

	private Integer id;
	private String nome;
	private String css;
	private TipoStatusBean tipo;
	
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

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		css = css;
	}

	public TipoStatusBean getTipo() {
		return tipo;
	}

	public void setTipo(TipoStatusBean tipo) {
		this.tipo = tipo;
	}
}

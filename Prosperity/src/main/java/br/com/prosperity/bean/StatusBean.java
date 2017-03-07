package br.com.prosperity.bean;

public class StatusBean {

	private int id;
	private String nome;
	private String Css;
	private String tipo;

	public StatusBean() {
	}

	public StatusBean(int id, String nome, String Css, String tipo) {
		this.id = id;

		this.nome = nome;
		this.Css = Css;
		this.tipo = tipo;
	}

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

	public String getCss() {
		return Css;
	}

	public void setCss(String css) {
		Css = css;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

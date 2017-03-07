package br.com.prosperity.bean;

public class StatusBean {
	private String idStatus;
	private String nome;
	private String Css;
	private String tipo;

	public StatusBean() {
	}

	public StatusBean(String idStatus, String nome, String Css, String tipo) {
		this.idStatus = idStatus;
		this.nome = nome;
		this.Css = Css;
		this.tipo = tipo;

	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
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

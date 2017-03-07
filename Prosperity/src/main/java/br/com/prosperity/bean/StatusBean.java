package br.com.prosperity.bean;

public class StatusBean {
	
	private int id;
	private String nome;
	private String Css;
	private String tipo;
	
	public StatusBean(int id, String nome, String Css, String tipo) {
		this.id = id;
		this.nome = nome;
		this.Css = Css;
		this.tipo = tipo;
		
	}
	public StatusBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCss() {
		return Css;
	}
	public void setCss(String Css) {
		this.Css = Css;
	}
	public String gettipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getnome() {
		return nome;
	}
	public void setNmStatus(String nome) {
		this.nome = nome;
	}
	
	

}

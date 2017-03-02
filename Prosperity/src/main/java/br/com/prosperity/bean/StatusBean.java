package br.com.prosperity.bean;

public class StatusBean {
	private String idStatus;
	private String nome;
	private String Css;
	private String tipo;
	
	public StatusBean(String idStatus, String nome, String Css, String tipo) {
		this.idStatus = idStatus;
		this.nome = nome;
		this.Css = Css;
		this.tipo = tipo;
		
	}
	public String getDescricao() {
		return idStatus;
	}
	public void setDescricao(String idStatus) {
		this.idStatus = idStatus;
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

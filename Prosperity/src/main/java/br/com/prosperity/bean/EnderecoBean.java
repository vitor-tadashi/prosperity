package br.com.prosperity.bean;

public class EnderecoBean {
	private int id;
	private String cep;
	private int numero;
	private String complemento;
	
	public EnderecoBean() {
		
	}
	
	public EnderecoBean(int id, String cep, int numero, String complemento) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}

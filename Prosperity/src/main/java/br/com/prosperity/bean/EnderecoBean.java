package br.com.prosperity.bean;

public class EnderecoBean {
	private int idEndereco;
	private String cep;
	private int numero;
	private String complemento;
	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int id) {
		this.idEndereco = id;
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

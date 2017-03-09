package br.com.prosperity.bean;

public class EnderecoBean {
	private Integer id;
	
	private String cep;
	private int numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String logradouro;
	
	
	public EnderecoBean() {
		
	}
	
	public EnderecoBean(Integer id, String cep, int numero, String complemento, String cidade,String estado, String logradouro) {
		super();
		this.setId(id);
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.logradouro = logradouro;
		
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

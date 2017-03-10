package br.com.prosperity.bean;

public class ProjetoBean {
	private int id;
	private String nome;
	private ClienteBean cliente;
	private FuncionarioBean funcionario;
	
	public ProjetoBean() {
		
	}
	
	public ProjetoBean(int id, String nome, ClienteBean cliente,
			FuncionarioBean funcionario) {
		this.id = id;
		this.nome = nome;
		this.cliente = cliente;
		this.funcionario = funcionario;
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
	public ClienteBean getCliente() {
		return cliente;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public FuncionarioBean getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}

}

package br.com.prosperity.bean;

public class ProjetoBean {
	private int idProjeto;
	private String nmProjeto;
	private String clienteProjeto;
	private FuncionarioBean funcionario;
	
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getNmProjeto() {
		return nmProjeto;
	}
	public void setNmProjeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}
	public String getClienteProjeto() {
		return clienteProjeto;
	}
	public void setClienteProjeto(String clienteProjeto) {
		this.clienteProjeto = clienteProjeto;
	}
	public FuncionarioBean getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}

}

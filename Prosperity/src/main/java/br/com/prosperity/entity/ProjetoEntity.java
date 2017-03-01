package br.com.prosperity.entity;

public class ProjetoEntity {
	private int idProjeto;
	private String nmProjeto;
	private String clienteProjeto;
	private FuncionarioEntity funcionario;
	
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
	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioEntity funcionario) {
		this.funcionario = funcionario;
	}

}

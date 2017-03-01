package br.com.prosperity.bean;

public class ContatoBean {
	private int idContato;
	private String telefone;
	private CandidatoBean candidato;
	
	public CandidatoBean getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}
	public int getIdContato() {
		return idContato;
	}
	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

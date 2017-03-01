package br.com.prosperity.bean;

public class ContatoBean {
	
	public ContatoBean() {
		
	}
	public ContatoBean(int id, String telefone, CandidatoBean candidato) {
		this.id = id;
		this.telefone = telefone;
		this.candidato = candidato;
	}
	private int id;
	private String telefone;
	private CandidatoBean candidato;
	
	public CandidatoBean getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class ContatoBean {
	
	private Integer id;
	private String telefone;
	private String celular;
	private CandidatoBean candidato;
	
	
	public ContatoBean() {
		
	}
	public ContatoBean(Integer id, String telefone, CandidatoBean candidato) {
		this.id = id;
		this.telefone = telefone;
		this.candidato = candidato;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public CandidatoBean getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}
	

}

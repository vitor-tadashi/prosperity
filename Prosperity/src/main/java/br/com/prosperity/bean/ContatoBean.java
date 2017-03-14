package br.com.prosperity.bean;

import org.springframework.stereotype.Component;


import br.com.prosperity.util.Formatar;

@Component
public class ContatoBean extends Formatar{

	
	private Integer id;
	private String telefone;
	private CandidatoBean candidato;
	
	
	
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
	
	public CandidatoBean getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}
	

}

package br.com.prosperity.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbContato")
public class ContatoEntity {
	
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idContato", unique = true, nullable = false)
	private int id;
	/* fim */

	@Column(name = "telefone")
	private String telefone;

	private String celular;
	
	private CandidatoEntity candidato;

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}

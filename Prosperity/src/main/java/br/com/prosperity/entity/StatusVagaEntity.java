package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatusVaga")

public class StatusVagaEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/* fim */
	
	@Column (name = "idStatus")
	private String idStatus;
	
	@Column (name = "idVaga")
	private String idVaga;
	
	@Column (name = "dtAlteracao")
	private Date dataAlteracao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	public String getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(String idVaga) {
		this.idVaga = idVaga;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}

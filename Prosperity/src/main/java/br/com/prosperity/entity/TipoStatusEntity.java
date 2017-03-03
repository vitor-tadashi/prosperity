package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "tbTpStatus")
	
	public class TipoStatusEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/* fim */
	
	@Column(name = "TpStatus")
	private char Status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = (char) status;
	}
}

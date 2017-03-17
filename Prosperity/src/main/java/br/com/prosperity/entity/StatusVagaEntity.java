package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbStatusVaga")

public class StatusVagaEntity {
	/* Mapeamento dos Atributos */

	/* Mapeamento do Id */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatusVaga", unique = true, nullable = false)
	private Integer id;
	/* fim */
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idStatus")
	private StatusEntity status;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="idVaga")
	//private VagaEntity vaga;
	
	@Column (name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	

	/* fim dos mapeamentos */


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}


	
	
	
}

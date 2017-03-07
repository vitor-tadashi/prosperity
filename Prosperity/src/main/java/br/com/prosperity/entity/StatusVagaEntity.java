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
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	/* fim */
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idStatus")
	private StatusEntity idStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idVaga")
	private VagaEntity idVaga;
	
	@Column (name = "dtAlteracao")
	@Temporal(TemporalType.DATE)
	private Date dataAlteracao;
	
	/* Mapeamento de Relacionamentos */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;
	
	/* fim dos mapeamentos */


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusEntity getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(StatusEntity idStatus) {
		this.idStatus = idStatus;
	}

	public VagaEntity getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(VagaEntity idVaga) {
		this.idVaga = idVaga;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}

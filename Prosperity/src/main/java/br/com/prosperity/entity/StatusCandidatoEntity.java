
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
@Table(name = "tbStatusCandidato")

public class StatusCandidatoEntity {

	/* Mapeamento dos Atributos */

	/* Mapeamento do ID */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatusCandidato", unique = true, nullable = false)
	private int id;
	/* fim */
	
	@Column (name = "cpf")
	private String cpf;
	
	@Column (name = "dtAlteracao")
	@Temporal(TemporalType.DATE)
	private Date dataAlteracao;
	
	@Column(name = "dsParecer")
	private String descricaoParecer;
	
	
	/* Mapeamento de Relacionamentos */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcpf")
	private CandidatoEntity candidato ;

	/* fim dos mapeamentos */


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getDescricaoParecer() {
		return descricaoParecer;
	}

	public void setDescricaoParecer(String descricaoParecer) {
		this.descricaoParecer = descricaoParecer;
	}
	
} 

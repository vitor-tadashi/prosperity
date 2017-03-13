
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
	private Integer id;
	/* fim */

	
	@Column (name = "dtAlteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	@Column(name = "dsParecer")
	private String descricaoParecer;
	
	
	/* Mapeamento de Relacionamentos */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStatus")
	private StatusEntity status;
	


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

	public String getDescricaoParecer() {
		return descricaoParecer;
	}

	public void setDescricaoParecer(String descricaoParecer) {
		this.descricaoParecer = descricaoParecer;
	}
	
} 

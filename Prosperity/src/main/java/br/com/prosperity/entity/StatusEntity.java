package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatus")
@NamedQuery(name="alterarStatus", query="SELECT u FROM StatusEntity u LEFT OUTER JOIN u.tipoStatus p WHERE p.id= 2")
public class StatusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idStatus", unique = true, nullable = false)
	private Integer id;
	/* fim */

	@Column(name = "nmStatus")
	private String nome;

	@Column(name = "tpCss")
	private String tipoCss;

	@ManyToOne
	@JoinColumn(name = "idTpStatus")
	private TipoStatusEntity tipoStatus;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idStatus")
	private List<StatusCandidatoEntity> statusCandidatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoCss() {
		return tipoCss;
	}

	public void setTipoCss(String tipoCss) {
		this.tipoCss = tipoCss;
	}

	public TipoStatusEntity getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(TipoStatusEntity tipoStatus) {
		this.tipoStatus = tipoStatus;
	}

}

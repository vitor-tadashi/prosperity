package br.com.prosperity.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbProvaCandidato")
public class ProvaCandidatoEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProvaCandidato", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "nmEtapa1")
	private String nome1;
	
	@Column(name = "dsEtapa1")
	private String descricao1;
	
	@Column(name = "nmEtapa2")
	private String nome2;
	
	@Column(name = "dsEtapa2")
	private String descricao2;
	
	@Column(name = "nmEtapa3")
	private String nome3;
	
	@Column(name = "dsEtapa3")
	private String descricao3;
	
	@Column(name = "dsParecer")
	private String parecer;
	
	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome1() {
		return nome1;
	}

	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}

	public String getDescricao1() {
		return descricao1;
	}

	public void setDescricao1(String descricao1) {
		this.descricao1 = descricao1;
	}

	public String getNome2() {
		return nome2;
	}

	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}

	public String getDescricao2() {
		return descricao2;
	}

	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}

	public String getNome3() {
		return nome3;
	}

	public void setNome3(String nome3) {
		this.nome3 = nome3;
	}

	public String getDescricao3() {
		return descricao3;
	}

	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}


}

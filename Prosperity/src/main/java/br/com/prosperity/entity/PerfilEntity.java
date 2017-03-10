package br.com.prosperity.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "tbPerfil")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM PerfilEntity p")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	@Column(name="idPerfil", unique=true, nullable=false)
	private Integer id;

	@Column(name="nmPerfil")
	private String nome;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idFuncionalidade")
	private FuncionalidadeEntity funcionalidade;

	public PerfilEntity(Integer id, String nome, FuncionalidadeEntity funcionalidade) {
		this.id = id;
		this.nome = nome;
		this.funcionalidade = funcionalidade;
	}

	public PerfilEntity() {

	}

	public PerfilEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;

	}

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

	public FuncionalidadeEntity getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(FuncionalidadeEntity funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	
}

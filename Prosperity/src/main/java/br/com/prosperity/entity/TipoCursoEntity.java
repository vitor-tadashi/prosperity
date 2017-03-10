package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbTipoCurso")
public class TipoCursoEntity {
	/* Mapeamento dos Atributos */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idTipoCurso", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmTipoCurso")
	private String descricao;

	@OneToMany
	@JoinColumn(name = "idTipoCurso")
	private List<FormacaoEntity> formacao;
	
	/* fim */

	public List<FormacaoEntity> getFormacao() {
		return formacao;
	}

	public void setFormacao(List<FormacaoEntity> formacao) {
		this.formacao = formacao;
	}

	public TipoCursoEntity(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public TipoCursoEntity() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

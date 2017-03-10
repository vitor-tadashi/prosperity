package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbSituacaoAtual")
public class SituacaoAtualEntity {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Integer idSituacaoAtual;
	
	@Column(name="nmSituacaoAtual")
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "idSituacaoAtual")
	private List<FormacaoEntity> formacao;
	
	public List<FormacaoEntity> getFormacao() {
		return formacao;
	}
	public void setFormacao(List<FormacaoEntity> formacao) {
		this.formacao = formacao;
	}
	public Integer getIdSituacaoAtual() {
		return idSituacaoAtual;
	}
	public void setIdSituacaoAtual(Integer idSituacaoAtual) {
		this.idSituacaoAtual = idSituacaoAtual;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

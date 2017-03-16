package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusCandidatoBean {

	private Integer id;
	private String cpf;
	private Date dataAlteracao;
	private String descricaoParecer;

	public void setId(Integer id) {
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

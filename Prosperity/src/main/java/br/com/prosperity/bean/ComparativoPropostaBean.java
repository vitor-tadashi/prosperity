package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ComparativoPropostaBean {
	private Integer id;
	private String nmFuncionario;
	private String nmCargo;
	private String nmSenioridade;
	private String dsConhecimento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtAdmissao;
	
	private Double vlrSalario;
	private Double vlrVr;
	private Double vlrVa;
	private Double vlrEstacionamento;
	private Double vlrCombustivel;
	private Double vlrAssistenciaMedica;
	private Double vlrOutros;
	private Double vlrTaxa;
	private Boolean flSituacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmFuncionario() {
		return nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}

	public String getNmCargo() {
		return nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}

	public String getNmSenioridade() {
		return nmSenioridade;
	}

	public void setNmSenioridade(String nmSenioridade) {
		this.nmSenioridade = nmSenioridade;
	}

	public String getDsConhecimento() {
		return dsConhecimento;
	}

	public void setDsConhecimento(String dsConhecimento) {
		this.dsConhecimento = dsConhecimento;
	}

	public Double getVlrSalario() {
		return vlrSalario;
	}

	public void setVlrSalario(Double vlrSalario) {
		this.vlrSalario = vlrSalario;
	}

	public Double getVlrVr() {
		return vlrVr;
	}

	public void setVlrVr(Double vlrVr) {
		this.vlrVr = vlrVr;
	}

	public Double getVlrVa() {
		return vlrVa;
	}

	public void setVlrVa(Double vlrVa) {
		this.vlrVa = vlrVa;
	}

	public Double getVlrEstacionamento() {
		return vlrEstacionamento;
	}

	public void setVlrEstacionamento(Double vlrEstacionamento) {
		this.vlrEstacionamento = vlrEstacionamento;
	}

	public Double getVlrCombustivel() {
		return vlrCombustivel;
	}

	public void setVlrCombustivel(Double vlrCombustivel) {
		this.vlrCombustivel = vlrCombustivel;
	}

	public Double getVlrAssistenciaMedica() {
		return vlrAssistenciaMedica;
	}

	public void setVlrAssistenciaMedica(Double vlrAssistenciaMedica) {
		this.vlrAssistenciaMedica = vlrAssistenciaMedica;
	}

	public Double getVlrOutros() {
		return vlrOutros;
	}

	public void setVlrOutros(Double vlrOutros) {
		this.vlrOutros = vlrOutros;
	}

	public Double getVlrTaxa() {
		return vlrTaxa;
	}

	public void setVlrTaxa(Double vlrTaxa) {
		this.vlrTaxa = vlrTaxa;
	}

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}

	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

}

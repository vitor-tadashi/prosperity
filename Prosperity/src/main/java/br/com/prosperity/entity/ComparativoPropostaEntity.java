package br.com.prosperity.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbComparativoProposta")
public class ComparativoPropostaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComparativoProposta", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nmFuncionario")
	private String nmFuncionario;

	@Column(name = "nmCargo")
	private String nmCargo;

	@Column(name = "nmSenioridade")
	private String nmSenioridade;

	@Column(name = "dsConhecimento")
	private String dsConhecimento;

	@Column(name = "dtAdmissao")
	@Temporal(TemporalType.DATE)
	private Date dtAdmissao;

	@Column(name = "vlrSalario")
	private Double vlrSalario;

	@Column(name = "vlrVr")
	private Double vlrVr;

	@Column(name = "vlrVa")
	private Double vlrVa;

	@Column(name = "vlrEstacionamento")
	private Double vlrEstacionamento;

	@Column(name = "vlrCombustivel")
	private Double vlrCombustivel;

	@Column(name = "vlrAssistenciaMedica")
	private Double vlrAssistenciaMedica;

	@Column(name = "vlrOutros")
	private Double vlrOutros;

	@Column(name = "vlrTaxa")
	private Double vlrTaxa;

	@Column(name = "flSituacao")
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

	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
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
}
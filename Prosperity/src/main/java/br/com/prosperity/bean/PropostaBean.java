package br.com.prosperity.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class PropostaBean {

	private Integer id;
	private CandidatoBean candidato;
	private String novaEmpresa;
	private String anteriorEmpresa;
	private String novoCargo;
	private String anteriorCargo;
	private BigDecimal anteriorSalarioFixoBruto;
	private BigDecimal novoSalarioFixoBruto;
	private BigDecimal anteriorSalarioLiquidoMensal;
	private BigDecimal novoSalarioLiquidoMensal;
	private BigDecimal anteriorVrMensal;
	private BigDecimal novoVrMensal;
	private BigDecimal anteriorSeguroSaudeMensal;
	private BigDecimal novoSeguroSaudeMensal;
	private BigDecimal anteriorValeAuto;
	private BigDecimal novoValeAuto;
	private BigDecimal anteriorEstacionamento;
	private BigDecimal novoEstacionamento;
	private BigDecimal anteriorValeTransporte;
	private BigDecimal novoValeTransporte;
	private BigDecimal anteriorLiquidoComBeneficios;
	private BigDecimal novoLiquidoComBeneficios;
	private BigDecimal anteriorAnualLiquido;
	private BigDecimal novoAnualLiquido;
	private BigDecimal anteriorParticipacaoLucrosOuBonus;
	private BigDecimal novaParticipacaoLucrosOuBonus;
	private BigDecimal anteriorTotalAnualLiquidoComBeneficios;
	private BigDecimal novoTotalAnualLiquidoComBeneficios;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CandidatoBean getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}
	public String getNovaEmpresa() {
		return novaEmpresa;
	}
	public void setNovaEmpresa(String novaEmpresa) {
		this.novaEmpresa = novaEmpresa;
	}
	public String getAnteriorEmpresa() {
		return anteriorEmpresa;
	}
	public void setAnteriorEmpresa(String anteriorEmpresa) {
		this.anteriorEmpresa = anteriorEmpresa;
	}
	public String getNovoCargo() {
		return novoCargo;
	}
	public void setNovoCargo(String novoCargo) {
		this.novoCargo = novoCargo;
	}
	public String getAnteriorCargo() {
		return anteriorCargo;
	}
	public void setAnteriorCargo(String anteriorCargo) {
		this.anteriorCargo = anteriorCargo;
	}
	public BigDecimal getAnteriorSalarioFixoBruto() {
		return anteriorSalarioFixoBruto;
	}
	public void setAnteriorSalarioFixoBruto(BigDecimal anteriorSalarioFixoBruto) {
		this.anteriorSalarioFixoBruto = anteriorSalarioFixoBruto;
	}
	public BigDecimal getNovoSalarioFixoBruto() {
		return novoSalarioFixoBruto;
	}
	public void setNovoSalarioFixoBruto(BigDecimal novoSalarioFixoBruto) {
		this.novoSalarioFixoBruto = novoSalarioFixoBruto;
	}
	public BigDecimal getAnteriorSalarioLiquidoMensal() {
		return anteriorSalarioLiquidoMensal;
	}
	public void setAnteriorSalarioLiquidoMensal(BigDecimal anteriorSalarioLiquidoMensal) {
		this.anteriorSalarioLiquidoMensal = anteriorSalarioLiquidoMensal;
	}
	public BigDecimal getNovoSalarioLiquidoMensal() {
		return novoSalarioLiquidoMensal;
	}
	public void setNovoSalarioLiquidoMensal(BigDecimal novoSalarioLiquidoMensal) {
		this.novoSalarioLiquidoMensal = novoSalarioLiquidoMensal;
	}
	public BigDecimal getAnteriorVrMensal() {
		return anteriorVrMensal;
	}
	public void setAnteriorVrMensal(BigDecimal anteriorVrMensal) {
		this.anteriorVrMensal = anteriorVrMensal;
	}
	public BigDecimal getNovoVrMensal() {
		return novoVrMensal;
	}
	public void setNovoVrMensal(BigDecimal novoVrMensal) {
		this.novoVrMensal = novoVrMensal;
	}
	public BigDecimal getAnteriorSeguroSaudeMensal() {
		return anteriorSeguroSaudeMensal;
	}
	public void setAnteriorSeguroSaudeMensal(BigDecimal anteriorSeguroSaudeMensal) {
		this.anteriorSeguroSaudeMensal = anteriorSeguroSaudeMensal;
	}
	public BigDecimal getNovoSeguroSaudeMensal() {
		return novoSeguroSaudeMensal;
	}
	public void setNovoSeguroSaudeMensal(BigDecimal novoSeguroSaudeMensal) {
		this.novoSeguroSaudeMensal = novoSeguroSaudeMensal;
	}
	public BigDecimal getAnteriorValeAuto() {
		return anteriorValeAuto;
	}
	public void setAnteriorValeAuto(BigDecimal anteriorValeAuto) {
		this.anteriorValeAuto = anteriorValeAuto;
	}
	public BigDecimal getNovoValeAuto() {
		return novoValeAuto;
	}
	public void setNovoValeAuto(BigDecimal novoValeAuto) {
		this.novoValeAuto = novoValeAuto;
	}
	public BigDecimal getAnteriorEstacionamento() {
		return anteriorEstacionamento;
	}
	public void setAnteriorEstacionamento(BigDecimal anteriorEstacionamento) {
		this.anteriorEstacionamento = anteriorEstacionamento;
	}
	public BigDecimal getNovoEstacionamento() {
		return novoEstacionamento;
	}
	public void setNovoEstacionamento(BigDecimal novoEstacionamento) {
		this.novoEstacionamento = novoEstacionamento;
	}
	public BigDecimal getAnteriorValeTransporte() {
		return anteriorValeTransporte;
	}
	public void setAnteriorValeTransporte(BigDecimal anteriorValeTransporte) {
		this.anteriorValeTransporte = anteriorValeTransporte;
	}
	public BigDecimal getNovoValeTransporte() {
		return novoValeTransporte;
	}
	public void setNovoValeTransporte(BigDecimal novoValeTransporte) {
		this.novoValeTransporte = novoValeTransporte;
	}
	public BigDecimal getAnteriorLiquidoComBeneficios() {
		return anteriorLiquidoComBeneficios;
	}
	public void setAnteriorLiquidoComBeneficios(BigDecimal anteriorLiquidoComBeneficios) {
		this.anteriorLiquidoComBeneficios = anteriorLiquidoComBeneficios;
	}
	public BigDecimal getNovoLiquidoComBeneficios() {
		return novoLiquidoComBeneficios;
	}
	public void setNovoLiquidoComBeneficios(BigDecimal novoLiquidoComBeneficios) {
		this.novoLiquidoComBeneficios = novoLiquidoComBeneficios;
	}
	public BigDecimal getAnteriorAnualLiquido() {
		return anteriorAnualLiquido;
	}
	public void setAnteriorAnualLiquido(BigDecimal anteriorAnualLiquido) {
		this.anteriorAnualLiquido = anteriorAnualLiquido;
	}
	public BigDecimal getNovoAnualLiquido() {
		return novoAnualLiquido;
	}
	public void setNovoAnualLiquido(BigDecimal novoAnualLiquido) {
		this.novoAnualLiquido = novoAnualLiquido;
	}
	public BigDecimal getAnteriorParticipacaoLucrosOuBonus() {
		return anteriorParticipacaoLucrosOuBonus;
	}
	public void setAnteriorParticipacaoLucrosOuBonus(BigDecimal anteriorParticipacaoLucrosOuBonus) {
		this.anteriorParticipacaoLucrosOuBonus = anteriorParticipacaoLucrosOuBonus;
	}
	public BigDecimal getNovaParticipacaoLucrosOuBonus() {
		return novaParticipacaoLucrosOuBonus;
	}
	public void setNovaParticipacaoLucrosOuBonus(BigDecimal novaParticipacaoLucrosOuBonus) {
		this.novaParticipacaoLucrosOuBonus = novaParticipacaoLucrosOuBonus;
	}
	public BigDecimal getAnteriorTotalAnualLiquidoComBeneficios() {
		return anteriorTotalAnualLiquidoComBeneficios;
	}
	public void setAnteriorTotalAnualLiquidoComBeneficios(BigDecimal anteriorTotalAnualLiquidoComBeneficios) {
		this.anteriorTotalAnualLiquidoComBeneficios = anteriorTotalAnualLiquidoComBeneficios;
	}
	public BigDecimal getNovoTotalAnualLiquidoComBeneficios() {
		return novoTotalAnualLiquidoComBeneficios;
	}
	public void setNovoTotalAnualLiquidoComBeneficios(BigDecimal novoTotalAnualLiquidoComBeneficios) {
		this.novoTotalAnualLiquidoComBeneficios = novoTotalAnualLiquidoComBeneficios;
	}

	
	
}

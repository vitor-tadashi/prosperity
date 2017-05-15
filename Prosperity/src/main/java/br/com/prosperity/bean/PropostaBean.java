package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class PropostaBean {

	private Integer id;
	private String novaEmpresa;
	private String anteriorEmpresa;
	private String novoCargo;
	private String anteriorCargo;
	private Double anteriorSalarioFixoBruto;
	private Double novoSalarioFixoBruto;
	private Double anteriorSalarioLiquidoMensal;
	private Double novoSalarioLiquidoMensal;
	private Double anteriorVrMensal;
	private Double novoVrMensal;
	private Double anteriorVaMensal;
	private Double novoVaMensal;
	private Double anteriorSeguroSaudeMensal;
	private Double novoSeguroSaudeMensal;
	private Double anteriorValeAuto;
	private Double novoValeAuto;
	private Double anteriorEstacionamento;
	private Double novoEstacionamento;
	private Double anteriorValeTransporte;
	private Double novoValeTransporte;
	private Double anteriorLiquidoComBeneficios;
	private Double novoLiquidoComBeneficios;
	private Double anteriorAnualLiquido;
	private Double novoAnualLiquido;
	private Double anteriorParticipacaoLucrosOuBonus;
	private Double novaParticipacaoLucrosOuBonus;
	private Double anteriorTotalAnualLiquidoComBeneficios;
	private Double novoTotalAnualLiquidoComBeneficios;
	private Boolean flSituacao = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getAnteriorSalarioFixoBruto() {
		return anteriorSalarioFixoBruto;
	}

	public void setAnteriorSalarioFixoBruto(Double anteriorSalarioFixoBruto) {
		this.anteriorSalarioFixoBruto = anteriorSalarioFixoBruto;
	}

	public Double getNovoSalarioFixoBruto() {
		return novoSalarioFixoBruto;
	}

	public void setNovoSalarioFixoBruto(Double novoSalarioFixoBruto) {
		this.novoSalarioFixoBruto = novoSalarioFixoBruto;
	}

	public Double getAnteriorSalarioLiquidoMensal() {
		return anteriorSalarioLiquidoMensal;
	}

	public void setAnteriorSalarioLiquidoMensal(Double anteriorSalarioLiquidoMensal) {
		this.anteriorSalarioLiquidoMensal = anteriorSalarioLiquidoMensal;
	}

	public Double getNovoSalarioLiquidoMensal() {
		return novoSalarioLiquidoMensal;
	}

	public void setNovoSalarioLiquidoMensal(Double novoSalarioLiquidoMensal) {
		this.novoSalarioLiquidoMensal = novoSalarioLiquidoMensal;
	}

	public Double getAnteriorVrMensal() {
		return anteriorVrMensal;
	}

	public void setAnteriorVrMensal(Double anteriorVrMensal) {
		this.anteriorVrMensal = anteriorVrMensal;
	}

	public Double getNovoVrMensal() {
		return novoVrMensal;
	}

	public void setNovoVrMensal(Double novoVrMensal) {
		this.novoVrMensal = novoVrMensal;
	}

	public Double getAnteriorVaMensal() {
		return anteriorVaMensal;
	}

	public void setAnteriorVaMensal(Double anteriorVaMensal) {
		this.anteriorVaMensal = anteriorVaMensal;
	}

	public Double getNovoVaMensal() {
		return novoVaMensal;
	}

	public void setNovoVaMensal(Double novoVaMensal) {
		this.novoVaMensal = novoVaMensal;
	}

	public Double getAnteriorSeguroSaudeMensal() {
		return anteriorSeguroSaudeMensal;
	}

	public void setAnteriorSeguroSaudeMensal(Double anteriorSeguroSaudeMensal) {
		this.anteriorSeguroSaudeMensal = anteriorSeguroSaudeMensal;
	}

	public Double getNovoSeguroSaudeMensal() {
		return novoSeguroSaudeMensal;
	}

	public void setNovoSeguroSaudeMensal(Double novoSeguroSaudeMensal) {
		this.novoSeguroSaudeMensal = novoSeguroSaudeMensal;
	}

	public Double getAnteriorValeAuto() {
		return anteriorValeAuto;
	}

	public void setAnteriorValeAuto(Double anteriorValeAuto) {
		this.anteriorValeAuto = anteriorValeAuto;
	}

	public Double getNovoValeAuto() {
		return novoValeAuto;
	}

	public void setNovoValeAuto(Double novoValeAuto) {
		this.novoValeAuto = novoValeAuto;
	}

	public Double getAnteriorEstacionamento() {
		return anteriorEstacionamento;
	}

	public void setAnteriorEstacionamento(Double anteriorEstacionamento) {
		this.anteriorEstacionamento = anteriorEstacionamento;
	}

	public Double getNovoEstacionamento() {
		return novoEstacionamento;
	}

	public void setNovoEstacionamento(Double novoEstacionamento) {
		this.novoEstacionamento = novoEstacionamento;
	}

	public Double getAnteriorValeTransporte() {
		return anteriorValeTransporte;
	}

	public void setAnteriorValeTransporte(Double anteriorValeTransporte) {
		this.anteriorValeTransporte = anteriorValeTransporte;
	}

	public Double getNovoValeTransporte() {
		return novoValeTransporte;
	}

	public void setNovoValeTransporte(Double novoValeTransporte) {
		this.novoValeTransporte = novoValeTransporte;
	}

	public Double getAnteriorLiquidoComBeneficios() {
		return anteriorLiquidoComBeneficios;
	}

	public void setAnteriorLiquidoComBeneficios(Double anteriorLiquidoComBeneficios) {
		this.anteriorLiquidoComBeneficios = anteriorLiquidoComBeneficios;
	}

	public Double getNovoLiquidoComBeneficios() {
		return novoLiquidoComBeneficios;
	}

	public void setNovoLiquidoComBeneficios(Double novoLiquidoComBeneficios) {
		this.novoLiquidoComBeneficios = novoLiquidoComBeneficios;
	}

	public Double getAnteriorAnualLiquido() {
		return anteriorAnualLiquido;
	}

	public void setAnteriorAnualLiquido(Double anteriorAnualLiquido) {
		this.anteriorAnualLiquido = anteriorAnualLiquido;
	}

	public Double getNovoAnualLiquido() {
		return novoAnualLiquido;
	}

	public void setNovoAnualLiquido(Double novoAnualLiquido) {
		this.novoAnualLiquido = novoAnualLiquido;
	}

	public Double getAnteriorParticipacaoLucrosOuBonus() {
		return anteriorParticipacaoLucrosOuBonus;
	}

	public void setAnteriorParticipacaoLucrosOuBonus(Double anteriorParticipacaoLucrosOuBonus) {
		this.anteriorParticipacaoLucrosOuBonus = anteriorParticipacaoLucrosOuBonus;
	}

	public Double getNovaParticipacaoLucrosOuBonus() {
		return novaParticipacaoLucrosOuBonus;
	}

	public void setNovaParticipacaoLucrosOuBonus(Double novaParticipacaoLucrosOuBonus) {
		this.novaParticipacaoLucrosOuBonus = novaParticipacaoLucrosOuBonus;
	}

	public Double getAnteriorTotalAnualLiquidoComBeneficios() {
		return anteriorTotalAnualLiquidoComBeneficios;
	}

	public void setAnteriorTotalAnualLiquidoComBeneficios(Double anteriorTotalAnualLiquidoComBeneficios) {
		this.anteriorTotalAnualLiquidoComBeneficios = anteriorTotalAnualLiquidoComBeneficios;
	}

	public Double getNovoTotalAnualLiquidoComBeneficios() {
		return novoTotalAnualLiquidoComBeneficios;
	}

	public void setNovoTotalAnualLiquidoComBeneficios(Double novoTotalAnualLiquidoComBeneficios) {
		this.novoTotalAnualLiquidoComBeneficios = novoTotalAnualLiquidoComBeneficios;
	}

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}

}

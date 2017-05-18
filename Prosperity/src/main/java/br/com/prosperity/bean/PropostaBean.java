package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PropostaBean {

	private Integer id;
	private String novaEmpresa;
	private String anteriorEmpresa;
	private String novoCargo;
	private String anteriorCargo;
	private double anteriorSalarioFixoBruto;
	private double novoSalarioFixoBruto;
	private double anteriorSalarioLiquidoMensal;
	private double novoSalarioLiquidoMensal;
	private double anteriorVrMensal;
	private double novoVrMensal;
	private double anteriorVaMensal;
	private double novoVaMensal;
	private double anteriorSeguroSaudeMensal;
	private double novoSeguroSaudeMensal;
	private double anteriorValeAuto;
	private double novoValeAuto;
	private double anteriorEstacionamento;
	private double novoEstacionamento;
	private double anteriorValeTransporte;
	private double novoValeTransporte;
	private double anteriorLiquidoComBeneficios;
	private double novoLiquidoComBeneficios;
	private double anteriorAnualLiquido;
	private double novoAnualLiquido;
	private double anteriorParticipacaoLucrosOuBonus;
	private double novaParticipacaoLucrosOuBonus;
	private double anteriorTotalAnualLiquidoComBeneficios;
	private double novoTotalAnualLiquidoComBeneficios;
	private Boolean flSituacao = false;

	private List<ComparativoPropostaBean> comparativoProposta;

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

	public double getAnteriorSalarioFixoBruto() {
		return anteriorSalarioFixoBruto;
	}

	public void setAnteriorSalarioFixoBruto(double anteriorSalarioFixoBruto) {
		this.anteriorSalarioFixoBruto = anteriorSalarioFixoBruto;
	}

	public double getNovoSalarioFixoBruto() {
		return novoSalarioFixoBruto;
	}

	public void setNovoSalarioFixoBruto(double novoSalarioFixoBruto) {
		this.novoSalarioFixoBruto = novoSalarioFixoBruto;
	}

	public double getAnteriorSalarioLiquidoMensal() {
		return anteriorSalarioLiquidoMensal;
	}

	public void setAnteriorSalarioLiquidoMensal(double anteriorSalarioLiquidoMensal) {
		this.anteriorSalarioLiquidoMensal = anteriorSalarioLiquidoMensal;
	}

	public double getNovoSalarioLiquidoMensal() {
		return novoSalarioLiquidoMensal;
	}

	public void setNovoSalarioLiquidoMensal(double novoSalarioLiquidoMensal) {
		this.novoSalarioLiquidoMensal = novoSalarioLiquidoMensal;
	}

	public double getAnteriorVrMensal() {
		return anteriorVrMensal;
	}

	public void setAnteriorVrMensal(double anteriorVrMensal) {
		this.anteriorVrMensal = anteriorVrMensal;
	}

	public double getNovoVrMensal() {
		return novoVrMensal;
	}

	public void setNovoVrMensal(double novoVrMensal) {
		this.novoVrMensal = novoVrMensal;
	}

	public double getAnteriorVaMensal() {
		return anteriorVaMensal;
	}

	public void setAnteriorVaMensal(double anteriorVaMensal) {
		this.anteriorVaMensal = anteriorVaMensal;
	}

	public double getNovoVaMensal() {
		return novoVaMensal;
	}

	public void setNovoVaMensal(double novoVaMensal) {
		this.novoVaMensal = novoVaMensal;
	}

	public double getAnteriorSeguroSaudeMensal() {
		return anteriorSeguroSaudeMensal;
	}

	public void setAnteriorSeguroSaudeMensal(double anteriorSeguroSaudeMensal) {
		this.anteriorSeguroSaudeMensal = anteriorSeguroSaudeMensal;
	}

	public double getNovoSeguroSaudeMensal() {
		return novoSeguroSaudeMensal;
	}

	public void setNovoSeguroSaudeMensal(double novoSeguroSaudeMensal) {
		this.novoSeguroSaudeMensal = novoSeguroSaudeMensal;
	}

	public double getAnteriorValeAuto() {
		return anteriorValeAuto;
	}

	public void setAnteriorValeAuto(double anteriorValeAuto) {
		this.anteriorValeAuto = anteriorValeAuto;
	}

	public double getNovoValeAuto() {
		return novoValeAuto;
	}

	public void setNovoValeAuto(double novoValeAuto) {
		this.novoValeAuto = novoValeAuto;
	}

	public double getAnteriorEstacionamento() {
		return anteriorEstacionamento;
	}

	public void setAnteriorEstacionamento(double anteriorEstacionamento) {
		this.anteriorEstacionamento = anteriorEstacionamento;
	}

	public double getNovoEstacionamento() {
		return novoEstacionamento;
	}

	public void setNovoEstacionamento(double novoEstacionamento) {
		this.novoEstacionamento = novoEstacionamento;
	}

	public double getAnteriorValeTransporte() {
		return anteriorValeTransporte;
	}

	public void setAnteriorValeTransporte(double anteriorValeTransporte) {
		this.anteriorValeTransporte = anteriorValeTransporte;
	}

	public double getNovoValeTransporte() {
		return novoValeTransporte;
	}

	public void setNovoValeTransporte(double novoValeTransporte) {
		this.novoValeTransporte = novoValeTransporte;
	}

	public double getAnteriorLiquidoComBeneficios() {
		return anteriorLiquidoComBeneficios;
	}

	public void setAnteriorLiquidoComBeneficios(double anteriorLiquidoComBeneficios) {
		this.anteriorLiquidoComBeneficios = anteriorLiquidoComBeneficios;
	}

	public double getNovoLiquidoComBeneficios() {
		return novoLiquidoComBeneficios;
	}

	public void setNovoLiquidoComBeneficios(double novoLiquidoComBeneficios) {
		this.novoLiquidoComBeneficios = novoLiquidoComBeneficios;
	}

	public double getAnteriorAnualLiquido() {
		return anteriorAnualLiquido;
	}

	public void setAnteriorAnualLiquido(double anteriorAnualLiquido) {
		this.anteriorAnualLiquido = anteriorAnualLiquido;
	}

	public double getNovoAnualLiquido() {
		return novoAnualLiquido;
	}

	public void setNovoAnualLiquido(double novoAnualLiquido) {
		this.novoAnualLiquido = novoAnualLiquido;
	}

	public double getAnteriorParticipacaoLucrosOuBonus() {
		return anteriorParticipacaoLucrosOuBonus;
	}

	public void setAnteriorParticipacaoLucrosOuBonus(double anteriorParticipacaoLucrosOuBonus) {
		this.anteriorParticipacaoLucrosOuBonus = anteriorParticipacaoLucrosOuBonus;
	}

	public double getNovaParticipacaoLucrosOuBonus() {
		return novaParticipacaoLucrosOuBonus;
	}

	public void setNovaParticipacaoLucrosOuBonus(double novaParticipacaoLucrosOuBonus) {
		this.novaParticipacaoLucrosOuBonus = novaParticipacaoLucrosOuBonus;
	}

	public double getAnteriorTotalAnualLiquidoComBeneficios() {
		return anteriorTotalAnualLiquidoComBeneficios;
	}

	public void setAnteriorTotalAnualLiquidoComBeneficios(double anteriorTotalAnualLiquidoComBeneficios) {
		this.anteriorTotalAnualLiquidoComBeneficios = anteriorTotalAnualLiquidoComBeneficios;
	}

	public double getNovoTotalAnualLiquidoComBeneficios() {
		return novoTotalAnualLiquidoComBeneficios;
	}

	public void setNovoTotalAnualLiquidoComBeneficios(double novoTotalAnualLiquidoComBeneficios) {
		this.novoTotalAnualLiquidoComBeneficios = novoTotalAnualLiquidoComBeneficios;
	}

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}

	public List<ComparativoPropostaBean> getComparativoProposta() {
		return comparativoProposta;
	}

	public void setComparativoProposta(List<ComparativoPropostaBean> comparativoProposta) {
		this.comparativoProposta = comparativoProposta;
	}

}

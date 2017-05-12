package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name = "tbProposta")
@NamedQueries({

})

public class PropostaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProposta", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@Column(name = "dsNvEmpresa")
	private String novaEmpresa;

	@Column(name = "dsAntEmpresa")
	private String anteriorEmpresa;

	@Column(name = "dsNvCargo")
	private String novoCargo;

	@Column(name = "dsAntCargo")
	private String anteriorCargo;

	@Column(name = "vlrAntSalarioFixoBruto")
	private Double anteriorSalarioFixoBruto;

	@Column(name = "vlrNvSalarioFixoBruto")
	private Double novoSalarioFixoBruto;

	@Column(name = "vlrAntSalarioLiquidoMensal")
	private Double anteriorSalarioLiquidoMensal;

	@Column(name = "vlrNvSalarioLiquidoMensal")
	private Double novoSalarioLiquidoMensal;

	@Column(name = "vlrAntVrMensal")
	private Double anteriorVrMensal;

	@Column(name = "vlrNvVrMensal")
	private Double novoVrMensal;

	@Column(name = "vlrAntVaMensal")
	private Double anteriorVaMensal;

	@Column(name = "vlrNvVaMensal")
	private Double novoVaMensal;

	@Column(name = "vlrAntSeguroSaudeMensal")
	private Double anteriorSeguroSaudeMensal;

	@Column(name = "vlrNvSeguroSaudeMensal")
	private Double novoSeguroSaudeMensal;

	@Column(name = "vlrAntValeAuto")
	private Double anteriorValeAuto;

	@Column(name = "vlrNvValeAuto")
	private Double novoValeAuto;

	@Column(name = "vlrAntEstacionamento")
	private Double anteriorEstacionamento;

	@Column(name = "vlrNvEstacionamento")
	private Double novoEstacionamento;

	@Column(name = "vlrAntValeTransporte")
	private Double anteriorValeTransporte;

	@Column(name = "vlrNvValeTransporte")
	private Double novoValeTransporte;

	@Column(name = "vlrAntLiquidoComBeneficios")
	private Double anteriorLiquidoComBeneficios;

	@Column(name = "vlrNvLiquidoComBeneficios")
	private Double novoLiquidoComBeneficios;

	@Column(name = "vlrAntAnualLiquido")
	private Double anteriorAnualLiquido;

	@Column(name = "vlrNvAnualLiquido")
	private Double novoAnualLiquido;

	@Column(name = "vlrAntParticipacaoLucrosOuBonus")
	private Double anteriorParticipacaoLucrosOuBonus;

	@Column(name = "vlrNvParticipacaoLucrosOuBonus")
	private Double novaParticipacaoLucrosOuBonus;

	@Column(name = "vlrAntTotalAnualLiquidoComBeneficios")
	private Double anteriorTotalAnualLiquidoComBeneficios;

	@Column(name = "vlrNvTotalAnualNvLiquidoComBeneficios")
	private Double novoTotalAnualLiquidoComBeneficios;

	@Column(name = "flSituacao")
	private Double flSituacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
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

	public void setAnteriorEmpresa(String anterioEmpresa) {
		this.anteriorEmpresa = anterioEmpresa;
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

	public Double getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Double flSituacao) {
		this.flSituacao = flSituacao;
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

}
package br.com.prosperity.entity;

import java.math.BigDecimal;

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
	private BigDecimal anteriorSalarioFixoBruto;
	
	@Column(name = "vlrNvSalarioFixoBruto")
	private BigDecimal novoSalarioFixoBruto; 
	
	@Column(name = "vlrAntSalarioLiquidoMensal")
	private BigDecimal anteriorSalarioLiquidoMensal;
	
	@Column(name = "vlrNvSalarioLiquidoMensal")
	private BigDecimal novoSalarioLiquidoMensal;
	
	@Column(name = "vlrAntVrMensal")
	private BigDecimal anteriorVrMensal;
	
	@Column(name = "vlrNvVrMensal")
	private BigDecimal novoVrMensal;
	
	@Column(name = "vlrAntSeguroSaudeMensal")
	private BigDecimal anteriorSeguroSaudeMensal;
	
	@Column(name = "vlrNvSeguroSaudeMensal")
	private BigDecimal novoSeguroSaudeMensal;
	
	@Column(name = "vlrAntValeAuto")
	private BigDecimal anteriorValeAuto;
	
	@Column(name = "vlrNvValeAuto")
	private BigDecimal novoValeAuto;
	
	@Column(name = "vlrAntEstacionamento")
	private BigDecimal anteriorEstacionamento;
	
	@Column(name = "vlrNvEstacionamento")
	private BigDecimal novoEstacionamento;
	
	@Column(name = "vlrAntValeTransporte")
	private BigDecimal anteriorValeTransporte;
	
	@Column(name = "vlrNvValeTransporte")
	private BigDecimal novoValeTransporte;
	
	@Column(name = "vlrAntLiquidoComBeneficios")
	private BigDecimal anteriorLiquidoComBeneficios;
	
	@Column(name = "vlrNvLiquidoComBeneficios")
	private BigDecimal novoLiquidoComBeneficios;
	
	@Column(name = "vlrAntAnualLiquido")
	private BigDecimal anteriorAnualLiquido;
	
	@Column(name = "vlrNvAnualLiquido")
	private BigDecimal novoAnualLiquido;
	
	@Column(name = "vlrAntParticipacaoLucrosOuBonus")
	private BigDecimal anteriorParticipacaoLucrosOuBonus;
	
	@Column(name = "vlrNvParticipacaoLucrosOuBonus")
	private BigDecimal novaParticipacaoLucrosOuBonus;
	
	@Column(name = "vlrAntTotalAnualLiquidoComBeneficios")
	private BigDecimal anteriorTotalAnualLiquidoComBeneficios;
	
	@Column(name = "vlrNvTotalAnualNvLiquidoComBeneficios")
	private BigDecimal novoTotalAnualLiquidoComBeneficios;

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

	public void setNovaParticipacaoLucrosOuBonus(BigDecimal novoParticipacaoLucrosOuBonus) {
		this.novaParticipacaoLucrosOuBonus = novoParticipacaoLucrosOuBonus;
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
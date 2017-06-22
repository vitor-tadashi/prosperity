package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbProposta")
@NamedQuery(name = "buscarProposta", query = "SELECT u FROM PropostaEntity u WHERE u.candidato = ?1")
public class PropostaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProposta", unique = true, nullable = false)
	private Integer id;

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

	@Column(name = "antDsOutros1")
	private String antDsOutros1;

	@Column(name = "antDsOutros2")
	private String antDsOutros2;

	@Column(name = "antDsOutros3")
	private String antDsOutros3;

	@Column(name = "nvDsOutros1")
	private String nvDsOutros1;

	@Column(name = "nvDsOutros2")
	private String nvDsOutros2;

	@Column(name = "nvDsOutros3")
	private String nvDsOutros3;

	@Column(name = "antVlrOutros1")
	private Double antVlrOutros1;

	@Column(name = "antVlrOutros2")
	private Double antVlrOutros2;

	@Column(name = "antVlrOutros3")
	private Double antVlrOutros3;

	@Column(name = "nvVlrOutros1")
	private Double nvVlrOutros1;

	@Column(name = "nvVlrOutros2")
	private Double nvVlrOutros2;

	@Column(name = "nvVlrOutros3")
	private Double nvVlrOutros3;

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

	@Column(name = "cmProposta")
	private String cmProposta;

	@Column(name = "flSituacao")
	private Boolean flSituacao;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "idProposta")
	private List<ComparativoPropostaEntity> comparativoProposta;

	@Column(name = "idCandidato")
	Integer candidato;

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

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
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

	public List<ComparativoPropostaEntity> getComparativoProposta() {
		return comparativoProposta;
	}

	public void setComparativoProposta(List<ComparativoPropostaEntity> comparativoProposta) {
		this.comparativoProposta = comparativoProposta;
	}

	public Integer getCandidato() {
		return candidato;
	}

	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}

	public String getCmProposta() {
		return cmProposta;
	}

	public void setCmProposta(String cmProposta) {
		this.cmProposta = cmProposta;
	}

	public String getAntDsOutros1() {
		return antDsOutros1;
	}

	public void setAntDsOutros1(String antDsOutros1) {
		this.antDsOutros1 = antDsOutros1;
	}

	public String getAntDsOutros2() {
		return antDsOutros2;
	}

	public void setAntDsOutros2(String antDsOutros2) {
		this.antDsOutros2 = antDsOutros2;
	}

	public String getAntDsOutros3() {
		return antDsOutros3;
	}

	public void setAntDsOutros3(String antDsOutros3) {
		this.antDsOutros3 = antDsOutros3;
	}

	public String getNvDsOutros1() {
		return nvDsOutros1;
	}

	public void setNvDsOutros1(String nvDsOutros1) {
		this.nvDsOutros1 = nvDsOutros1;
	}

	public String getNvDsOutros2() {
		return nvDsOutros2;
	}

	public void setNvDsOutros2(String nvDsOutros2) {
		this.nvDsOutros2 = nvDsOutros2;
	}

	public String getNvDsOutros3() {
		return nvDsOutros3;
	}

	public void setNvDsOutros3(String nvDsOutros3) {
		this.nvDsOutros3 = nvDsOutros3;
	}

	public Double getAntVlrOutros1() {
		return antVlrOutros1;
	}

	public void setAntVlrOutros1(Double antVlrOutros1) {
		this.antVlrOutros1 = antVlrOutros1;
	}

	public Double getAntVlrOutros2() {
		return antVlrOutros2;
	}

	public void setAntVlrOutros2(Double antVlrOutros2) {
		this.antVlrOutros2 = antVlrOutros2;
	}

	public Double getAntVlrOutros3() {
		return antVlrOutros3;
	}

	public void setAntVlrOutros3(Double antVlrOutros3) {
		this.antVlrOutros3 = antVlrOutros3;
	}

	public Double getNvVlrOutros1() {
		return nvVlrOutros1;
	}

	public void setNvVlrOutros1(Double nvVlrOutros1) {
		this.nvVlrOutros1 = nvVlrOutros1;
	}

	public Double getNvVlrOutros2() {
		return nvVlrOutros2;
	}

	public void setNvVlrOutros2(Double nvVlrOutros2) {
		this.nvVlrOutros2 = nvVlrOutros2;
	}

	public Double getNvVlrOutros3() {
		return nvVlrOutros3;
	}

	public void setNvVlrOutros3(Double nvVlrOutros3) {
		this.nvVlrOutros3 = nvVlrOutros3;
	}

}
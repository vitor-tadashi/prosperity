package br.com.prosperity.bean;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VagaBean {

	private Integer id;
	private String nomeVaga;
	private String nomeSolicitante;
	private Double valorPretensao;
	private Date dataInicio;
	private Character localTrabalho;
	private Character idTipoVaga;
	private Date horarioEntrada;
	private Date horarioSaida;
	private Character aumentaQuadro;
	private ProjetoBean projetoBean;
	private CargoBean cargoBean;
	private SenioridadeBean senioridadeBean;

	private String nomeSubstituido; //
	private String descricaoFormacaoAcademica; //
	private String descricaoPerfilComportamental; //
	private String descricaoPerfilTecnico; //
	private Date dataAbertura; //
	private Date dataAprovacao; //
	private Date dataFechamento; //
	private Integer numeroCandidatos; //
	private UsuarioBean usuarioBean;
	private List<StatusBean> statusBean;
	
	
	
	

	public List<StatusBean> getStatusBean() {
		return statusBean;
	}

	public void setStatusBean(List<StatusBean> statusBean) {
		this.statusBean = statusBean;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public Double getValorPretensao() {
		return valorPretensao;
	}

	public void setValorPretensao(Double valorPretensao) {
		this.valorPretensao = valorPretensao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public char getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(char localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public char getIdTipoVaga() {
		return idTipoVaga;
	}

	public void setIdTipoVaga(char idTipoVaga) {
		this.idTipoVaga = idTipoVaga;
	}

	public Date getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(Date horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Date getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(Date horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public char getAumentaQuadro() {
		return aumentaQuadro;
	}

	public void setAumentaQuadro(char aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}

	public ProjetoBean getProjetoBean() {
		return projetoBean;
	}

	public void setProjetoBean(ProjetoBean projetoBean) {
		this.projetoBean = projetoBean;
	}

	public CargoBean getCargoBean() {
		return cargoBean;
	}

	public void setCargoBean(CargoBean cargoBean) {
		this.cargoBean = cargoBean;
	}

	public SenioridadeBean getSenioridadeBean() {
		return senioridadeBean;
	}

	public void setSenioridadeBean(SenioridadeBean senioridadeBean) {
		this.senioridadeBean = senioridadeBean;
	}

	public String getNomeSubstituido() {
		return nomeSubstituido;
	}

	public void setNomeSubstituido(String nomeSubstituido) {
		this.nomeSubstituido = nomeSubstituido;
	}

	public String getDescricaoFormacaoAcademica() {
		return descricaoFormacaoAcademica;
	}

	public void setDescricaoFormacaoAcademica(String descricaoFormacaoAcademica) {
		this.descricaoFormacaoAcademica = descricaoFormacaoAcademica;
	}

	public String getDescricaoPerfilComportamental() {
		return descricaoPerfilComportamental;
	}

	public void setDescricaoPerfilComportamental(String descricaoPerfilComportamental) {
		this.descricaoPerfilComportamental = descricaoPerfilComportamental;
	}

	public String getDescricaoPerfilTecnico() {
		return descricaoPerfilTecnico;
	}

	public void setDescricaoPerfilTecnico(String descricaoPerfilTecnico) {
		this.descricaoPerfilTecnico = descricaoPerfilTecnico;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getNumeroCandidatos() {
		return numeroCandidatos;
	}

	public void setNumeroCandidatos(Integer numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
	
}

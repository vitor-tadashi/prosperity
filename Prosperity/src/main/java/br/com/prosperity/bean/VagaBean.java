package br.com.prosperity.bean;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class VagaBean {

	private Integer id;
	private String nomeVaga;
	
	@NotNull
	@NotEmpty(message ="O campo Solicitante deve ser preenchido")
	private String nomeSolicitante;
	
	private Double valorPretensao;
	
	private Date dataInicio;
	
	private Character localTrabalho;
	private Character idTipoVaga;
	private String horarioEntrada;
	private String horarioSaida;
	private Character aumentaQuadro;
	
	private ProjetoBean projeto;
	
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
	private List<StatusVagaBean> statusVagaBean = new ArrayList<>();

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataAberturaDe;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataAberturaPara;

	public Date getDataAberturaDe() {
		return dataAberturaDe;
	}

	public void setDataAberturaDe(Date dataAberturaDe) {
		this.dataAberturaDe = dataAberturaDe;
	}

	public Date getDataAberturaPara() {
		return dataAberturaPara;
	}

	public void setDataAberturaPara(Date dataAberturaPara) {
		this.dataAberturaPara = dataAberturaPara;
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

	public String getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public char getAumentaQuadro() {
		return aumentaQuadro;
	}

	public void setAumentaQuadro(char aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}

	public ProjetoBean getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoBean projetoBean) {
		this.projeto = projetoBean;
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

	public List<StatusVagaBean> getStatusVagaBean() {
		return statusVagaBean;
	}

	public void setStatusVagaBean(List<StatusVagaBean> statusVagaBean) {
		this.statusVagaBean = statusVagaBean;
	}

	public void setLocalTrabalho(Character localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public void setIdTipoVaga(Character idTipoVaga) {
		this.idTipoVaga = idTipoVaga;
	}

	public void setAumentaQuadro(Character aumentaQuadro) {
		this.aumentaQuadro = aumentaQuadro;
	}

}

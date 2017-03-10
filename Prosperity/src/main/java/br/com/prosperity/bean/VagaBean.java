package br.com.prosperity.bean;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import br.com.prosperity.entity.UsuarioEntity;

@Component
public class VagaBean {
	private Integer id; // 
	private String nomeSolicitante;
	private int numeroCandidatos; //
	private double valorPretensao;
	private Calendar dataInicio;
	private char localTrabalho;
	private String idTipoVaga;
	private Calendar horarioEntrada;
	private Calendar horarioSaida;
	private String aumentaQuadro;
	private ProjetoBean projetoBean;
	private CargoBean cargoBean;
	private SenioridadeBean senioridadeBean; 
	private String nomeSubstituido; // 
	private String descricaoFormacaoAcademica; //
	private String descricaoPerfilComportamental; //
	private String descricaoPerfilTecnico; //
	private Calendar dataAbertura; //
	private Calendar dataAprovacao; //
	private Calendar dataFechamento; //
	private UsuarioBean usuarioBean;

	public VagaBean() {

	}
	

	public VagaBean(Integer id, String nomeSolicitante, int numeroCandidatos, Double valorPretensao,
			Calendar dataInicio, char localTrabalho, String idTipoVaga, Calendar horarioEntrada, Calendar horarioSaida,
			String aumentaQuadro, ProjetoBean projetoBean, CargoBean cargoBean, SenioridadeBean senioridadeBean,
			String nomeSubstituido, String descricaoFormacaoAcademica, String descricaoPerfilComportamental,
			String descricaoPerfilTecnico, Calendar dataAbertura, Calendar dataAprovacao, Calendar dataFechamento,
			UsuarioBean usuarioBean) {
		this.id = id;
		this.nomeSolicitante = nomeSolicitante;
		this.numeroCandidatos = numeroCandidatos;
		this.valorPretensao = valorPretensao;
		this.dataInicio = dataInicio;
		this.localTrabalho = localTrabalho;
		this.idTipoVaga = idTipoVaga;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.aumentaQuadro = aumentaQuadro;
		this.projetoBean = projetoBean;
		this.cargoBean = cargoBean;
		this.senioridadeBean = senioridadeBean;
		this.nomeSubstituido = nomeSubstituido;
		this.descricaoFormacaoAcademica = descricaoFormacaoAcademica;
		this.descricaoPerfilComportamental = descricaoPerfilComportamental;
		this.descricaoPerfilTecnico = descricaoPerfilTecnico;
		this.dataAbertura = dataAbertura;
		this.dataAprovacao = dataAprovacao;
		this.dataFechamento = dataFechamento;
		this.usuarioBean = usuarioBean;
	}




	


	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}


	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}


	public Calendar getDataAbertura() {
		return dataAbertura;
	}



	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



	public Calendar getDataAprovacao() {
		return dataAprovacao;
	}



	public void setDataAprovacao(Calendar dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}



	public Calendar getDataFechamento() {
		return dataFechamento;
	}



	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
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


	public int getNumeroCandidatos() {
		return numeroCandidatos;
	}

	public void setNumeroCandidatos(int numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}

	public String getNomeSubstituido() {
		return nomeSubstituido;
	}

	public void setNomeSubstituido(String nomeSubstituido) {
		this.nomeSubstituido = nomeSubstituido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public char getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(char localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getIdTipoVaga() {
		return idTipoVaga;
	}

	public void setIdTipoVaga(String tipoVaga) {
		this.idTipoVaga = tipoVaga;
	}

	public Calendar getHorarioEntrada() {
		return horarioEntrada;
	}


	public void setHorarioEntrada(Calendar horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}


	public Calendar getHorarioSaida() {
		return horarioSaida;
	}


	public void setHorarioSaida(Calendar horarioSaida) {
		this.horarioSaida = horarioSaida;
	}


	public void setValorPretensao(double valorPretensao) {
		this.valorPretensao = valorPretensao;
	}


	public String getAumentaQuadro() {
		return aumentaQuadro;
	}

	public void setAumentaQuadro(String aumentaQuadro) {
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
}

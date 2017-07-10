package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaConverter implements Converter<VagaEntity, VagaBean> {

	@Autowired
	private SenioridadeConverter senioridadeConverter;

	@Autowired
	private StatusVagaConverter statusVagaConverter;

	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	private VagaCandidatoConverter vagaCandidatoConverter;

	@Override
	public VagaEntity convertBeanToEntity(VagaBean bean) {
		if (bean == null) {
			return null;
		}
		
		VagaEntity entity = new VagaEntity();

		entity.setId(bean.getId());
		entity.setNomeVaga(bean.getNomeVaga());
		entity.setAumentoQuadro(bean.getAumentaQuadro());
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAprovacao(bean.getDataAprovacao());
		entity.setDataFechamento(bean.getDataFechamento());
		entity.setDataInicio(bean.getDataInicio());
		entity.setDescricaoFormacaoAcademica(bean.getDescricaoFormacaoAcademica());
		entity.setDescricaoPerfilComportamental(bean.getDescricaoPerfilComportamental());
		entity.setDescricaoPerfilTecnico(bean.getDescricaoPerfilTecnico());
		entity.setHoraEntrada(bean.getHorarioEntrada());
		entity.setHoraSaida(bean.getHorarioSaida());
		entity.setLocalTrabalho(bean.getLocalTrabalho());
		entity.setNomeSolicitante(bean.getNomeSolicitante());
		entity.setNomeSubstituido(bean.getNomeSubstituido());
		entity.setSenioridadeEntity(senioridadeConverter.convertBeanToEntity(bean.getSenioridadeBean()));
		entity.setTipoVaga(bean.getIdTipoVaga());
		entity.setUsuarioEntity(usuarioConverter.convertBeanToEntity(bean.getUsuarioBean()));
		entity.setStatusVagaEntity(statusVagaConverter.convertBeanToEntity(bean.getStatus()));
		entity.setNmResponsavel(bean.getNmResponsavel());
		entity.setNmAreaResponsavel(bean.getNmAreaResponsavel());
		entity.setEmailResponsavel(bean.getEmailResponsavel());
		entity.setTelResponsavel(bean.getTelResponsavel());
		entity.setMarketingSocial(bean.getMarketingSocial());
		entity.setNmCargo(bean.getNmCargo());
		entity.setNmCliente(bean.getNmCliente());
		entity.setNmProjeto(bean.getNmProjeto());

		return entity;
	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		if (entity == null) {
			return null;
		}
		
		VagaBean bean = new VagaBean();

		bean.setId(entity.getId());
		bean.setNomeVaga(entity.getNomeVaga());
		bean.setAumentaQuadro(entity.getAumentoQuadro());
		bean.setDataAbertura(entity.getDataAbertura());
		bean.setDataAprovacao(entity.getDataAprovacao());
		bean.setDataFechamento(entity.getDataFechamento());
		bean.setDataInicio(entity.getDataInicio());
		bean.setDescricaoFormacaoAcademica(entity.getDescricaoFormacaoAcademica());
		bean.setDescricaoPerfilComportamental(entity.getDescricaoPerfilComportamental());
		bean.setDescricaoPerfilTecnico(entity.getDescricaoPerfilTecnico());
		bean.setHorarioEntrada(entity.getHoraEntrada());
		bean.setHorarioSaida(entity.getHoraSaida());
		bean.setLocalTrabalho(entity.getLocalTrabalho());
		bean.setNomeSolicitante(entity.getNomeSolicitante());
		bean.setNomeSubstituido(entity.getNomeSubstituido());
		bean.setSenioridadeBean(senioridadeConverter.convertEntityToBean(entity.getSenioridadeEntity()));
		bean.setIdTipoVaga(entity.getTipoVaga());
		bean.setUsuarioBean(usuarioConverter.convertEntityToBean(entity.getUsuarioEntity()));
		bean.setStatus(statusVagaConverter.convertEntityToBean(entity.getStatusVagaEntity()));
		bean.setNmResponsavel(entity.getNmResponsavel());
		bean.setNmAreaResponsavel(entity.getNmAreaResponsavel());
		bean.setEmailResponsavel(entity.getEmailResponsavel());
		bean.setTelResponsavel(entity.getTelResponsavel());
		bean.setVagaCandidatoBean(vagaCandidatoConverter.convertEntityToBean(entity.getVagaCandidatoEntity()));
		bean.setMarketingSocial(entity.getMarketingSocial());
		bean.setNmCargo(entity.getNmCargo());
		bean.setNmCliente(entity.getNmCliente());
		bean.setNmProjeto(entity.getNmProjeto());

		return bean;
	}
}
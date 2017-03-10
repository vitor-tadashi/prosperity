package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaConverter implements Converter<VagaEntity, VagaBean> {

	@Autowired
	private SenioridadeConverter senioridadeConverter;
	
	@Autowired
	private CargoConverter cargoConverter;
	
	@Autowired
	private ProjetoConverter projetoConverter;
	
	@Autowired
	private VagaConverter vagaConverter;
	
	@Override
	public VagaEntity convertBeanToEntity(VagaBean bean) {
		VagaEntity entity = new VagaEntity();
		entity.setId(bean.getId());
		entity.setAumentoQuadro(bean.getAumentaQuadro());
		entity.setCargoEntity(cargoConverter.convertBeanToEntity(bean.getCargoBean()));
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAprovacao(bean.getDataAprovacao());
		entity.setDataFechamento(bean.getDataFechamento());
		entity.setDataInicio(bean.getDataFechamento());
		entity.setDescricaoFormacaoAcademica(bean.getDescricaoFormacaoAcademica());
		entity.setDescricaoPerfilComportamental(bean.getDescricaoPerfilComportamental());
		entity.setDescricaoPerfilTecnico(bean.getDescricaoPerfilTecnico());
		entity.setHoraEntrada(bean.getHorarioEntrada());
		entity.setHoraSaida(bean.getHorarioSaida());
		entity.setLocalTrabalho(bean.getLocalTrabalho());
		entity.setNomeSolicitante(bean.getNomeSolicitante());
		entity.setNomeSubstituido(bean.getNomeSubstituido());
		entity.setNumeroCandidatos(bean.getNumeroCandidatos());
		entity.setProjetoEntity(projetoConverter.convertBeanToEntity(bean.getProjetoBean()));
		entity.setSenioridadeEntity(senioridadeConverter.convertBeanToEntity(bean.getSenioridadeBean()));
		entity.setTipoVaga(bean.getIdTipoVaga());
		entity.setValorPretensao(bean.getValorPretensao());
		return entity;
	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		VagaBean bean = new VagaBean();
		bean.setId(entity.getId());
		bean.setAumentaQuadro(entity.getAumentoQuadro());
		bean.setCargoBean(cargoConverter.convertEntityToBean(entity.getCargoEntity()));
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
		
		return bean;
	}
	
	/*public List<VagaBean> convertEntityToBean(List<VagaEntity> entities) {
		List<VagaBean> beans = new ArrayList<VagaBean>();
		
		for(VagaEntity entity : entities){
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}*/
}

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
	
		return entity;
	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		VagaBean bean = new VagaBean();
		bean.setId(entity.getId());
		bean.setDescricaoFormacaoAcademica(entity.getDescricaoFormacaoAcademica());
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

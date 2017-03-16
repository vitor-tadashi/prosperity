package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.prosperity.bean.VagaCandidatoBean;
import br.com.prosperity.entity.VagaCandidatoEntity;

@Component
public class VagaCandiatoConverter implements Converter<VagaCandidatoEntity, VagaCandidatoBean>{
@Autowired
private CandidatoConverter candidatoConverter;
@Autowired
private VagaConverter vagaConverter;
@Autowired
private CanalInformacaoConverter canalInformacaoConverter;

	@Override
	public VagaCandidatoEntity convertBeanToEntity(VagaCandidatoBean bean) {
		VagaCandidatoEntity entity = new VagaCandidatoEntity();
		entity.setIdVagaCandidato(bean.getId());
		entity.setCanalInformacao(canalInformacaoConverter.convertBeanToEntity(bean.getCanalInformacao()));
		entity.setCandidato(candidatoConverter.convertBeanToEntity(bean.getCandidatoBean()));
		entity.setVaga(vagaConverter.convertBeanToEntity(bean.getVaga()));
	
		return entity;
	}

	@Override
	public VagaCandidatoBean convertEntityToBean(VagaCandidatoEntity entity) {
		VagaCandidatoBean bean = new VagaCandidatoBean();
		bean.setId(entity.getIdVagaCandidato());
		bean.setCanalInformacao(canalInformacaoConverter.convertEntityToBean(entity.getCanalInformacao()));
		bean.setCandidatoBean(candidatoConverter.convertEntityToBean(entity.getCandidato()));
		bean.setVaga(vagaConverter.convertEntityToBean(entity.getVaga()));
		
		return bean;
	}

}

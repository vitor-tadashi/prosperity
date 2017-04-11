package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.entity.ProvaCandidatoEntity;

@Component
public class ProvaCandidatoConverter implements Converter<ProvaCandidatoEntity, ProvaCandidatoBean> {

	@Autowired
	private CandidatoConverter candidatoConverter;

	@Override
	public ProvaCandidatoEntity convertBeanToEntity(ProvaCandidatoBean bean) {
		if (bean == null) {
			return null;
		}
		
		ProvaCandidatoEntity entity = new 	ProvaCandidatoEntity();
		
		entity.setId(bean.getId());
		entity.setNome1(bean.getNome1());
		entity.setDescricao1(bean.getDescricao1());
		entity.setNome2(bean.getNome2());
		entity.setDescricao2(bean.getDescricao2());
		entity.setNome3(bean.getNome3());
		entity.setDescricao3(bean.getDescricao3());
		entity.setParecer(bean.getParecerTecnico());
		entity.setCandidato(candidatoConverter.convertBeanToEntity(bean.getCandidato()));

		return entity;
	}

	@Override
	public ProvaCandidatoBean convertEntityToBean(ProvaCandidatoEntity entity) {
		if (entity == null) {
			return null;
		}
		
		ProvaCandidatoBean bean = new ProvaCandidatoBean();
		
		bean.setId(entity.getId());
		bean.setNome1(entity.getNome1());
		bean.setDescricao1(entity.getDescricao1());
		bean.setNome2(entity.getNome2());
		bean.setDescricao2(entity.getDescricao2());
		bean.setNome3(entity.getNome3());
		bean.setDescricao3(entity.getDescricao3());
		bean.setParecerTecnico(entity.getParecer());
		bean.setCandidato(candidatoConverter.convertEntityToBean(entity.getCandidato()));

		return bean;
	}
}
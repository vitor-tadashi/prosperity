package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.entity.ProvaCandidatoEntity;

@Component
public class ProvaCandidatoConverter implements Converter<ProvaCandidatoEntity, ProvaCandidatoBean> {

	@Autowired
	private CandidatoConverter candidatoConverter;

	@Autowired
	private DescricaoProvaConverter descricaoProvasConverter;
	
	@Autowired
	private ProvaConverter provasConverter;

	@Override
	public ProvaCandidatoEntity convertBeanToEntity(ProvaCandidatoBean bean) {
		if (bean == null) {
			return null;
		}

		ProvaCandidatoEntity entity = new ProvaCandidatoEntity();

		entity.setId(bean.getId());
		entity.setParecer(bean.getParecerTecnico());
		entity.setDescricaoProvas(descricaoProvasConverter.convertBeanToEntity(bean.getDescricao()));
		entity.setProvas(provasConverter.convertBeanToEntity(bean.getProvas()));
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
		bean.setParecerTecnico(entity.getParecer());
		bean.setDescricao(descricaoProvasConverter.convertEntityToBean(entity.getDescricaoProvas()));
		bean.setProvas(provasConverter.convertEntityToBean(entity.getProvas()));
		bean.setCandidato(candidatoConverter.convertEntityToBean(entity.getCandidato()));

		return bean;
	}
}
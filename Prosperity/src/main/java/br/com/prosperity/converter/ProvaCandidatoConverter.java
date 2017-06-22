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
	private ProvaConverter provasConverter;

	@Override
	public ProvaCandidatoEntity convertBeanToEntity(ProvaCandidatoBean bean) {
		if (bean == null) {
			return null;
		}

		ProvaCandidatoEntity entity = new ProvaCandidatoEntity();

		entity.setId(bean.getId());
		entity.setDescricaoProva(bean.getDescricao());
		entity.setProvas(provasConverter.convertBeanToEntity(bean.getProvas()));
		entity.setCandidato(candidatoConverter.convertBeanToEntity(bean.getCandidato()));
		entity.setCaminhoProva(bean.getCaminhoProva());
		entity.setIdVaga(bean.getIdVaga());

		return entity;
	}

	@Override
	public ProvaCandidatoBean convertEntityToBean(ProvaCandidatoEntity entity) {
		if (entity == null) {
			return null;
		}

		ProvaCandidatoBean bean = new ProvaCandidatoBean();

		bean.setId(entity.getId());
		bean.setDescricao(entity.getDescricaoProva());
		bean.setProvas(provasConverter.convertEntityToBean(entity.getProvas()));
		bean.setCandidato(candidatoConverter.convertEntityToBean(entity.getCandidato()));
		bean.setCaminhoProva(entity.getCaminhoProva());
		bean.setIdVaga(entity.getIdVaga());

		return bean;
	}
}
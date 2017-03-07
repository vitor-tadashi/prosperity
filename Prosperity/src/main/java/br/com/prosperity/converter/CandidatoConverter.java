package br.com.prosperity.converter;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.entity.CandidatoEntity;


public class CandidatoConverter implements Converter<CandidatoEntity, CandidatoBean> {

	@Override
	public CandidatoEntity convertBeanToEntity(CandidatoBean bean) {
		CandidatoEntity entity = new CandidatoEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public CandidatoBean convertEntityToBean(CandidatoEntity entity) {
		CandidatoBean bean = new CandidatoBean();
		bean.setId(entity.getId());
		return bean;
	}
}
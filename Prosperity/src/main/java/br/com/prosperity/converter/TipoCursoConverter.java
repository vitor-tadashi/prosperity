package br.com.prosperity.converter;

import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.entity.TipoCursoEntity;

public class TipoCursoConverter implements Converter<TipoCursoEntity, TipoCursoBean> {

	@Override
	public TipoCursoEntity convertBeanToEntity(TipoCursoBean bean) {
		TipoCursoEntity entity = new TipoCursoEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public TipoCursoBean convertEntityToBean(TipoCursoEntity entity) {
		TipoCursoBean bean = new TipoCursoBean();
		bean.setId(entity.getId());
		return bean;
	}

}

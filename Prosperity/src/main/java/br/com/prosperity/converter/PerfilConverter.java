package br.com.prosperity.converter;

import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.entity.PerfilEntity;

public class PerfilConverter implements Converter<PerfilEntity, PerfilBean> {

	@Override
	public PerfilEntity convertBeanToEntity(PerfilBean bean) {
		PerfilEntity entity = new PerfilEntity();

		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public PerfilBean convertEntityToBean(PerfilEntity entity) {
		PerfilBean bean = new PerfilBean();

		bean.setId(entity.getId());

		return bean;
	}

}

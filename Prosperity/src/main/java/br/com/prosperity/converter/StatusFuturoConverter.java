package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusFuturoBean;
import br.com.prosperity.entity.StatusFuturoEntity;

@Component
public class StatusFuturoConverter implements Converter<StatusFuturoEntity, StatusFuturoBean> {

	@Override
	public StatusFuturoEntity convertBeanToEntity(StatusFuturoBean bean) {
		if (bean == null)
			return null;
		StatusFuturoEntity entity = new StatusFuturoEntity();

		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public StatusFuturoBean convertEntityToBean(StatusFuturoEntity entity) {
		if (entity == null)
			return null;
		StatusFuturoBean bean = new StatusFuturoBean();

		bean.setId(entity.getId());

		return bean;
	}
}

package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliadorBean;
import br.com.prosperity.entity.AvaliadorEntity;

@Component
public class AvaliadorConverter implements Converter<AvaliadorEntity, AvaliadorBean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.
	 * prosperity.bean.AvaliadorBean)
	 */
	@Override
	public AvaliadorEntity convertBeanToEntity(AvaliadorBean bean) {
		if (bean == null) {
			return null;
		}
		AvaliadorEntity entity = new AvaliadorEntity();

		entity.setId(bean.getIdAvaliador());

		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.prosperity.converter.Converter#convertBeanToEntity(br.com.
	 * prosperity.entity.AvaliadorEntity)
	 */
	@Override
	public AvaliadorBean convertEntityToBean(AvaliadorEntity entity) {
		if (entity == null) {
			return null;
		}
		AvaliadorBean bean = new AvaliadorBean();

		bean.setIdAvaliador(entity.getId());

		return bean;
	}
}

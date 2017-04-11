package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProvaBean;
import br.com.prosperity.entity.ProvaEntity;

@Component
public class ProvaConverter implements Converter<ProvaEntity, ProvaBean> {

	@Override
	public ProvaEntity convertBeanToEntity(ProvaBean bean) {
		if (bean == null) {
			return null;
		}

		ProvaEntity entity = new ProvaEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public ProvaBean convertEntityToBean(ProvaEntity entity) {
		if (entity == null) {
			return null;
		}

		ProvaBean bean = new ProvaBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		
		return bean;
	}

}

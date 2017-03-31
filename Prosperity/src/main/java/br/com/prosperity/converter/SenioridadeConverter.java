package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.entity.SenioridadeEntity;

@Component
public class SenioridadeConverter implements Converter<SenioridadeEntity, SenioridadeBean> {

	@Override
	public SenioridadeEntity convertBeanToEntity(SenioridadeBean bean) {
		if (bean == null) {
			return null;
		}
		SenioridadeEntity entity = new SenioridadeEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		return entity;
	}

	@Override
	public SenioridadeBean convertEntityToBean(SenioridadeEntity entity) {
		if (entity == null) {
			return null;
		}
		SenioridadeBean bean = new SenioridadeBean();
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		return bean;
	}
}

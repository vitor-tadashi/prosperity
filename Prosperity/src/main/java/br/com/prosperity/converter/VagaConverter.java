package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaConverter implements Converter<VagaEntity, VagaBean> {

	@Override
	public VagaEntity convertBeanToEntity(VagaBean bean) {
		VagaEntity entity = new VagaEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		VagaBean bean = new VagaBean();
		bean.setId(entity.getId());
		
		return bean;
	}
}

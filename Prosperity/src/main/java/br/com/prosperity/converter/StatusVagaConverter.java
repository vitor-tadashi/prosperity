package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusVagaBean;
import br.com.prosperity.entity.StatusVagaEntity;

@Component
public class StatusVagaConverter implements Converter<StatusVagaEntity, StatusVagaBean> {

	@Autowired
	private StatusConverter statusConverter;
	
	@Override
	public StatusVagaEntity convertBeanToEntity(StatusVagaBean bean) {
		if (bean == null) {
			return null;
		}
		StatusVagaEntity entity = new StatusVagaEntity();

		entity.setId(bean.getId());
		entity.setDataAlteracao(bean.getDataAlteracao());
		entity.setStatus(statusConverter.convertBeanToEntity(bean.getStatus()));
		//entity.setVaga(bean.getVagaBean());

		return entity;
	}

	@Override
	public StatusVagaBean convertEntityToBean(StatusVagaEntity entity) {
		if (entity == null) {
			return null;
		}
		StatusVagaBean bean = new StatusVagaBean();
		
		bean.setId(entity.getId());
		bean.setDataAlteracao(entity.getDataAlteracao());
		bean.setStatus(statusConverter.convertEntityToBean(entity.getStatus()));
		//bean.setVagaBean(entity.getVaga());
		return bean;
	}

}

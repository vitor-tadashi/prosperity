package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusDisponivelBean;
import br.com.prosperity.entity.StatusDisponivelEntity;

@Component
public class StatusDisponivelConverter implements Converter<StatusDisponivelEntity, StatusDisponivelBean> {

	@Override
	public StatusDisponivelEntity convertBeanToEntity(StatusDisponivelBean bean) {
		if (bean == null) {
			return null;
		}

		StatusDisponivelEntity entity = new StatusDisponivelEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setClasse(bean.getClasse());

		return entity;
	}

	@Override
	public StatusDisponivelBean convertEntityToBean(StatusDisponivelEntity entity) {
		if (entity == null) {
			return null;
		}

		StatusDisponivelBean bean = new StatusDisponivelBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setClasse(entity.getClasse());
		
		return bean;
	}

}

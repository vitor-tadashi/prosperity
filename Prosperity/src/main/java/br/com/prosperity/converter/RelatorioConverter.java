package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.RelatorioBean;
import br.com.prosperity.entity.RelatorioEntity;

@Component
public class RelatorioConverter implements Converter<RelatorioEntity, RelatorioBean> {

	@Override
	public RelatorioEntity convertBeanToEntity(RelatorioBean bean) {
		if (bean == null) {
			return null;
		}
		RelatorioEntity entity = new RelatorioEntity();
		
		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public RelatorioBean convertEntityToBean(RelatorioEntity entity) {
		if (entity == null) {
			return null;
		}
		RelatorioBean bean = new RelatorioBean();
		
		bean.setId(entity.getId());

		return bean;
	}
}
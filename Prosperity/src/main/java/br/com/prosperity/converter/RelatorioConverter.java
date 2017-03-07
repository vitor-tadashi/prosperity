package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.RelatorioBean;
import br.com.prosperity.entity.RelatorioEntity;

public class RelatorioConverter implements Converter<RelatorioEntity, RelatorioBean> {

	@Override
	public RelatorioEntity convertBeanToEntity(RelatorioBean bean) {
		RelatorioEntity entity = new RelatorioEntity();
		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public RelatorioBean convertEntityToBean(RelatorioEntity entity) {
		RelatorioBean bean = new RelatorioBean();
		bean.setId(entity.getId());

		return bean;
	}

	@Override
	public List<RelatorioBean> convertEntityToBean(List<RelatorioEntity> entities) {
		List<RelatorioBean> beanList = new ArrayList<>();
		for (RelatorioEntity e : entities) {
			beanList.add(convertEntityToBean(e));

		}
		return beanList;
	}

}

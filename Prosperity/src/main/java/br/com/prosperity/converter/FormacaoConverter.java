package br.com.prosperity.converter;

import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.entity.FormacaoEntity;

public class FormacaoConverter implements Converter<FormacaoEntity, FormacaoBean> {

	@Override
	public FormacaoEntity convertBeanToEntity(FormacaoBean bean) {
		FormacaoEntity entity = new FormacaoEntity();
		entity.setId(bean.getId());

		return entity;
	}

	@Override
	public FormacaoBean convertEntityToBean(FormacaoEntity entity) {
		FormacaoBean bean = new FormacaoBean();
		 bean.setId(entity.getId());

		return bean;
	}
}

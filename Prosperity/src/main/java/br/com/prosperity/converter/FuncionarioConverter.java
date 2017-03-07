package br.com.prosperity.converter;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.entity.FuncionarioEntity;

public class FuncionarioConverter implements Converter<FuncionarioEntity, FuncionarioBean>{

	@Override
	public FuncionarioEntity convertBeanToEntity(FuncionarioBean bean) {
		FuncionarioEntity entity = new FuncionarioEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public FuncionarioBean convertEntityToBean(FuncionarioEntity entity) {
		FuncionarioBean bean = new FuncionarioBean();
		bean.setId(entity.getId());
		return bean;
	}
}

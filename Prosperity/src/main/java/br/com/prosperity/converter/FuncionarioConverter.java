package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.entity.FuncionarioEntity;

@Component
public class FuncionarioConverter implements Converter<FuncionarioEntity, FuncionarioBean> {

	@Override
	public FuncionarioEntity convertBeanToEntity(FuncionarioBean bean) {
		if (bean == null) {
			return null;
		}
		FuncionarioEntity entity = new FuncionarioEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public FuncionarioBean convertEntityToBean(FuncionarioEntity entity) {
		if (entity == null) {
			return null;
		}
		FuncionarioBean bean = new FuncionarioBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;
	}
}
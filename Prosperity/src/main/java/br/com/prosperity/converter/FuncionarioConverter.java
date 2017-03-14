package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.entity.FuncionarioEntity;

@Component
public class FuncionarioConverter implements Converter<FuncionarioEntity, FuncionarioBean>{

	@Override
	public FuncionarioEntity convertBeanToEntity(FuncionarioBean bean) {
		FuncionarioEntity entity = new FuncionarioEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		return entity;
	}

	@Override
	public FuncionarioBean convertEntityToBean(FuncionarioEntity entity) {
		FuncionarioBean bean = new FuncionarioBean();
		if (entity!=null){
			bean.setId(entity.getId());
			bean.setNome(entity.getNome());
		} else {
			bean = null;
		}
		return bean;
	}
}

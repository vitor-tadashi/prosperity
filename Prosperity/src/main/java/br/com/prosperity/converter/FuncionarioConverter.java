package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<FuncionarioBean> convertEntityToBean(
			List<FuncionarioEntity> entities) {
		List<FuncionarioBean> beanList = new ArrayList<>();
		
		for (FuncionarioEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}
		
		return beanList;
	}

}

package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.entity.EnderecoEntity;
import br.com.prosperity.entity.FuncionarioEntity;

public class EnderecoConverter implements Converter<EnderecoEntity, EnderecoBean>{

	@Override
	public EnderecoEntity convertBeanToEntity(EnderecoBean bean) {
		EnderecoEntity entity = new EnderecoEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public EnderecoBean convertEntityToBean(EnderecoEntity entity) {
		EnderecoBean bean = new EnderecoBean();
		bean.setId(entity.getId());
		return bean;
	}

	@Override
	public List<EnderecoBean> convertEntityToBean(List<EnderecoEntity> entities) {
			List<EnderecoBean> beanList = new ArrayList<>();
			
			for (EnderecoEntity e : entities) {
				beanList.add(convertEntityToBean(e));
			}
			
			return beanList;
	}
}

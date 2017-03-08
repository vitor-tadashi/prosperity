package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.entity.EnderecoEntity;

@Component
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
}

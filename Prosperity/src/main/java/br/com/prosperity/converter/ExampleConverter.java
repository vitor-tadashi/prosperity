package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ExampleBean;
import br.com.prosperity.entity.ExampleEntity;

@Component
public class ExampleConverter implements Converter<ExampleEntity, ExampleBean> {

	@Override
	public ExampleEntity convertBeanToEntity(ExampleBean bean) {
		ExampleEntity entity = new ExampleEntity();
		entity.setId(bean.getId());
		entity.setCpf(bean.getCpf());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public ExampleBean convertEntityToBean(ExampleEntity entity) {
		ExampleBean bean = new ExampleBean();
		bean.setId(entity.getId());
		bean.setCpf(entity.getCpf());
		bean.setNome(entity.getNome());

		return bean;
	}	
}

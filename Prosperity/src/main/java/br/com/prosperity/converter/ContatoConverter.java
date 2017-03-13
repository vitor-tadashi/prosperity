package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.entity.ContatoEntity;


@Component
public class ContatoConverter implements Converter<ContatoEntity, ContatoBean> {

	@Autowired
	CandidatoConverter candidatoConverter;
	
	@Override
	public ContatoEntity convertBeanToEntity(ContatoBean bean) {
		ContatoEntity entity = new ContatoEntity();
		entity.setId(bean.getId());
		entity.setTelefone(bean.getTelefone());
		return entity;
	}

	@Override
	public ContatoBean convertEntityToBean(ContatoEntity entity) {
		ContatoBean bean = new ContatoBean();
		bean.setId(entity.getId());
		bean.setTelefone(entity.getTelefone());
		return bean;
	}
}

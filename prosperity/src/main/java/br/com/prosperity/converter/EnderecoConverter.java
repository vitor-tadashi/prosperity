package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.entity.EnderecoEntity;

@Component
public class EnderecoConverter implements Converter<EnderecoEntity, EnderecoBean>{

	@Override
	public EnderecoEntity convertBeanToEntity(EnderecoBean bean) {
		if (bean == null) {
			return null;
		}
		EnderecoEntity entity = new EnderecoEntity();
		entity.setId(bean.getId());
		entity.setCep(bean.getCep());
		entity.setComplemento(bean.getComplemento());
		entity.setNumero(bean.getNumero());
		entity.setCidade(bean.getCidade());
		entity.setEstado(bean.getEstado());
		entity.setLogradouro(bean.getLogradouro());
		return entity;
	}

	@Override
	public EnderecoBean convertEntityToBean(EnderecoEntity entity) {
		if (entity == null) {
			return null;
		}
		EnderecoBean bean = new EnderecoBean();
		bean.setId(entity.getId());
		bean.setCep(entity.getCep());
		bean.setCidade(entity.getCidade());
		bean.setComplemento(entity.getComplemento());
		bean.setNumero(entity.getNumero());
		bean.setEstado(entity.getEstado());
		bean.setLogradouro(entity.getLogradouro());
		
		return bean;
	}
}

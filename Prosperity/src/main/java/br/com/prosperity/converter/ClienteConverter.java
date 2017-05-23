package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ClienteBean;
import br.com.prosperity.entity.ClienteEntity;

@Component
public class ClienteConverter implements Converter<ClienteEntity, ClienteBean> {

	@Override
	public ClienteEntity convertBeanToEntity(ClienteBean bean) {
		if (bean == null) {
			return null;
		}
		ClienteEntity entity = new ClienteEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());

		return entity;
	}

	@Override
	public ClienteBean convertEntityToBean(ClienteEntity entity) {
		if (entity == null) {
			return null;
		}
		ClienteBean bean = new ClienteBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;
	}
}
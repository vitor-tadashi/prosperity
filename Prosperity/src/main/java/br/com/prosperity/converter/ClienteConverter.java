package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ClienteBean;
import br.com.prosperity.entity.ClienteEntity;

@Component
public class ClienteConverter implements Converter <ClienteEntity, ClienteBean> {

	@Override
	public ClienteEntity convertBeanToEntity(ClienteBean bean) {
		ClienteEntity entity = new ClienteEntity();
		if (bean == null){
			entity = null;
		} else {
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		}
		return entity;
	}

	@Override
	public ClienteBean convertEntityToBean(ClienteEntity entity) {
		ClienteBean bean = new ClienteBean();
		if (entity == null){
			bean = null;
		} else {
			bean.setId(entity.getId());
			bean.setNome(entity.getNome());
		}
		return bean;
	}

}

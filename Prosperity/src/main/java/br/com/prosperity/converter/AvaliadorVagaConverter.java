package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliadorVagaBean;
import br.com.prosperity.entity.AvaliadorVagaEntity;

@Component
public class AvaliadorVagaConverter implements Converter<AvaliadorVagaEntity, AvaliadorVagaBean> {

	@Autowired
	VagaConverter vagaConverter;

	@Autowired
	UsuarioConverter usuarioConverter;

	@Override
	public AvaliadorVagaEntity convertBeanToEntity(AvaliadorVagaBean bean) {
		if (bean == null) {
			return null;
		}
		AvaliadorVagaEntity entity = new AvaliadorVagaEntity();

		entity.setId(bean.getId());	
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setVaga(vagaConverter.convertBeanToEntity(bean.getVaga()));

		return entity;
	}

	@Override
	public AvaliadorVagaBean convertEntityToBean(AvaliadorVagaEntity entity) {
		if (entity == null) {
			return null;
		}
		AvaliadorVagaBean bean = new AvaliadorVagaBean();

		bean.setId(entity.getId());
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));
		//bean.setVaga(vagaConverter.convertEntityToBean(entity.getVaga()));

		return bean;
	}

}

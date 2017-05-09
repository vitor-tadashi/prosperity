package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.DataEntrevistaBean;
import br.com.prosperity.entity.DataEntrevistaEntity;

@Component
public class DataEntrevistaConverter implements Converter<DataEntrevistaEntity, DataEntrevistaBean> {


	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private VagaConverter vagaConverter;

	@Override
	public DataEntrevistaEntity convertBeanToEntity(DataEntrevistaBean bean) {
		if (bean == null) {
			return null;
		}
		DataEntrevistaEntity entity = new DataEntrevistaEntity();

		entity.setIdDataEntrevista(bean.getId());
		entity.setDtEntrevista(bean.getDataEntrevista());
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setVaga(vagaConverter.convertBeanToEntity(bean.getVaga()));

		return entity;
	}

	@Override
	public DataEntrevistaBean convertEntityToBean(DataEntrevistaEntity entity) {
		if (entity == null) {
			return null;
		}
		DataEntrevistaBean bean = new DataEntrevistaBean();
		
		bean.setId(entity.getIdDataEntrevista());
		bean.setDataEntrevista(entity.getDtEntrevista());
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));
		bean.setVaga(vagaConverter.convertEntityToBean(entity.getVaga()));
		
		return bean;
	}

}

package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.AvaliadorCandidatoBean;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;

@Component
public class AvaliadorCandidatoConverter implements Converter<AvaliadorCandidatoEntity, AvaliadorCandidatoBean> {

	@Autowired
	CandidatoConverter candidatoConverter;

	@Autowired
	VagaConverter vagaConverter;

	@Autowired
	UsuarioConverter usuarioConverter;

	@Override
	public AvaliadorCandidatoEntity convertBeanToEntity(AvaliadorCandidatoBean bean) {
		if (bean == null) {
			return null;
		}
		AvaliadorCandidatoEntity entity = new AvaliadorCandidatoEntity();

		entity.setId(bean.getId());
		entity.setCandidato(candidatoConverter.convertBeanToEntity(bean.getCandidato()));
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setVaga(vagaConverter.convertBeanToEntity(bean.getVaga()));
		entity.setStatus(bean.getStatus());

		return entity;
	}

	@Override
	public AvaliadorCandidatoBean convertEntityToBean(AvaliadorCandidatoEntity entity) {
		if (entity == null) {
			return null;
		}
		AvaliadorCandidatoBean bean = new AvaliadorCandidatoBean();

		bean.setId(entity.getId());
		bean.setCandidato(candidatoConverter.convertEntityToBean(entity.getCandidato()));
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));
		bean.setVaga(vagaConverter.convertEntityToBean(entity.getVaga()));
		bean.setStatus(entity.getStatus());

		return bean;
	}

}

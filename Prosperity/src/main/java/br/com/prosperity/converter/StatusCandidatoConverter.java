package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.entity.StatusCandidatoEntity;

@Component
public class StatusCandidatoConverter implements Converter<StatusCandidatoEntity, StatusCandidatoBean> {

	@Autowired
	StatusConverter statusConverter;

	@Autowired
	UsuarioConverter usuarioConverter;

	@Override
	public StatusCandidatoEntity convertBeanToEntity(StatusCandidatoBean bean) {
		StatusCandidatoEntity entity = new StatusCandidatoEntity();

		entity.setIdStatusCandidato(bean.getId());
		entity.setDsParecer(bean.getDescricaoParecer());
		entity.setDtAlteracao(bean.getDataAlteracao());
		entity.setStatus(statusConverter.convertBeanToEntity(bean.getStatus()));
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));

		return entity;
	}

	@Override
	public StatusCandidatoBean convertEntityToBean(StatusCandidatoEntity entity) {
		StatusCandidatoBean bean = new StatusCandidatoBean();

		bean.setId(entity.getIdStatusCandidato());
		bean.setDescricaoParecer(entity.getDsParecer());
		bean.setDataAlteracao(entity.getDtAlteracao());
		bean.setStatus(statusConverter.convertEntityToBean(entity.getStatus()));
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));

		return bean;
	}
}

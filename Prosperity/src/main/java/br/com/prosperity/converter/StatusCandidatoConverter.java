package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.entity.StatusCandidatoEntity;

@Component
public class StatusCandidatoConverter implements Converter<StatusCandidatoEntity, StatusCandidatoBean> {

	@Autowired
	private StatusConverter statusConverter;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private CancelamentoConverter cancelamentoConverter;

	@Override
	public StatusCandidatoEntity convertBeanToEntity(StatusCandidatoBean bean) {
		if (bean == null) {
			return null;
		}
		StatusCandidatoEntity entity = new StatusCandidatoEntity();

		entity.setIdStatusCandidato(bean.getId());
		entity.setDsParecer(bean.getDescricaoParecer());
		entity.setDtAlteracao(bean.getDataAlteracao());
		entity.setFlSituacao(bean.getSituacao());
		entity.setStatus(statusConverter.convertBeanToEntity(bean.getStatus()));
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setCancelamento(cancelamentoConverter.convertBeanToEntity(bean.getCancelamento()));
		entity.setDsCancelamento(bean.getDsCancelamento());
		entity.setNmVaga(bean.getNomeVaga());
		entity.setIdVaga(bean.getIdVaga());

		return entity;
	}

	@Override
	public StatusCandidatoBean convertEntityToBean(StatusCandidatoEntity entity) {
		if (entity == null) {
			return null;
		}
		StatusCandidatoBean bean = new StatusCandidatoBean();

		bean.setId(entity.getIdStatusCandidato());
		bean.setDescricaoParecer(entity.getDsParecer());
		bean.setDataAlteracao(entity.getDtAlteracao());
		bean.setSituacao(entity.getFlSituacao());
		bean.setStatus(statusConverter.convertEntityToBean(entity.getStatus()));
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));
		bean.setCancelamento(cancelamentoConverter.convertEntityToBean(entity.getCancelamento()));
		bean.setDsCancelamento(entity.getDsCancelamento());
		bean.setNomeVaga(entity.getNmVaga());
		bean.setIdVaga(entity.getIdVaga());

		return bean;
	}
}
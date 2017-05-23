package br.com.prosperity.business;

import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.converter.StatusCandidatoConverter;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.entity.StatusCandidatoEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusCandidatoBusiness {

	@Autowired
	private static StatusCandidatoDAO statusCandidatoDAO;

	@Autowired
	private static StatusCandidatoConverter statusCandidatoConverter;

	@Transactional
	public static List<StatusCandidatoBean> obterTodos() {
		List<StatusCandidatoEntity> statusCandidatoEntity = statusCandidatoDAO.findAll();
		List<StatusCandidatoBean> statusCandidatoBean = statusCandidatoConverter
				.convertEntityToBean(statusCandidatoEntity);
		return statusCandidatoBean;
	}

	@Transactional(readOnly = true)
	public StatusCandidatoEntity obterPorId(Integer id) {
		StatusCandidatoEntity entity = statusCandidatoDAO.findById(id);
		return entity;
	}
}
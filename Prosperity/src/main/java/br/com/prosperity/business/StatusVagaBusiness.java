package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.StatusVagaBean;
import br.com.prosperity.converter.StatusVagaConverter;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.entity.StatusVagaEntity;

@Component
public class StatusVagaBusiness {
	
	@Autowired
	private StatusVagaDAO statusVagaDAO;

	@Autowired
	private StatusVagaConverter statusVagaConverter;

	@Transactional
	public List<StatusVagaBean> obterTodos() {
		List<StatusVagaEntity> statusVagaEntity = statusVagaDAO.findAll();
		List<StatusVagaBean> statusVagaBean = statusVagaConverter.convertEntityToBean(statusVagaEntity);
		return statusVagaBean;
	}

	@Transactional(readOnly = true)
	public StatusVagaEntity obterPorId(Integer id) {
		StatusVagaEntity entity = statusVagaDAO.findById(id);
		return entity;
	}
}
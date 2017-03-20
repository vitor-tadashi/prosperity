package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.converter.SenioridadeConverter;
import br.com.prosperity.dao.SenioridadeDAO;
import br.com.prosperity.entity.SenioridadeEntity;

@Component
public class SenioridadeBusiness {

	@Autowired
	private SenioridadeDAO senioridadeDAO;

	@Autowired
	private List<SenioridadeBean> senioridadeBean;

	@Autowired
	private SenioridadeConverter senioridadeConverter;

	@Transactional
	public List<SenioridadeBean> obterTodos() {
		List<SenioridadeEntity> senioridadeEntity = senioridadeDAO.listar();
		senioridadeBean = senioridadeConverter.convertEntityToBean(senioridadeEntity);
		return senioridadeBean;
	}

	@Transactional(readOnly=true)
	public SenioridadeEntity obterPorId(Integer id) {
		SenioridadeEntity entity = senioridadeDAO.obterPorId(id);
		return entity;
	}
	
}

package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.converter.StatusConverter;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.entity.StatusEntity;

@Component
public class StatusBusiness {
	
	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private StatusConverter statusConverter;
	
	@Transactional
	public List<StatusBean> obterTodos() {
		List<StatusEntity> statusEntity = statusDAO.findAll();
		List<StatusBean> statusBean = statusConverter.convertEntityToBean(statusEntity);
		return statusBean;
 	}
	
	@Transactional
	public List<StatusBean> obterStatusVaga() {
		List<StatusEntity> statusEntity = statusDAO.findByNamedQuery("alterarStatus");
		List<StatusBean> statusBean = statusConverter.convertEntityToBean(statusEntity);
		return statusBean;
	}
	
	@Transactional
	public List<StatusBean> getStatus() {
		List<StatusBean> listaStatus = statusConverter.convertEntityToBean(statusDAO.findAll());
		return listaStatus;
	}
	
}

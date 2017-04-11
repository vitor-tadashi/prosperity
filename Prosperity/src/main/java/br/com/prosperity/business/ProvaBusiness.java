package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.ProvaBean;
import br.com.prosperity.converter.ProvaConverter;
import br.com.prosperity.dao.ProvaDAO;
import br.com.prosperity.entity.ProvaEntity;

@Component
public class ProvaBusiness {

	@Autowired
	private ProvaDAO provaDAO;
	
	@Autowired
	private ProvaConverter provaConverter;

	@Transactional
	public List<ProvaBean> listarProva() {
		List<ProvaEntity> entities = provaDAO.findAll();
		List<ProvaBean> beans = provaConverter.convertEntityToBean(entities);

		return beans;

	}
}

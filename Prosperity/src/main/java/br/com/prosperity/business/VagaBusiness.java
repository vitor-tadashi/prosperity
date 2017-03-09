package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaBusiness {
	
	@Autowired
	private VagaDAO vagaDAO;
	
	@Autowired
	private VagaConverter vagaConverter;

	@Transactional
	public List<VagaBean> obterTodos() {
		List <VagaEntity> vagaEntity = vagaDAO.listar();
		List <VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return null;
	}

}

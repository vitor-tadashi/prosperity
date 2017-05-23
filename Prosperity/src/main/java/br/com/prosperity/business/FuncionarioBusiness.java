package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.converter.FuncionarioConverter;
import br.com.prosperity.dao.FuncionarioDAO;
import br.com.prosperity.entity.FuncionarioEntity;

@Component
public class FuncionarioBusiness {

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private FuncionarioConverter funcionarioConverter;

	@Transactional(readOnly = true)
	public List<FuncionarioBean> findAll() {
		List<FuncionarioEntity> funcionarioEntity = funcionarioDAO.findAll();
		List<FuncionarioBean> funcionarioBean = funcionarioConverter.convertEntityToBean(funcionarioEntity);

		return funcionarioBean;
	}
}

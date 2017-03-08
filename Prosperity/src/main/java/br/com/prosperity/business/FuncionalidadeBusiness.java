package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.converter.FuncionalidadeConverter;
import br.com.prosperity.dao.FuncionalidadeDAO;
import br.com.prosperity.entity.FuncionalidadeEntity;
@Component
public class FuncionalidadeBusiness {
	@Autowired
	private FuncionalidadeDAO funcionalidadeDAO;

	@Autowired
	private FuncionalidadeConverter funcionalidadeConverter;

	public List<FuncionalidadeBean> obterTodos() {
		List<FuncionalidadeEntity> funcionalidadeEntity = funcionalidadeDAO.listar();
		List<FuncionalidadeBean> funcionalidadeBean = null;

		return funcionalidadeBean;
	}
}

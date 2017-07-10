package br.com.prosperity.business;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.integration.VeritySysIntegration;

@Component
public class FuncionarioBusiness {

	private VeritySysIntegration integration = new VeritySysIntegration();

	@Transactional(readOnly = true)
	public List<FuncionarioBean> findAll() {
		//List<FuncionarioEntity> funcionarioEntity = funcionarioDAO.findAll();
		List<FuncionarioBean> funcionarioBean = integration.getListFuncionarios();

		return funcionarioBean;
	}
}

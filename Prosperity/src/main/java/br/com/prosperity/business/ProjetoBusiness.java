package br.com.prosperity.business;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.integration.VeritySysIntegration;

@Component
public class ProjetoBusiness {

	public ProjetoBean obterCliente(Integer id) {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getProjeto(id);
	}

	public List<ProjetoBean> obterTodos() {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getListProjetos();
	}

}
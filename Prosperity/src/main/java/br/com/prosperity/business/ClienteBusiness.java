package br.com.prosperity.business;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ClienteBean;
import br.com.prosperity.integration.VeritySysIntegration;

@Component
public class ClienteBusiness {

	public ClienteBean obterCliente(Integer id) {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getCliente(id);
	}

	public List<ClienteBean> obterTodos() {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getListClientes();
	}

}

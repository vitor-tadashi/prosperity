package br.com.prosperity.business;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.integration.VeritySysIntegration;

@Component
public class CargoBusiness {

	public CargoBean obterCliente(Integer id) {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getCargo(id);
	}

	public List<CargoBean> obterTodos() {
		VeritySysIntegration integration = new VeritySysIntegration();
		return integration.getListCargos();
	}

}
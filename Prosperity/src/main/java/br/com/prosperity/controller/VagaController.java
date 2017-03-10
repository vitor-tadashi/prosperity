package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;

@Controller
@RequestMapping("vaga")
public class VagaController {

	@Autowired
	private VagaBusiness vagaBusiness;

	@Autowired
	private List<VagaBean> vagaBean;

	@RequestMapping(value = "consultar", method = RequestMethod.GET)
	public String consultar() {
		// chamar a business acionando o método de consultar vagas para
		// aprovação

		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga(Model model) {
		vagaBean = vagaBusiness.obterTodos();
		model.addAttribute("vagaBean", vagaBean);
		return "vaga/aprovacao-vaga";
	}

	@RequestMapping(value = "solicitar", method = RequestMethod.GET)
	public String solicitarVaga() {
		return "vaga/solicitar-vaga";
	}
}

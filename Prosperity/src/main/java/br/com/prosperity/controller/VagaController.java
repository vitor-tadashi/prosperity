package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;

@Controller
@RequestMapping ("vaga")
public class VagaController {
	@Autowired
private VagaBusiness vagaBusiness;

	@RequestMapping(value = "consultar", method = RequestMethod.GET)
	public String cliente() {
		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga(Model model) {
	/*List<VagaBean> vaga = vagaBusiness.obterTodos();
				List<VagaBean> vagas = new ArrayList<>();
				VagaBean v = new VagaBean();
				v.setNomeSolicitante("Daniel");
				vagas.add(v);*/
				model.addAttribute("nomevaga", "Desenvolvedor");
				
		return "vaga/aprovacao-vaga";		
	}

	@RequestMapping (value= "solicitar", method = RequestMethod.GET)
	public String solicitarVaga(){
		return "vaga/solicitar-vaga";
	}
}

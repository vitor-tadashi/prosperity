package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.VagaDAO;

@Controller
@RequestMapping ("vaga")
public class VagaController {
	
	@Autowired
	VagaBusiness vagaBusiness;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente(Model model) {
		List<VagaBean> vagas = vagaBusiness.obterTodos();
		
		/*vagas.add(b);*/
		model.addAttribute("vagas", vagas);
		
		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "/aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga() {
		return "vaga/aprovacao-vaga";
	}
	@RequestMapping (value= "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(){
		return "vaga/solicitar-vaga";
	}
	@RequestMapping (value = "idAvaliador", method = RequestMethod.GET)
	public String idAvaliador(){
	return "idAvaliador";
	}
}

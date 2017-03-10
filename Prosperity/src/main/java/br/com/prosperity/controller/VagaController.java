package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.ProjetoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;

import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.VagaDAO;

@Controller
@RequestMapping("vaga")
public class VagaController {


	@Autowired
	private VagaBusiness vagaBusiness;

	@Autowired
	private List<VagaBean> vagaBean;

	private SenioridadeBusiness preencherSenioridade;
	
	@Autowired
	private CargoBusiness preencherCargo;
	
	@Autowired
	private ProjetoBusiness preencherProjeto;
	
	@Autowired
	private List<SenioridadeBean> senioridadeBean;
	
	@Autowired
	private List<CargoBean> cargoBean;
	
	@Autowired
	private List<ProjetoBean> projetoBean;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente(Model model) {
		List<VagaBean> vagas = vagaBusiness.obterTodos();
		
		/*vagas.add(b);*/
		model.addAttribute("vagas", vagas);
		
		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga(Model model) {
		vagaBean = vagaBusiness.obterTodos();
		model.addAttribute("vagaBean", vagaBean);
		return "vaga/aprovacao-vaga";
	}
	
	@RequestMapping (value= "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(Model model){
		senioridadeBean = preencherSenioridade.obterTodos();
		cargoBean = preencherCargo.obterTodos();
		projetoBean = preencherProjeto.obterTodos();
		model.addAttribute("cargoBean", cargoBean);
		model.addAttribute("senioridadeBean", senioridadeBean);
		model.addAttribute("projetoBean", projetoBean);
		return "vaga/solicitar-vaga";
	}

	@RequestMapping (value = "idAvaliador", method = RequestMethod.GET)
	public String idAvaliador(){
	return "idAvaliador";
	}
}

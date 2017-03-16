package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.ProjetoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.UsuarioBusiness;
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

	@Autowired
	private SenioridadeBusiness preencherSenioridade;
	
	@Autowired
	private CargoBusiness preencherCargo;
	
	@Autowired
	private ProjetoBusiness preencherProjeto;
	
	@Autowired
	private UsuarioBusiness preencherUsuario;
	
	@Autowired
	private List<SenioridadeBean> senioridades;
	
	@Autowired
	private List<CargoBean> cargos;
	
	@Autowired
	private List<ProjetoBean> projetos;
	
	@Autowired
	private ProjetoBean projeto;
	
	@Autowired
	private List<SenioridadeBean> senioridadeBean;
	
	@Autowired
	private SenioridadeBean senioridade;
	
	@Autowired
	private List<CargoBean> cargoBean;
	
	@Autowired
	private List<UsuarioBean> usuarios;
	
	@Autowired
	private CargoBusiness cargoBusiness;
	
	@Autowired
	private SenioridadeBusiness senioridadeBusiness;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente(Model model) {
		List<VagaBean> vagas = vagaBusiness.obterTodos();
		
		/*vagas.add(b);*/
		model.addAttribute("vagaBean", vagas);
		
		
		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);
		
		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);
		
		List<VagaBean> listaVaga = vagaBusiness.obterTodos();
		model.addAttribute("listaVaga", listaVaga);
		
		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public @ResponseBody List<VagaBean> obterTodos(Model model, @ModelAttribute("id") Integer id) {
		List<VagaBean> listaVaga = vagaBusiness.obterTodos(id);
		//model.addAttribute("vagas", vagaBusiness.obterTodos());
		return listaVaga;
	}
	
	@RequestMapping (value= "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(Model model){
		senioridades = preencherSenioridade.obterTodos();
		cargos = preencherCargo.obterTodos();
		projetos = preencherProjeto.obterTodos();
		usuarios = preencherUsuario.buscarGestor(); //Buscar somente Gestores
		model.addAttribute("senioridades", senioridades);
		model.addAttribute("cargos", cargos);
		model.addAttribute("projetos", projetos);
		model.addAttribute("usuarios", usuarios);
		return "vaga/solicitar-vaga";
	}

	@RequestMapping (value = "idAvaliador", method = RequestMethod.GET)
	public String idAvaliador(){
	return "idAvaliador";
	}
}

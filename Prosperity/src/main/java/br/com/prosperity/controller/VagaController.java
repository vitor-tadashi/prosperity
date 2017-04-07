package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.bean.StatusVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.ProjetoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.StatusBusiness;
import br.com.prosperity.business.StatusVagaBusiness;
import br.com.prosperity.business.UsuarioBusiness;
import br.com.prosperity.business.VagaBusiness;

@Controller
@RequestMapping("vaga")
public class VagaController {
	


	@Autowired
	private VagaBusiness vagaBusiness;

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
	private List<UsuarioBean> usuarios;

	@Autowired
	private CargoBusiness cargoBusiness;

	@Autowired
	private SenioridadeBusiness senioridadeBusiness;

	@Autowired
	private StatusBusiness statusBusiness;

	@Autowired
	private StatusVagaBusiness statusVagaBusiness;

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente(Model model, VagaBean vaga) {

		// FAZ APARECER A TABELA
		model.addAttribute("vagas", vagaBusiness.listar());

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		/*
		 * List<VagaBean> listaVaga = vagaBusiness.listar();
		 * model.addAttribute("listaVaga", listaVaga);
		 */

		List<StatusBean> listaStatus = statusBusiness.obterTodos();
		model.addAttribute("listaStatus", listaStatus);

		List<StatusBean> listaStatusDrop = statusBusiness.obterStatusVaga();
		model.addAttribute("listaStatusDrop", listaStatusDrop);

		/*
		 * List<StatusVagaBean> listaStatusVaga =
		 * statusVagaBusiness.obterTodos(); StatusVagaBean vagaStatus = new
		 * StatusVagaBean(); for(StatusVagaBean svb : listaStatusVaga){
		 * vagaStatus = svb; } model.addAttribute("listaStatusVaga",
		 * listaStatusVaga);
		 */

		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = { "filtro" }, method = RequestMethod.GET)
	public String filtrar(Model model, VagaBean vaga) {
		if (vaga.getNomeVaga().isEmpty() && vaga.getDataAberturaDe() == null && vaga.getDataAberturaPara() == null
				&& vaga.getStatus().get(0).getStatus().getNome().equals("Selecione")) {
			return "redirect:consultar";

		}

		List<VagaBean> listaVagaFiltro = vagaBusiness.filtroVaga(vaga);
		model.addAttribute("vagas", listaVagaFiltro);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		/*
		 * List<VagaBean> listaVaga = vagaBusiness.listar();
		 * model.addAttribute("listaVaga", listaVaga);
		 */

		List<StatusBean> listaStatus = statusBusiness.obterTodos();
		model.addAttribute("listaStatus", listaStatus);

		List<StatusVagaBean> listaStatusVaga = statusVagaBusiness.obterTodos();
		model.addAttribute("listaStatusVaga", listaStatusVaga);

		List<StatusBean> listaStatusDrop = statusBusiness.obterStatusVaga();
		model.addAttribute("listaStatusDrop", listaStatusDrop);

		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = { "abrir" }, method = RequestMethod.GET)
	public @ResponseBody VagaBean abrirVagaAjax(Model model, @ModelAttribute("id") Integer id) {
		VagaBean vaga = new VagaBean();
		vaga = vagaBusiness.obterVagaPorId(id);
		return vaga;
	}

	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga(Model model) {
		model.addAttribute("vagas", vagaBusiness.listarVagaAprovar());
		return "vaga/aprovar-vaga";
	}

	@RequestMapping(value = { "visualizar" }, method = RequestMethod.GET)
	public @ResponseBody VagaBean visualizarVagaAjax(Model model, @ModelAttribute("id") Integer id) {
		VagaBean vaga = new VagaBean();
		vaga = vagaBusiness.obterVagaPorId(id);
		return vaga;
	}

	@RequestMapping(value = "status", method = RequestMethod.POST)
	public @ResponseBody HttpStatus alterarStatusVaga(Model model, SituacaoVagaBean status) {
		vagaBusiness.alterarStatus(status);
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(Model model) {
		obterDominiosVaga(model);
		return "vaga/solicitar-vaga";
	}

	private void obterDominiosVaga(Model model) {
		senioridades = preencherSenioridade.obterTodos();
		cargos = preencherCargo.obterTodos();
		projetos = preencherProjeto.obterTodos();
		usuarios = preencherUsuario.findAll();

		model.addAttribute("senioridades", senioridades);
		model.addAttribute("cargos", cargos);
		model.addAttribute("projetos", projetos);
		model.addAttribute("usuarios", usuarios);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String solicitarVaga(Model model, @PathVariable Integer id) {

		VagaBean vaga = null;
		vaga = vagaBusiness.obterVagaPorId(id);

		obterDominiosVaga(model);
		model.addAttribute("vaga", vaga);

		return "vaga/solicitar-vaga";
	}

	@RequestMapping(value = "idAvaliador", method = RequestMethod.GET)
	public String idAvaliador() {
		return "idAvaliador";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String inserirVaga(@ModelAttribute("vagaBean") @Valid VagaBean vagaBean, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("vaga", vagaBean);
			obterDominiosVaga(model);
			return "vaga/solicitar-vaga";
		}
		
		vagaBusiness.inserir(vagaBean,usuarios);
		System.out.println("\n\n\nCadastrado\n\n\n");
		return "redirect:solicitar";

	}
	
	@RequestMapping(value = "/avaliadores", method = RequestMethod.POST)
	@ResponseBody
	public String recebeAvaliadores(List<Integer> avaliadores){
		
		for(Integer dados:avaliadores){
			usuarios.get(0).setId(dados);
		}
	    
		return "ok";
		
	}

	private List<String> buildErrorMessage(List<FieldError> error) {
		List<String> novosErros = new ArrayList<>();

		for (FieldError data : error) {

			novosErros.add(data.getDefaultMessage());

		}
		return novosErros;
	}
	/*
	 * @RequestMapping(value = "obter-vaga", method=RequestMethod.GET)
	 * public @ResponseBody List<VagaBean> obterVaga(Model
	 * model,@ModelAttribute("Visualizar")Integer id){ List<VagaBean> listaVaga
	 * = vagaBusiness.obterTodos(id); return listaVaga; }
	 */

}

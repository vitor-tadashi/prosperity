package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;

import br.com.prosperity.bean.AvaliadorVagaBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.bean.StatusVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.AvaliadorVagaBusiness;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.CargoSenioridadeBusiness;
import br.com.prosperity.business.ProjetoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.StatusBusiness;
import br.com.prosperity.business.StatusVagaBusiness;
import br.com.prosperity.business.UsuarioBusiness;
import br.com.prosperity.business.VagaBusiness;
import br.com.prosperity.enumarator.StatusVagaEnum;
import br.com.prosperity.exception.BusinessException;

@Controller
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaBusiness vagaBusiness;

	@Autowired
	private ProjetoBusiness projetoBusiness;

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
	private List<UsuarioBean> avaliadoresB;

	@Autowired
	private CargoSenioridadeBusiness cargoSenioridadeBusiness;

	@Autowired
	private CargoBusiness cargoBusiness;

	@Autowired
	private SenioridadeBusiness senioridadeBusiness;

	@Autowired
	private StatusBusiness statusBusiness;

	@Autowired
	private StatusVagaBusiness statusVagaBusiness;

	@Autowired
	private AvaliadorVagaBusiness avaliadorVagaBusiness;

	private void paginacao(Integer page, Model model, VagaBean vaga) {

		Integer startpage = 1;
		Integer endpage = vagaBusiness.totalPagina(vaga);

		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("page", page);
	}

	@RequestMapping(value = "/visualizarCandidato/{id}", method = RequestMethod.GET)
	public String visualizarCandidato(@PathVariable Integer id) {

		return "redirect:/candidato/filtrar";
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente(@RequestParam(value = "page", required = false) Integer page, Model model, VagaBean vaga,
			Integer id) {
		if (page == null) {
			page = 1;
		}
		List<VagaBean> vagas = vagaBusiness.filtroVaga(vaga, page);
		// Paginando
		paginacao(page, model, vaga);

		model.addAttribute("vagas", vagas);
		List<AvaliadorVagaBean> avaliadorVagaBean = avaliadorVagaBusiness.obterAvaliador(id);
		model.addAttribute("avaliadores", avaliadorVagaBean);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<StatusBean> listaStatus = statusBusiness.obterTodos();
		model.addAttribute("listaStatus", listaStatus);

		List<StatusBean> listaStatusDrop = statusBusiness.obterStatusVaga();
		model.addAttribute("listaStatusDrop", listaStatusDrop);

		vagaBusiness.obterQtdCandidatos(1200);

		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = { "/filtro" }, method = RequestMethod.GET)
	public String filtrar(@RequestParam(value = "page", required = false) Integer page, Model model, VagaBean vaga) {
		if (page == null) {
			page = 1;
		}
		List<VagaBean> vagas = vagaBusiness.filtroVaga(vaga, page);
		// Paginando
		paginacao(page, model, vaga);
		model.addAttribute("filtroVaga", vaga);
		model.addAttribute("vagas", vagas);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<StatusBean> listaStatus = statusBusiness.obterTodos();
		model.addAttribute("listaStatus", listaStatus);

		List<StatusVagaBean> listaStatusVaga = statusVagaBusiness.obterTodos();
		model.addAttribute("listaStatusVaga", listaStatusVaga);

		List<StatusBean> listaStatusDrop = statusBusiness.obterStatusVaga();
		model.addAttribute("listaStatusDrop", listaStatusDrop);

		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = { "/abrir" }, method = RequestMethod.GET)
	public @ResponseBody VagaBean abrirVagaAjax(Model model, @ModelAttribute("id") Integer id) {
		VagaBean vaga = new VagaBean();
		vaga = vagaBusiness.obterVagaPorId(id);
		return vaga;
	}

	@RequestMapping(value = "/aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga(@ModelAttribute("sucesso") String sucesso, Model model) {
		System.out.println(sucesso);
		model.addAttribute("vagas", vagaBusiness.listarVagaAprovar());
		return "vaga/aprovar-vaga";
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public @ResponseBody Integer alterarStatusVaga(Model model, SituacaoVagaBean status) {
		vagaBusiness.alterarStatus(status);
		vagaBusiness.alterarDataAprovacao(status);
		Integer id = status.getStatus().getValue();
		return id;
	}

	@RequestMapping(value = "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(Model model) {
		obterDominiosVaga(model);
		return "vaga/solicitar-vaga";
	}

	private void obterDominiosVaga(Model model) {
		senioridades = preencherSenioridade.obterTodos();
		cargos = preencherCargo.obterTodos();
		projetos = preencherProjeto.buscarProjetoAtivo();
		usuarios = preencherUsuario.buscarUsuarioAtivo();

		model.addAttribute("senioridades", senioridades);
		model.addAttribute("cargos", cargos);
		model.addAttribute("projetos", projetos);
		model.addAttribute("usuarios", usuarios);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String solicitarVaga(Model model, @PathVariable Integer id) {

		VagaBean vaga = null;
		vaga = vagaBusiness.obterVagaPorId(id);
		StatusVagaBean ultimoStatus = vaga.getUltimoStatus();
		List<AvaliadorVagaBean> avaliadorVagaBean = null;
		avaliadorVagaBean = vagaBusiness.obterAvaliadores(id);

		obterDominiosVaga(model);
		model.addAttribute("vaga", vaga);
		model.addAttribute("avaliadorVagaBean", avaliadorVagaBean);
		model.addAttribute("ultimoStatus", ultimoStatus);

		return "vaga/solicitar-vaga";
	}

	@RequestMapping(value = "/idAvaliador", method = RequestMethod.GET)
	public String idAvaliador() {
		return "idAvaliador";
	}

	@RequestMapping(value = "/cancelar-candidato/{id}")
	public RedirectView cancelaCandidato(Model model, @PathVariable Integer id, RedirectAttributes redirectAttributes)
			throws BusinessException {
		SituacaoVagaBean bean = new SituacaoVagaBean();
		bean.setIdVaga(id);
		bean.setStatus(StatusVagaEnum.CANCELADO);
		vagaBusiness.alterarStatus(bean);

		return new RedirectView("/vaga/aprovar", true);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String inserirVaga(@ModelAttribute("vagaBean") @Valid VagaBean vagaBean, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("vaga", vagaBean);
			obterDominiosVaga(model);
			return "vaga/solicitar-vaga";
		}
	
		vagaBusiness.inserir(vagaBean, avaliadoresB);
		redirectAttributes.addFlashAttribute("sucesso", "Vaga solicitada com sucesso!");
		return "redirect:/vaga/solicitar";

	}

	@RequestMapping(value = "/avaliadores", method = RequestMethod.POST)
	public @ResponseBody void recebeAvaliadores(@ModelAttribute("avaliadores") String avaliadores) {

		@SuppressWarnings("unchecked")
		List<String> resultado = new Gson().fromJson(avaliadores, List.class);
		avaliadoresB = new ArrayList<>();
		for (String dados : resultado) {
			UsuarioBean avaliador = new UsuarioBean();
			avaliador.setId(Integer.parseInt(dados));
			avaliadoresB.add(avaliador);
		}
		//avaliadoresB.remove(0);

	}

	private List<String> buildErrorMessage(List<FieldError> error) {
		List<String> novosErros = new ArrayList<>();

		for (FieldError data : error) {

			novosErros.add(data.getDefaultMessage());

		}
		return novosErros;
	}

	@RequestMapping(value = "/obter-cliente", method = RequestMethod.GET)
	public @ResponseBody List<ProjetoBean> obterPerfilFuncionalidade(Model model, @ModelAttribute("id") Integer id) {
		List<ProjetoBean> cliente = projetoBusiness.obterCliente(id);
		return cliente;
	}

	@RequestMapping(value = "/obter-range-salarial", method = RequestMethod.GET)
	public @ResponseBody List<CargoSenioridadeBean> obterCargoSenioridade(Model model,
			@ModelAttribute("idCargo") Integer idCargo, @ModelAttribute("idSenioridade") Integer idSenioridade) {
		CargoBean cargo = new CargoBean();
		SenioridadeBean senioridade = new SenioridadeBean();
		cargo.setId(idCargo);
		senioridade.setId(idSenioridade);
		List<CargoSenioridadeBean> rangeSalarial = cargoSenioridadeBusiness.obterRangeSalarial(cargo.getId(),
				senioridade.getId());
		return rangeSalarial;
	}
	
	@RequestMapping(value = "/obter-perfil-pre-pronto", method = RequestMethod.GET)
	public @ResponseBody List<CargoSenioridadeBean> obterPerfilPrePronto(Model model,
			@ModelAttribute("idCargo") Integer idCargo, @ModelAttribute("idSenioridade") Integer idSenioridade) {
		CargoBean cargo = new CargoBean();
		SenioridadeBean senioridade = new SenioridadeBean();
		cargo.setId(idCargo);
		senioridade.setId(idSenioridade);
		List<CargoSenioridadeBean> perfilPrePronto = cargoSenioridadeBusiness.obterRangeSalarial(cargo.getId(),
				senioridade.getId());
		return perfilPrePronto;
	}
	/*
	 * @RequestMapping(value = "obter-vaga", method=RequestMethod.GET)
	 * public @ResponseBody List<VagaBean> obterVaga(Model
	 * model,@ModelAttribute("Visualizar")Integer id){ List<VagaBean> listaVaga
	 * = vagaBusiness.obterTodos(id); return listaVaga; }
	 */

}

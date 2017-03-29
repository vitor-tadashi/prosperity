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
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.AvaliadorBusiness;
import br.com.prosperity.business.CanalInformacaoBusiness;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.FuncionarioBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.SituacaoAtualBusiness;
import br.com.prosperity.business.TipoCursoBusiness;
import br.com.prosperity.business.VagaBusiness;
import br.com.prosperity.exception.BusinessException;

@Controller
@RequestMapping(value = "candidato")
public class CandidatoController {

	@Autowired
	private CandidatoBean candidatoBean;
	
	@Autowired
	private CandidatoBusiness candidatoBusiness;

	@Autowired
	private EnderecoBean enderecoBean;

	@Autowired
	private FormacaoBean formacaoBean;

	@Autowired
	private ContatoBean contatoBean;

	@Autowired
	private AvaliacaoBean avaliacaoBean;

	@Autowired
	private List<CandidatoCompetenciaBean> competencias;

	@Autowired
	private TipoCursoBusiness tipoCursoBusiness;

	@Autowired
	private SituacaoAtualBusiness situacaoAtualBusiness;

	@Autowired
	private FuncionarioBusiness funcionarioBusiness;

	@Autowired
	private CargoBusiness cargoBusiness;
	
	@Autowired
	private TipoCursoBean tipoCursoBean;
	
	@Autowired
	private SenioridadeBusiness senioridadeBusiness;

	@Autowired
	private SenioridadeBean senioridadeBean;
	
	@Autowired
	private SituacaoAtualBean situacaoAtualBean;
	
	@Autowired
	private VagaBusiness vagaBusiness;
	@Autowired
	private CanalInformacaoBusiness canalInformacaoBusiness;
	
	@Autowired
	private AvaliadorBusiness avaliadorBusiness;
	@Autowired
	private SituacaoCandidatoBean situacaoCandidatoBean;

	/**
	 * @author thamires.miranda
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		obterDominiosCandidato(model);

		return "candidato/cadastrar-candidato";
	}

	private void obterDominiosCandidato(Model model) {
		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.obterTodos();
		model.addAttribute("tiposCurso", tiposCurso);

		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.obterTodos();
		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);

		List<VagaBean> listaVaga = vagaBusiness.listar();
		model.addAttribute("listaVaga", listaVaga);
		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.obterTodos();
		model.addAttribute("listaCanal", listaCanal);
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCandidato(@ModelAttribute("candidatoBean") @Valid CandidatoBean candidatoBean,
			BindingResult result, Model model) throws BusinessException {

		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("candidato", candidatoBean);

			obterDominiosCandidato(model);

			return "candidato/cadastrar-candidato";

		} else {
			candidatoBusiness.inserir(candidatoBean);
		}

		/*
		 * candidatoBean =
		 * candidatoBusiness.obterPorCPF(candidatoBean.getCpf());
		 * 
		 * situacaoCandidatoBean.setIdCandidato(candidatoBean.getId());
		 * situacaoCandidatoBean.setStatus(StatusCandidatoEnum.CANDIDATURA);
		 * 
		 * candidatoBusiness.alterarStatus(situacaoCandidatoBean);
		 */

		return "candidato/cadastrar-candidato";
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String solicitarCandidato(Model model, @PathVariable Integer id) {
		CandidatoBean candidato = candidatoBusiness.obterCandidatoPorId(id);
		obterDominiosCandidato(model);
		model.addAttribute("candidato", candidato);

		return "candidato/cadastrar-candidato";
	}
	
	@RequestMapping(value = "editar/salvar", method = RequestMethod.POST)
	public String salvarEditar(@ModelAttribute("candidatoBean") @Valid CandidatoBean candidatoBean,
			BindingResult result, Model model) throws BusinessException {

		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("candidato", candidatoBean);

			obterDominiosCandidato(model);

			return "candidato/cadastrar-candidato";

		} else {
			candidatoBusiness.inserir(candidatoBean);
		}
		 
		return "candidato/cadastrar-candidato";
	}
	

	@RequestMapping(value = "consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH(Model model) {
		List<CandidatoBean> candidatos = candidatoBusiness.listar();
		model.addAttribute("candidatos", candidatos);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.obterTodos();
		model.addAttribute("listaFuncionarios", listaFuncionarios);
		
		//avaliadorBusiness.listar();

		return "candidato/consulta-rh";
		}
	
	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrarCandidatoRH(Model model, CandidatoBean candidato) 
	{
		List<CandidatoBean> candidatos = candidatoBusiness.obterFiltro(candidato);
		model.addAttribute("candidatos", candidatos);

		/*
		 * List<VagaBean> listaVaga = vagaBusiness.listar();
		 * model.addAttribute("listaVaga", listaVaga);
		 * 
		 * List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		 * model.addAttribute("listaCargo", listaCargo);
		 * 
		 * List<SenioridadeBean> listaSenioridade =
		 * senioridadeBusiness.obterTodos();
		 * model.addAttribute("listaSenioridade", listaSenioridade);
		 * 
		 * List<FuncionarioBean> listaFuncionarios =
		 * funcionarioBusiness.obterTodos();
		 * model.addAttribute("listaFuncionarios", listaFuncionarios);
		 */

		// avaliadorBusiness.listar();

		List<VagaBean> listaVaga = vagaBusiness.listar();
		model.addAttribute("listaVaga", listaVaga);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.obterTodos();
		model.addAttribute("listaFuncionarios", listaFuncionarios);

		// avaliadorBusiness.listar();

		return "candidato/consulta-rh";}
	
	@RequestMapping(value = "consultar-gestor", method = RequestMethod.GET)
	public String consultarCandidatoGestor() {
		return "candidato/consulta-gestor";
	}

	@RequestMapping(value = "historico", method = RequestMethod.GET)
	public String historicoCandidato(Model model) {
		CandidatoBean candidatoBean = candidatoBusiness.obter(2);

		model.addAttribute("candidato", candidatoBean);

		return "candidato/historico-candidato";
	}

	@RequestMapping(value = "aprovar-candidato", method = RequestMethod.GET)
	public String aprovarCandidato(Model model) {

		List<CandidatoBean> candidatos = candidatoBusiness.listar();

		model.addAttribute("candidatos", candidatos);
		
		return "candidato/aprovar-candidato";
	}
	
	@RequestMapping(value= {"gerenciar"}, method = RequestMethod.GET)
	public @ResponseBody CandidatoBean gerenciarAjax(Model model, @ModelAttribute("id") Integer id) {
		CandidatoBean candidato = new CandidatoBean();
		candidato = candidatoBusiness.obterCandidatoPorId(id);
		return candidato;
	}


	private List<String> buildErrorMessage(List<FieldError> error) {
		List<String> novosErros = new ArrayList<>();

		for (FieldError data : error) {

			switch (data.getField()) {

			case "dataNascimento":
				novosErros.add(" A data de nascimento deve ser preenchida ");
				break;
			case "entrevista":
				novosErros.add(" A data da entrevista deve ser preenchida ");
				break;
			case "formacao.dataConclusao":
				novosErros.add(" A data da conclusão do curso deve ser preenchida ");
				break;
			default:
				novosErros.add(data.getDefaultMessage());

			}

		}

		return novosErros;
	}

}

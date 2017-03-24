package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "candidato")
public class CandidatoController {
//
//	@Autowired
//	private CandidatoBean candidatoBean;
//	
//	@Autowired
//	private CandidatoBusiness candidatoBusiness;
//
//	@Autowired
//	private EnderecoBean enderecoBean;
//
//	@Autowired
//	private FormacaoBean formacaoBean;
//
//	@Autowired
//	private ContatoBean contatoBean;
//
//	@Autowired
//	private AvaliacaoBean avaliacaoBean;
//
//	@Autowired
//	private List<CandidatoCompetenciaBean> competencias;
//
//	@Autowired
//	private TipoCursoBusiness tipoCursoBusiness;
//
//	@Autowired
//	private SituacaoAtualBusiness situacaoAtualBusiness;
//
//	@Autowired
//	private FuncionarioBusiness funcionarioBusiness;
//
//	@Autowired
//	private CargoBusiness cargoBusiness;
//	
//	@Autowired
//	private TipoCursoBean tipoCursoBean;
//	
//	@Autowired
//	private SenioridadeBusiness senioridadeBusiness;
//
//	@Autowired
//	private SenioridadeBean senioridadeBean;
//	
//	@Autowired
//	private SituacaoAtualBean situacaoAtualBean;
//	
//	@Autowired
//	private VagaBusiness vagaBusiness;
//	@Autowired
//	private CanalInformacaoBusiness canalInformacaoBusiness;
//	
//	@Autowired
//	private AvaliadorBusiness avaliadorBusiness;
//
//	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
//	public String cadastrarCandidato(Model model) {
//		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.obterTodos();
//		model.addAttribute("tiposCurso", tiposCurso);
//
//		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.obterTodos();
//		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);
//
//		List<VagaBean> listaVaga = vagaBusiness.listar();
//		model.addAttribute("listaVaga", listaVaga);
//		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.obterTodos();
//		model.addAttribute("listaCanal", listaCanal);
//
//		return "candidato/cadastrar-candidato";
//	}
//
//	@RequestMapping(value = "salvar", method = RequestMethod.POST)
//	public String salvarCandidato(@ModelAttribute("candidatoBean") @Valid CandidatoBean candidatoBean, BindingResult result, Model model)
//			throws BusinessException {
//		
//		if(result.hasErrors()) {
//			model.addAttribute("erro",result.getErrorCount());
//			  return "candidato/cadastrar-candidato";
//			}
//		candidatoBusiness.inserir(candidatoBean);
//
//		return "candidato/cadastrar-candidato";
//	}
//
//	@RequestMapping(value = "consultar-rh", method = RequestMethod.GET)
//	public String consultarCandidatoRH(Model model) {
//		List<CandidatoBean> candidatos = candidatoBusiness.listar();
//		model.addAttribute("candidatos", candidatos);
//
//		List<VagaBean> listaVaga = vagaBusiness.listar();
//		model.addAttribute("listaVaga", listaVaga);
//
//		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
//		model.addAttribute("listaCargo", listaCargo);
//
//		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
//		model.addAttribute("listaSenioridade", listaSenioridade);
//
//		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.obterTodos();
//		model.addAttribute("listaFuncionarios", listaFuncionarios);
//		
//		avaliadorBusiness.listar();
//
//		return "candidato/consulta-rh";
//	} 
//	
//	@RequestMapping(value = "consultar-gestor", method = RequestMethod.GET)
//	public String consultarCandidatoGestor() {
//		return "candidato/consulta-gestor";
//	}
//
//	@RequestMapping(value = "historico", method = RequestMethod.GET)
//	public String historicoCandidato(Model model) {
//		CandidatoBean candidatoBean = candidatoBusiness.obter(2);
//
//		model.addAttribute("candidato", candidatoBean);
//
//		return "candidato/historico-candidato";
//	}
//
//	@RequestMapping(value = "aprovar-candidato", method = RequestMethod.GET)
//	public String aprovarCandidato(Model model) {
//
//		List<CandidatoBean> candidatos = candidatoBusiness.listar();
//
//		model.addAttribute("candidatos", candidatos);
//		
//		return "candidato/aprovar-candidato";
//	}
//	
//	@RequestMapping(value= {"gerenciar"}, method = RequestMethod.GET)
//	public @ResponseBody CandidatoBean gerenciarAjax(Model model, @ModelAttribute("id") Integer id) {
//		CandidatoBean candidato = new CandidatoBean();
//		candidato = candidatoBusiness.obterCandidatoPorId(id);
//		return candidato;
//	}
}

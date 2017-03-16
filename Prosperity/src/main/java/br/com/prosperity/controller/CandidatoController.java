package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.CanalInformacaoBusiness;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.CargoBusiness;
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
	private CargoBusiness cargoBusiness;

	@Autowired
	private TipoCursoBean tipoCursoBean;

	@Autowired
	private SenioridadeBusiness senioridadeBusiness;

	@Autowired
	private SituacaoAtualBean situacaoAtualBean;
	@Autowired
	private VagaBusiness vagaBusiness;
	@Autowired
	private CanalInformacaoBusiness canalInformacaoBusiness;
	

	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.getTipoCurso();
		model.addAttribute("tiposCurso", tiposCurso);

		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.getSituacaoAtual();
		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);

		List<VagaBean> listaVaga = vagaBusiness.getVaga();
		model.addAttribute("listaVaga", listaVaga);
		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.getCanal();
		model.addAttribute("listaCanal", listaCanal);

	
		
		return "candidato/cadastrar-candidato";
	}
	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public String salvarCandidato(@ModelAttribute("candidatoBean") CandidatoBean candiatoBean) throws BusinessException{
		candidatoBusiness.inserir(candiatoBean);
	
		return"candidato/salvar-candidato";
	}

	@RequestMapping(value = "consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH(Model model) {
		List<CandidatoBean> candidatos = candidatoBusiness.obterTodos();
		model.addAttribute("candidatos", candidatos);
		return "candidato/consulta-rh";
	}

	@RequestMapping(value = "consultar-gestor", method = RequestMethod.GET)
	public String consultarCandidatoGestor() {
		return "candidato/consulta-gestor";
	}

	@RequestMapping(value = "historico", method = RequestMethod.GET)
	public String historicoCandidato(Model model) {
		candidatoBean = candidatoBusiness.obter(2);
		
		model.addAttribute("candidato", candidatoBean);

		return "candidato/historico-candidato";
	}
}

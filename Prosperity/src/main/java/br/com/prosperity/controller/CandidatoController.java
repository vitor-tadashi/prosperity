package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping(value = "candidato")
public class CandidatoController {

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
	private CargoBean cargoBean;
	@Autowired
	private VagaBusiness vagaBusiness;
	@Autowired
	private CanalInformacaoBusiness canalInformacaoBusiness;
	@Autowired
	private CanalInformacaoBean canalInformacaoBean;

	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.obterTodos();
		model.addAttribute("tiposCurso", tiposCurso);

		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.obterTodos();
		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);

		List<VagaBean> listaVaga = vagaBusiness.obterTodos();
		model.addAttribute("listaVaga", listaVaga);
		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.obterTodos();
		model.addAttribute("listaCanal", listaCanal);

		return "candidato/cadastrar-candidato";
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
		model.addAttribute("candidato", candidatoBusiness.obter(2));

		return "candidato/historico-candidato";
	}
}

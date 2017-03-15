package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.bean.EnderecoBean;
import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.SituacaoAtualBusiness;
import br.com.prosperity.business.TipoCursoBusiness;

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

	@RequestMapping(value = "cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.getTipoCurso();
		model.addAttribute("tiposCurso", tiposCurso);

		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.getSituacaoAtual();
		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);

//		List<CargoBean> listaCargo = cargoBusiness.getCargo();
//		model.addAttribute("listaCargo", listaCargo);

//		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.getSenioridade();
//		model.addAttribute("listaSenioridade", listaSenioridade);

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
		CandidatoBean candidatoBean = new CandidatoBean();
		candidatoBean = candidatoBusiness.obter(3);

		enderecoBean = candidatoBean.getEndereco();
		contatoBean = candidatoBean.getContato();
		formacaoBean = candidatoBean.getFormacao();
		situacaoAtualBean = formacaoBean.getSituacaoAtualBean();
		tipoCursoBean = formacaoBean.getTipoCursoBean();

		model.addAttribute("candidato", candidatoBean);
		model.addAttribute("endereco", enderecoBean);
		model.addAttribute("contato", contatoBean);
		model.addAttribute("formacao", formacaoBean);
		model.addAttribute("situacaoAtual", formacaoBean.getSituacaoAtualBean());
		model.addAttribute("tipoCurso", tipoCursoBean);

		model.addAttribute("candidato", candidatoBean);
		model.addAttribute("endereco", enderecoBean);

		return "candidato/historico-candidato";
	}
}

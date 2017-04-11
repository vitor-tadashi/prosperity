package br.com.prosperity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.ProvaBean;
import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.CanalInformacaoBusiness;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.FuncionarioBusiness;
import br.com.prosperity.business.ProvaBusiness;
import br.com.prosperity.business.ProvaCandidatoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.SituacaoAtualBusiness;
import br.com.prosperity.business.TipoCursoBusiness;
import br.com.prosperity.business.VagaBusiness;
import br.com.prosperity.exception.BusinessException;

@Controller
@RequestMapping(value = "candidato")
public class CandidatoController<PaginarCandidato> {

	@Autowired
	private CandidatoBusiness candidatoBusiness;

	@Autowired
	private TipoCursoBusiness tipoCursoBusiness;

	@Autowired
	private SituacaoAtualBusiness situacaoAtualBusiness;

	@Autowired
	private FuncionarioBusiness funcionarioBusiness;

	@Autowired
	private CargoBusiness cargoBusiness;

	@Autowired
	private SenioridadeBusiness senioridadeBusiness;

	@Autowired
	private VagaBusiness vagaBusiness;

	@Autowired
	private CanalInformacaoBusiness canalInformacaoBusiness;

	@Autowired
	private ProvaBusiness provaBusiness;
	
	@Autowired
	private ProvaCandidatoBusiness provaCandidatoBusiness;

	/**
	 * @author andre.posman
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

		List<VagaBean> listaVaga = vagaBusiness.listarVagasAtivas();
		model.addAttribute("listaVaga", listaVaga);

		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.obterTodos();
		model.addAttribute("listaCanal", listaCanal);

	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCandidato(@Valid @ModelAttribute("candidatoBean") CandidatoBean candidatoBean,
			BindingResult result, @RequestParam("file") MultipartFile file, Model model) throws BusinessException {
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
		}
		candidatoBusiness.inserir(candidatoBean);

		return "candidato/cadastrar-candidato";
	}

	private String uploadCurriculo(MultipartFile file, String cpf) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				File dir = new File("curriculo" + File.separator + cpf);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(
						dir.getAbsolutePath() + File.separator + "Curriculo_" + cpf + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return serverFile.getAbsolutePath();
			} catch (Exception e) {
				return "";
			}
		} else {
			return "";
		}
	}

	@RequestMapping(value = "/historico/{id}", method = RequestMethod.GET)
	public String historicoCandidato(Model model, @PathVariable Integer id) {
		CandidatoBean candidato = candidatoBusiness.obter(id);
		obterDominiosCandidato(model);
		model.addAttribute("candidato", candidato);

		return "candidato/historico-candidato";
	}

	@RequestMapping(value = "consultar", method = RequestMethod.GET)
	public String consultarCandidatoRH(Model model) {
		List<CandidatoBean> candidatos = candidatoBusiness.listarTop10();
		model.addAttribute("candidatos", candidatos);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.findAll();
		model.addAttribute("listaFuncionarios", listaFuncionarios);

		List<VagaBean> listaVagaDrop = vagaBusiness.obterTodos();
		model.addAttribute("listaVagaDrop", listaVagaDrop);

		// avaliadorBusiness.listar();

		return "candidato/consultar-candidato";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrarCandidatoRH(Model model, CandidatoBean candidato) {
		if (candidato.getVagaBean().getId() == 0) {
			candidato.setVagaBean(null);
		}

		List<CandidatoBean> candidatos = candidatoBusiness.filtroCandidato(candidato);
		model.addAttribute("candidatos", candidatos);

		List<VagaBean> listaVaga = vagaBusiness.listar();
		model.addAttribute("listaVaga", listaVaga);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.findAll();
		model.addAttribute("listaFuncionarios", listaFuncionarios);

		List<VagaBean> listaVagaDrop = vagaBusiness.obterTodos();
		model.addAttribute("listaVagaDrop", listaVagaDrop);

		// avaliadorBusiness.listar();

		return "candidato/consultar-candidato";
	}

	// andre
	@RequestMapping(value = "aprovar", method = RequestMethod.GET)
	public String aprovarCandidato(Model model) {

		List<CandidatoBean> candidatos = candidatoBusiness.listarAprovacao();
		List<CompetenciaBean> competencias = candidatoBusiness.listarCompetencia();
		List<AvaliacaoBean> avaliacoes = candidatoBusiness.listarAvaliacao();
		List<ProvaBean> provas = provaBusiness.listarProva();

		model.addAttribute("candidatos", candidatos);
		model.addAttribute("competencias", competencias);
		model.addAttribute("avaliacoes", avaliacoes);
		model.addAttribute("provas", provas);

		return "candidato/aprovar-candidato";
	}

	@RequestMapping(value = { "gerenciar" }, method = RequestMethod.GET)
	public @ResponseBody CandidatoBean gerenciarAjax(Model model, @ModelAttribute("id") Integer id) {
		CandidatoBean candidato = new CandidatoBean();
		candidato = candidatoBusiness.obterCandidatoPorId(id);
		return candidato;
	}

	private List<String> buildErrorMessage(List<FieldError> error) {
		List<String> novosErros = new ArrayList<>();

		for (FieldError erros : error) {
			novosErros.add(erros.getDefaultMessage());

		}

		return novosErros;
	}

	@RequestMapping(value = { "alterar-status-candidato" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String alterarStatusCandidato(Model model,
			@ModelAttribute("situacaoCandidato") SituacaoCandidatoBean situacaoCandidato,
			@ModelAttribute("avaliacoesCompetencias") ArrayList<CandidatoCompetenciaBean> avaliacoesCompetencias, 
			@ModelAttribute("processoSeletivo") ProvaCandidatoBean processoSeletivo,
			@ModelAttribute("nome1") String nome1,
			@ModelAttribute("nome2") String nome2,
			@ModelAttribute("nome3") String nome3,
			@ModelAttribute("descricao1") String descricao1,
			@ModelAttribute("descricao2") String descricao2,
			@ModelAttribute("descricao3") String descricao3,
			@ModelAttribute("parecerTecnico") String parecerTecnico)
	{
		ProvaCandidatoBean provaCandidato = new ProvaCandidatoBean();
		CandidatoBean bean = new CandidatoBean();
		bean.setId(situacaoCandidato.getIdCandidato());
		provaCandidato.setCandidato(bean);
		provaCandidato.setNome1(nome1);
		provaCandidato.setNome2(nome2);
		provaCandidato.setNome3(nome3);
		provaCandidato.setDescricao1(descricao1);
		provaCandidato.setDescricao2(descricao2);
		provaCandidato.setDescricao3(descricao3);
		provaCandidato.setParecerTecnico(parecerTecnico);
		
		provaCandidatoBusiness.inserir(provaCandidato);
		
		candidatoBusiness.alterarStatus(situacaoCandidato);
		return "candidato/aprovar";
	}
}

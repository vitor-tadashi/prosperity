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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

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
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.exception.BusinessException;

@SuppressWarnings("unused")
@Controller
@RequestMapping(value = "candidato")
public class CandidatoController<PaginarCandidato> {

	@Autowired
	private CandidatoBean bean;

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

	@Autowired
	private List<CandidatoCompetenciaBean> candidatoCompetenciasBean;

	@Autowired
	private CompetenciaBean competenciaBean;

	@Autowired
	private AvaliacaoBean avaliacaoBean;
	
	@Autowired
	private ProvaCandidatoBean provaCandidatoBean;

	@Autowired
	private List<ProvaCandidatoBean> provasCandidatoBean;

	@Autowired
	private ProvaBean provaBean;
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
			try {
				candidatoBusiness.inserir(candidatoBean);
				model.addAttribute("sucesso", "Candidato salvo com sucesso.");

			} catch (BusinessException e) {

			}
		}

		return "candidato/cadastrar-candidato";
	}

	@RequestMapping(value = "/cancelar-candidato/{id}")
	public String cancelaCandidato(@PathVariable Integer id) {
		SituacaoCandidatoBean bean = new SituacaoCandidatoBean();
		bean.setIdCandidato(id);
		bean.setStatus(StatusCandidatoEnum.CANCELADO);
		candidatoBusiness.alterarStatus(bean);

		return "redirect:/candidato/aprovar";
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String solicitarCandidato(Model model, @PathVariable Integer id) {
		CandidatoBean candidato = candidatoBusiness.obterCandidatoPorId(id);
		obterDominiosCandidato(model);
		model.addAttribute("candidato", candidato);

		return "candidato/cadastrar-candidato";
	}

	@RequestMapping(value = "obter", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CandidatoBean obterCPF(Model model, @RequestParam String cpf) {
		CandidatoBean candidato = candidatoBusiness.obterPorCPF(cpf);
		return candidato;
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

		// LISTAR VAGA ATIVA
		List<VagaBean> listaVagaDrop = vagaBusiness.listarVagasAtivas();
		model.addAttribute("listaVagaDrop", listaVagaDrop);

		// avaliadorBusiness.listar();

		return "candidato/consultar-candidato";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrarCandidatoRH(Model model, CandidatoBean candidato, RedirectAttributes redirectAttributes) {
		if (candidato.getVagaBean().getId() == 0) {
			candidato.setVagaBean(null);
		}
		
		
		List<CandidatoBean> candidatos = candidatoBusiness.filtroCandidato(candidato);
		model.addAttribute("candidatos", candidatos);

		List<VagaBean> listaVaga = vagaBusiness.listar();
		model.addAttribute("listaVaga", listaVaga);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		// TABELA VAGA DECRESCENTE
		model.addAttribute("candidato", candidatoBusiness.listarDecrescente());

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
			@ModelAttribute("ac") String ac, @ModelAttribute("processoSelectivo") String processoSeletivo) {
		bean = candidatoBusiness.obter(situacaoCandidato.getIdCandidato());
		if (!ac.equals("[]")) {
			bean.setCompetencias(convertGson(ac));
			try{
			candidatoBusiness.inserir(bean);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		if (!processoSeletivo.equals("[]")) {
			provaCandidatoBusiness.inserir(convertGsonProva(processoSeletivo, bean));
		}
		candidatoBusiness.alterarStatus(situacaoCandidato);
		return "candidato/aprovar";
	}

	@RequestMapping(value = { "buscar/{id}" }, method = RequestMethod.GET)
	public @ResponseBody CandidatoBean buscarPorId(@PathVariable int id) {
		CandidatoBean candidato = candidatoBusiness.obter(id);
		return candidato;
	}

	public List<CandidatoCompetenciaBean> convertGson(String ac) {
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		List<String> l = gson.fromJson(ac, List.class);
		candidatoCompetenciasBean = new ArrayList<CandidatoCompetenciaBean>();
		int aux = 0;
		for (String lista : l) {
			Integer aux2 = Integer.parseInt(lista);
			CandidatoCompetenciaBean candidatoCompetenciaBean = new CandidatoCompetenciaBean();
			try {
				if (aux2 != null) {
					if (aux % 2 == 0) {
						avaliacaoBean = new AvaliacaoBean();
						avaliacaoBean.setId(aux2);
					} else {
						competenciaBean = new CompetenciaBean();
						competenciaBean.setId(aux2);
						candidatoCompetenciaBean.setAvaliacao(avaliacaoBean);
						candidatoCompetenciaBean.setCompetencia(competenciaBean);
						candidatoCompetenciasBean.add(candidatoCompetenciaBean);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			aux++;
		}
		return candidatoCompetenciasBean;
	}

	public List<ProvaCandidatoBean> convertGsonProva(String processoSeletivo, CandidatoBean bean) {
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		List<String> l = gson.fromJson(processoSeletivo, List.class);
		provasCandidatoBean = new ArrayList<ProvaCandidatoBean>();
		List<String> descricao = new ArrayList<String>();
		int aux = 0;
		for (String lista : l) {
			String aux2 = lista;
			try {
				if (aux2 != null) {
					if (aux % 2 == 0) {
						provaBean = new ProvaBean();
						provaBean.setId(Integer.parseInt(aux2));
					} else {
						String dsProva = aux2;
						provaCandidatoBean = new ProvaCandidatoBean();
						provaCandidatoBean.setProvas(provaBean);
						provaCandidatoBean.setDescricao(dsProva);
						provaCandidatoBean.setCandidato(bean);
						provasCandidatoBean.add(provaCandidatoBean);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			aux++;
		}
		return provasCandidatoBean;
	}
}

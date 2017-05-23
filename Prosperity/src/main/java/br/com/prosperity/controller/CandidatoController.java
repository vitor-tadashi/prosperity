package br.com.prosperity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.bean.CanalInformacaoBean;
import br.com.prosperity.bean.CancelamentoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CandidatoCompetenciaBean;
import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.bean.ComunicacaoBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.PropostaBean;
import br.com.prosperity.bean.ProvaBean;
import br.com.prosperity.bean.ProvaCandidatoBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.StatusBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.CanalInformacaoBusiness;
import br.com.prosperity.business.CancelamentoBusiness;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.business.CandidatoCompetenciaBusiness;
import br.com.prosperity.business.CargoBusiness;
import br.com.prosperity.business.ComunicacaoBusiness;
import br.com.prosperity.business.FuncionarioBusiness;
import br.com.prosperity.business.PropostaBusiness;
import br.com.prosperity.business.ProvaBusiness;
import br.com.prosperity.business.ProvaCandidatoBusiness;
import br.com.prosperity.business.SenioridadeBusiness;
import br.com.prosperity.business.SituacaoAtualBusiness;
import br.com.prosperity.business.StatusBusiness;
import br.com.prosperity.business.TipoCursoBusiness;
import br.com.prosperity.business.VagaBusiness;
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.exception.BusinessException;
import br.com.prosperity.util.ImportarExcel;

@Controller
@RequestMapping(value = "/candidato")
public class CandidatoController<PaginarCandidato> {

	@Autowired
	private CandidatoBean candidatoBean;

	@Autowired
	private CancelamentoBusiness cancelamentoBusiness;

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
	private StatusBusiness statusBusiness;

	@Autowired
	private AvaliacaoBean avaliacaoBean;

	@Autowired
	private ProvaCandidatoBean provaCandidatoBean;

	@Autowired
	private List<ProvaCandidatoBean> provasCandidatoBean;

	@Autowired
	private List<ComunicacaoBean> comunicacoesBean;

	@Autowired
	private ProvaBean provaBean;

	@Autowired
	private PropostaBean propostaBean;

	@Autowired
	private PropostaBusiness propostaBusiness;

	@Autowired
	private HttpSession session;

	@Autowired
	private ComunicacaoBean comunicacaoBean;

	@Autowired
	private ComunicacaoBusiness comunicacaoBusiness;

	@Autowired
	private CandidatoCompetenciaBusiness candidatoCompetenciaBusiness;

	private List<String> caminhoProvas;

	private void paginacao(Integer page, Model model, CandidatoBean candidato) {
		Integer startpage = 1;
		Integer endpage = candidatoBusiness.totalPagina(candidato);

		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("page", page);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato(Model model) {
		obterDominiosCandidato(model);

		return "candidato/cadastrar-candidato";
	}

	private void obterDominiosCandidato(Model model) {
		List<FuncionarioBean> funcionarios = funcionarioBusiness.findAll();
		model.addAttribute("listaFuncionarios", funcionarios);

		List<TipoCursoBean> tiposCurso = tipoCursoBusiness.obterTodos();
		model.addAttribute("tiposCurso", tiposCurso);

		List<SituacaoAtualBean> listaSituacaoAtual = situacaoAtualBusiness.obterTodos();
		model.addAttribute("listaSituacaoAtual", listaSituacaoAtual);

		List<VagaBean> listaVaga = vagaBusiness.listarVagasAtivas();
		model.addAttribute("listaVaga", listaVaga);

		List<CanalInformacaoBean> listaCanal = canalInformacaoBusiness.obterTodos();
		model.addAttribute("listaCanal", listaCanal);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvarCandidato(@Valid @ModelAttribute("candidatoBean") CandidatoBean candidatoBean,
			BindingResult result, @RequestParam("file") MultipartFile file, Model model,
			RedirectAttributes redirectAttrs) throws BusinessException {
		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("candidato", candidatoBean);
			obterDominiosCandidato(model);
			return "candidato/cadastrar-candidato";
		} else {
			try {
				String caminho = uploadCurriculo(file, candidatoBean.getCpf());
				candidatoBean.setCurriculo(caminho);
				candidatoBusiness.inserir(candidatoBean);
				redirectAttrs.addFlashAttribute("sucesso", "Candidato salvo com sucesso!");
			} catch (BusinessException e) {
			}
		}
		return "redirect:/candidato/cadastrar";
	}

	@RequestMapping(value = "/cancelar-candidato/{id}")
	public String cancelaCandidato(@PathVariable Integer id, Model model) {
		SituacaoCandidatoBean bean = new SituacaoCandidatoBean();
		bean.setIdCandidato(id);
		bean.setStatus(StatusCandidatoEnum.CANCELADO);
		candidatoBusiness.alterarStatus(bean);
		return "redirect:/candidato/aprovar";
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public String solicitarCandidato(Model model, @PathVariable Integer id) {
		CandidatoBean candidato = candidatoBusiness.obterCandidatoPorId(id);
		List<ComunicacaoBean> comunicacaoBean = comunicacaoBusiness.listarDataComunicacao(id);
		obterDominiosCandidato(model);

		BigDecimal b = new BigDecimal(candidato.getValorPretensao().toString());
		b = b.setScale(2, BigDecimal.ROUND_DOWN);
		candidato.setValorPretensao(b);

		boolean podeEditarVaga = candidatoBusiness.podeEditarVaga(candidato.getUltimoStatus());
		model.addAttribute("candidato", candidato);
		model.addAttribute("podeEditarVaga", podeEditarVaga);
		model.addAttribute("datasComunicacao", comunicacaoBean);

		return "candidato/cadastrar-candidato";
	}

	@RequestMapping(value = "/obter", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody CandidatoBean obterCPF(Model model, @RequestParam String cpf) {
		CandidatoBean candidato = candidatoBusiness.obterPorCPF(cpf);
		return candidato;
	}

	@RequestMapping(value = "/editar/salvar", method = RequestMethod.POST)
	public String salvarEditar(@ModelAttribute("candidatoBean") @Valid CandidatoBean candidatoBean,
			BindingResult result, Model model, RedirectAttributes redirectAttrs) throws BusinessException {
		if (result.hasErrors()) {
			model.addAttribute("erro", result.getErrorCount());
			model.addAttribute("listaErros", buildErrorMessage(result.getFieldErrors()));
			model.addAttribute("candidato", candidatoBean);

			obterDominiosCandidato(model);
			return "candidato/cadastrar-candidato";
		}
		candidatoBusiness.inserir(candidatoBean);
		redirectAttrs.addFlashAttribute("sucesso", "Candidato salvo com sucesso!");

		return "redirect:/candidato/cadastrar";
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
		List<ComunicacaoBean> datasContatos = comunicacaoBusiness.listarDataComunicacao(id);
		List<ProvaCandidatoBean> provasCandidatoBean = provaCandidatoBusiness.obterProva(id);
		// Pega quantas competencias o candidato tem, divide por 7 para ver
		// quantas colunas deve ter na tela;
		int colCompetencias = candidato.getCompetencias().size() / 7;

		model.addAttribute("datasContatos", datasContatos);
		model.addAttribute("colCompetencias", colCompetencias);
		model.addAttribute("provas", provasCandidatoBean);
		model.addAttribute("candidato", candidato);
		// model.addAttribute("provasCandidato",provasCandidatoBean);

		return "candidato/historico-candidato";
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String consultarCandidatoRH(@RequestParam(value = "page", required = false) Integer page, Model model,
			CandidatoBean candidato) {
		if (page == null) {
			page = 1;
		}
		List<CandidatoBean> candidatos = candidatoBusiness.filtroCandidato(candidato, page);
		// Paginando
		paginacao(page, model, candidato);

		model.addAttribute("candidatos", candidatos);

		List<CargoBean> listaCargo = cargoBusiness.obterTodos();
		model.addAttribute("listaCargo", listaCargo);

		List<SenioridadeBean> listaSenioridade = senioridadeBusiness.obterTodos();
		model.addAttribute("listaSenioridade", listaSenioridade);

		List<FuncionarioBean> listaFuncionarios = funcionarioBusiness.findAll();
		model.addAttribute("listaFuncionarios", listaFuncionarios);

		List<StatusBean> listaStatusDrop = statusBusiness.obterStatusVaga();
		model.addAttribute("listaStatusDrop", listaStatusDrop);

		// LISTAR VAGA ATIVA
		List<VagaBean> listaVagaDrop = vagaBusiness.listar();
		model.addAttribute("listaVagaDrop", listaVagaDrop);

		return "candidato/consultar-candidato";
	}

	@RequestMapping(value = "/filtrar", method = RequestMethod.GET)
	public String filtrarCandidatoRH(@RequestParam(value = "page", required = false) Integer page, Model model,
			CandidatoBean candidato, RedirectAttributes redirectAttributes) {
		if (page == null) {
			page = 1;
		}
		if (candidato.getVagaBean().getId() == 0) {
			candidato.setVagaBean(null);
		}
		paginacao(page, model, candidato);
		List<CandidatoBean> candidatos = candidatoBusiness.filtroCandidato(candidato, page);
		model.addAttribute("candidatos", candidatos);

		model.addAttribute("filtroC", candidato);

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

		List<VagaBean> listaVagaDrop = vagaBusiness.listar();
		model.addAttribute("listaVagaDrop", listaVagaDrop);

		return "candidato/consultar-candidato";
	}

	// andre
	@RequestMapping(value = "/aprovar", method = RequestMethod.GET)
	public String aprovarCandidato(Model model) {
		List<CandidatoBean> candidatos = candidatoBusiness.listarAprovacao();
		List<CompetenciaBean> competencias = candidatoBusiness.listarCompetencia();
		List<AvaliacaoBean> avaliacoes = candidatoBusiness.listarAvaliacao();
		List<ProvaBean> provas = provaBusiness.listarProva();
		List<CancelamentoBean> cancelamento = cancelamentoBusiness.listar();
		model.addAttribute("candidatos", candidatos);
		model.addAttribute("competencias", competencias);
		model.addAttribute("avaliacoes", avaliacoes);
		model.addAttribute("provas", provas);
		model.addAttribute("cancelamento", cancelamento);

		return "candidato/aprovar-candidato";
	}

	@RequestMapping(value = { "/gerenciar" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/alterar-status-candidato" }, method = RequestMethod.POST)
	public @ResponseBody CandidatoBean alterarStatusCandidato(Model model,
			@ModelAttribute("situacaoCandidato") SituacaoCandidatoBean situacaoCandidato,
			@ModelAttribute("avaliacoesCandidato") String avaliacoesCandidato,
			@ModelAttribute("processoSeletivo") String processoSeletivo) {
		candidatoBean = candidatoBusiness.obter(situacaoCandidato.getIdCandidato());

		if (!processoSeletivo.equals("[]")) {
			List<ProvaCandidatoBean> provas = convertGsonProva(processoSeletivo, candidatoBean);
			if (caminhoProvas != null) {
				for (int i = 0; i < caminhoProvas.size(); i++) {
					provas.get(i).setCaminhoProva(caminhoProvas.get(i));
				}
			}
			provaCandidatoBusiness.inserir(provas);
		}

		if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANDIDATOAPROVADO.getValue()
				|| situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANDIDATOREPROVADO.getValue()) {
			candidatoCompetenciaBusiness.inserirCompetencias(convertGson(avaliacoesCandidato),
					situacaoCandidato.getIdCandidato());
		}

		if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.PROPOSTACANDIDATO.getValue()) {
			propostaBean.setFlSituacao(true);
			propostaBean.setCandidato(candidatoBean.getId());
			propostaBusiness.inserir(propostaBean);
		}
		try {
			candidatoBusiness.alterarStatus(situacaoCandidato);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Tive de fazer essa busca novamente, para buscar o novo Ultimo Status
		// do cara após ter sido alterado ali ^
		candidatoBean = candidatoBusiness.obter(situacaoCandidato.getIdCandidato());
		return candidatoBean;
	}

	@RequestMapping(value = { "/buscar/{id}" }, method = RequestMethod.GET)
	public @ResponseBody CandidatoBean buscarPorId(@PathVariable int id) {
		CandidatoBean candidato = candidatoBusiness.obter(id);
		return candidato;
	}

	public List<CandidatoCompetenciaBean> convertGson(String ac) {
		Gson gson = new Gson();
		UsuarioBean usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
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
						candidatoCompetenciaBean.setNmAvaliador(usuarioBean.getFuncionario().getNome());
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
		@SuppressWarnings("unused")
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
				} else if (aux % 2 != 0) {
					provaCandidatoBean = new ProvaCandidatoBean();
					provaCandidatoBean.setProvas(provaBean);
					provaCandidatoBean.setCandidato(bean);
					provasCandidatoBean.add(provaCandidatoBean);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			aux++;
		}
		return provasCandidatoBean;
	}

	@RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void getFile(@PathVariable Integer id, HttpServletResponse response) {
		String caminho = candidatoBusiness.obter(id).getCurriculo();
		try {
			File file = new File(caminho);
			response.addHeader("Content-Disposition", "attachment; filename=" + caminho);
			InputStream is = new FileInputStream(file);
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();

			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/papers", method = RequestMethod.GET)
	public void getPapers(String caminho, HttpServletResponse response) {
		String[] nome = caminho.split("\\\\");
		try {
			File file = new File(caminho);
			response.addHeader("Content-Disposition", "attachment; filename=" + nome[5]);
			InputStream is = new FileInputStream(file);
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();

			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "submitFiles", method = RequestMethod.POST)
	public String submitPapers(MultipartHttpServletRequest request, String idCandidato) {
		List<MultipartFile> papers = request.getFiles("papers");
		try {
			saveFilesToServer(papers, idCandidato);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	public void saveFilesToServer(List<MultipartFile> multipartFiles, String idCandidato) throws IOException {
		caminhoProvas = new ArrayList<>();

		String directory = "/home/user/uploadedFilesDir/" + idCandidato + "/";
		File file = new File(directory);
		file.mkdirs();
		for (MultipartFile multipartFile : multipartFiles) {
			file = new File(directory + multipartFile.getOriginalFilename());
			IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));

			caminhoProvas.add(file.getAbsolutePath());
		}
	}

	@ResponseBody
	@PostMapping(value = "gerar-proposta")
	public String gerarProposta(MultipartHttpServletRequest request, Integer idCandidato, Model model) {
		List<MultipartFile> papers = request.getFiles("file");
		try {
			String caminho = gerarProposta(papers, idCandidato);
			ImportarExcel importarExcel = new ImportarExcel();
			propostaBean = new PropostaBean();
			propostaBean = importarExcel.importarExcel(caminho);
			propostaBean.setCmProposta(caminho);
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	public String gerarProposta(List<MultipartFile> multipartFiles, Integer idCandidato) throws IOException {
		String arquivo = null;
		String directory = "/home/user/uploadedFilesDir/" + idCandidato + "/";
		File file = new File(directory);
		file.mkdirs();
		for (MultipartFile multipartFile : multipartFiles) {
			file = new File(directory + multipartFile.getOriginalFilename());
			IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
			arquivo = directory + multipartFile.getOriginalFilename();
		}
		return arquivo;
	}

	@RequestMapping(value = "/proposta", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody PropostaBean returnProposta(Model model) {
		return propostaBean;
	}

	@RequestMapping(value = "/comunicacao", method = RequestMethod.POST)
	public @ResponseBody List<ComunicacaoBean> comunicacao(Model model,
			@ModelAttribute("dataContato") String dataContato, @ModelAttribute("observacao") String observacao,
			@ModelAttribute("usuario") Integer usuario, @ModelAttribute("candidato") Integer candidato) {
		comunicacaoBean = new ComunicacaoBean();

		Date data = new Date();
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			data = formato.parse(dataContato);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setId(usuario);
		comunicacaoBean.setUsuarioBean(usuarioBean);
		comunicacaoBean.setDataContato(data);
		comunicacaoBean.setObservacao(observacao);

		CandidatoBean candidatoBean = new CandidatoBean();
		candidatoBean.setId(candidato);
		comunicacaoBean.setCandidatoBean(candidatoBean);

		candidatoBusiness.inserirComunicacao(comunicacaoBean);

		return comunicacoesBean;
	}
}
package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.AvaliacaoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.AvaliacaoConverter;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.converter.CompetenciaConverter;
import br.com.prosperity.dao.AvaliacaoDAO;
import br.com.prosperity.dao.AvaliadorCandidatoDAO;
import br.com.prosperity.dao.AvaliadorVagaDAO;
import br.com.prosperity.dao.CanalInformacaoDAO;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.dao.CompetenciaDAO;
import br.com.prosperity.dao.SituacaoAtualDAO;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusFuturoDAO;
import br.com.prosperity.dao.TipoCursoDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliacaoEntity;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;
import br.com.prosperity.entity.AvaliadorVagaEntity;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.CompetenciaEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusFuturoEntity;
import br.com.prosperity.entity.VagaCandidatoEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.util.FormatUtil;
import br.com.prosperity.util.GeradorEmail;

@SuppressWarnings("unused")
@Component
public class CandidatoBusiness {

	@Autowired
	private CandidatoBean candidatoBean;

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private CandidatoConverter candidatoConverter;

	@Autowired
	private StatusCandidatoDAO statusCandidatoDAO;

	@Autowired
	private CompetenciaConverter competenciaConverter;

	@Autowired
	private CompetenciaDAO competenciaDAO;

	@Autowired
	private AvaliacaoDAO avaliacaoDAO;

	@Autowired
	private AvaliacaoConverter avaliacaoConverter;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	CanalInformacaoDAO canalInformacaoDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private TipoCursoDAO tipoCursoDAO;

	@Autowired
	private SituacaoAtualDAO situacaoAtualDAO;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusFuturoDAO statusFuturoDAO;

	@Autowired
	private AvaliadorCandidatoDAO avaliadorCandidatoDAO;

	@Autowired
	private AvaliadorVagaDAO avaliadorVagaDAO;

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	private HttpSession session;

	@Transactional(readOnly = true)
	public List<CandidatoBean> listarDecrescente() {
		List<CandidatoEntity> CandidatoEntity = candidatoDAO.findByNamedQuery("obterPorDesc");
		List<CandidatoBean> CandidatoBean = candidatoConverter.convertEntityToBean(CandidatoEntity);
		return CandidatoBean;
	}

	@Transactional
	public CandidatoBean obter(Integer id) {
		CandidatoEntity candidatoEntity = candidatoDAO.findById(id);
		CandidatoBean candidatoBean = new CandidatoBean();

		if (candidatoEntity != null) {
			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
			candidatoBean = FormatUtil.formatCPF(candidatoBean);
			candidatoBean = FormatUtil.formatRG(candidatoBean);
			candidatoBean.setContato(FormatUtil.formatPhone(candidatoBean.getContato()));
		}

		Map<String, List<StatusCandidatoBean>> listaStatusOrdenada = groupByOrdered(candidatoBean.getStatus(),
				StatusCandidatoBean::getMesAno);

		candidatoBean.setStatusPorMesAno(listaStatusOrdenada);

		return candidatoBean;
	}

	@Transactional
	public List<CandidatoBean> obterFiltro(CandidatoBean candidato) {
		List<CandidatoEntity> candidatos = candidatoDAO.findByNamedQuery("pesquisarNome",
				"%" + candidato.getNome() + "%", candidato.getPretensaoDe(), candidato.getPretensaoPara(),
				candidato.getDataAberturaDe(), candidato.getDataAberturaPara());
		List<CandidatoBean> candidatoBean = candidatoConverter.convertEntityToBean(candidatos);
		return candidatoBean;
	}

	private static <K, V> Map<K, List<V>> groupByOrdered(List<V> list, Function<V, K> keyFunction) {
		return list.stream().collect(Collectors.groupingBy(keyFunction, LinkedHashMap::new, Collectors.toList()));
	}

	@Transactional
	public List<CandidatoBean> listarTop10() {
		List<Criterion> criterions = new ArrayList<>();
		List<CandidatoEntity> candidato = candidatoDAO.findByCriteria(criterions);
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(candidato);
		return beans;
	}

	@Transactional
	public List<CandidatoBean> listar() {
		List<CandidatoEntity> candidato = candidatoDAO.findByNamedQuery("verificarCandidatura");
		List<CandidatoEntity> entities = candidatoDAO.findAll();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);

		return beans;
	}

	@Transactional
	public List<CompetenciaBean> listarCompetencia() {
		List<CompetenciaEntity> entities = competenciaDAO.findAll();
		List<CompetenciaBean> beans = competenciaConverter.convertEntityToBean(entities);

		return beans;
	}

	@Transactional
	public List<AvaliacaoBean> listarAvaliacao() {
		List<AvaliacaoEntity> entities = avaliacaoDAO.findAll();
		List<AvaliacaoBean> beans = avaliacaoConverter.convertEntityToBean(entities);

		return beans;
	}

	@Transactional
	public List<CandidatoBean> filtroCandidato(CandidatoBean candidato) {

		// Integer idStatus = 0;
		/*
		 * if (!vaga.getStatus().get(0).getStatus().getNome().equals("")) {
		 * idStatus =
		 * Integer.parseInt(vaga.getStatus().get(0).getStatus().getNome()); }
		 */
		///////////////////////////////
		Integer idVaga = 0;/*
							 * if(candidato.getVagaCandidato().getVaga().getId()
							 * != null) { idVaga =
							 * candidato.getVagaCandidato().getVaga().getId(); }
							 */

		// List<CandidatoEntity> candidatos =
		// candidatoDAO.findByNamedQuery("filtrarVaga", idVaga);

		List<Criterion> criterions = new ArrayList<>();

		// VagaBean vaga = (VagaBean) candidato.getVagas().iterator().next();

		if (candidato.getVagaBean() != null) {
			criterions.add(Restrictions.eq("vaga.vaga.id", candidato.getVagaBean().getId()));
		}

		if (!candidato.getNome().isEmpty() || candidato.getNome() != null) {
			criterions.add(Restrictions.like("nome", "%" + candidato.getNome() + "%"));
		}

		if (candidato.getDataAberturaDe() != null && candidato.getDataAberturaPara() != null) {
			criterions.add(Restrictions.between("dataAbertura", parseData(candidato.getDataAberturaDe()),
					parseData(candidato.getDataAberturaPara())));
		}

		if (candidato.getPretensaoDe() != null && candidato.getPretensaoPara() != null) {
			criterions.add(Restrictions.between("valorPretensaoSalarial", candidato.getPretensaoDe(),
					candidato.getPretensaoPara()));
		}

		if (idVaga != 0) {
			criterions.add(Restrictions.like("ultimaVaga.nomeVaga", "%" + idVaga + "%"));
		}

		List<CandidatoEntity> candidatos = candidatoDAO.findByCriteria(criterions);
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(candidatos);
		return beans;

	}

	@Transactional
	public void inserir(CandidatoBean candidatoBean) {
		if (candidatoBean.getId() == null) {
			if (verificarCandidatura(candidatoBean) == true) {
				CandidatoEntity candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoBean);

				SituacaoCandidatoBean situacaoCandidato = new SituacaoCandidatoBean();

				candidatoEntity.getFormacao()
						.setTipoCurso(tipoCursoDAO.findById(candidatoBean.getFormacao().getTipoCurso().getId()));
				candidatoEntity.getFormacao().setSituacaoAtual(
						situacaoAtualDAO.findById(candidatoBean.getFormacao().getSituacaoAtual().getId()));

				Set<VagaCandidatoEntity> vagas = new HashSet<>();
				for (VagaCandidatoEntity v : candidatoEntity.getVagas()) {
					v.setVaga(vagaDAO.findById(candidatoBean.getVagaCandidato().getVaga().getId()));
					v.setCanalInformacao(
							canalInformacaoDAO.findById(candidatoBean.getVagaCandidato().getCanalInformacao().getId()));

				}
				if (vagas.isEmpty() || vagas.size() == 0 || vagas == null) {
					VagaCandidatoEntity novoVagaCandidato = new VagaCandidatoEntity();

					novoVagaCandidato.setVaga(vagaDAO.findById(candidatoBean.getVagaCandidato().getVaga().getId()));
					if (candidatoBean.getVagaCandidato().getCanalInformacao().getId() != null)
						novoVagaCandidato.setCanalInformacao(canalInformacaoDAO
								.findById(candidatoBean.getVagaCandidato().getCanalInformacao().getId()));

					vagas.add(novoVagaCandidato);
				}
				candidatoEntity.setVagas(vagas);

				candidatoDAO.insert(candidatoEntity);

				List<VagaCandidatoEntity> vagao = new ArrayList<VagaCandidatoEntity>();
				for (VagaCandidatoEntity vaguinhas : vagas) {
					vagao.add(vaguinhas);
				}

				inserirAvaliadores(candidatoEntity, vagao.get(0).getVaga().getId());

				situacaoCandidato.setIdCandidato(candidatoEntity.getId());
				situacaoCandidato.setStatus(StatusCandidatoEnum.CANDIDATURA);

				if (vagao.get(0).getVaga().getId() == 1202)
					situacaoCandidato.setStatus(StatusCandidatoEnum.CANCELADO);

				alterarStatus(situacaoCandidato);

			} else {
				// retornar mensagem de candidato em processo seletivo para vaga
			}

		} else {
			CandidatoEntity candidatoEntity = candidatoDAO.findById(candidatoBean.getId());

			candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoEntity, candidatoBean);

			candidatoDAO.update(candidatoEntity);
		}
	}

	@Transactional
	public CandidatoBean obterCandidatoPorId(Integer id) {
		CandidatoBean bean = candidatoConverter.convertEntityToBean(candidatoDAO.findById(id));
		return bean;
	}

	@Transactional
	private void desativarStatus(CandidatoEntity candidatoEntity) {
		List<StatusCandidatoEntity> status = statusCandidatoDAO.findByNamedQuery("obterStatusCandidato",
				candidatoEntity);
		if (status != null) {
			for (StatusCandidatoEntity statusCand : status) {
				statusCand.setFlSituacao(false);
				statusCandidatoDAO.update(statusCand);
			}
		}
	}

	@Transactional
	public void alterarStatus(SituacaoCandidatoBean situacaoCandidato) {
		StatusCandidatoEntity statusCandidatoEntity = statusAlteracao(situacaoCandidato);
		List<StatusFuturoEntity> statusFuturoEntity = null;
		List<AvaliadorCandidatoEntity> avaliadorCandidatoEntity = null;

		statusCandidatoDAO.insert(statusCandidatoEntity);

		statusFuturoEntity = statusFuturoDAO.findByNamedQuery("obterStatusFuturos",
				situacaoCandidato.getStatus().getValue());

		if (statusFuturoEntity != null && statusFuturoEntity.size() > 0) {
			situacaoCandidato.setParecer(null);

			if (statusFuturoEntity.size() == 1) {
				situacaoCandidato.setStatus(StatusCandidatoEnum.valueOf(statusFuturoEntity.get(0).getIdStatusFuturo()));
			} else {
				avaliadorCandidatoEntity = avaliadorCandidatoDAO.findByNamedQuery("atualizarAvaliador",
						usuarioBean.getId(), statusCandidatoEntity.getCandidato());
				if (avaliadorCandidatoEntity != null && avaliadorCandidatoEntity.size() > 0) {
					StatusCandidatoEnum status = avaliadorCandidatoEntity.size() == 1
							? StatusCandidatoEnum.GERARPROPOSTA : StatusCandidatoEnum.CANDIDATOEMANALISE;

					situacaoCandidato.setStatus(status);
				}
			}
			avaliadorCandidatoEntity.get(0).setStatus(situacaoCandidato.getStatus().getValue());
			avaliadorCandidatoDAO.update(avaliadorCandidatoEntity.get(0));
			statusCandidatoDAO.insert(statusAlteracao(situacaoCandidato));
		}
	}

	@Transactional
	private StatusCandidatoEntity statusAlteracao(SituacaoCandidatoBean situacaoCandidato) {
		StatusCandidatoEntity statusCandidatoEntity = new StatusCandidatoEntity();
		CandidatoEntity candidatoEntity = new CandidatoEntity();
		candidatoEntity.setId(situacaoCandidato.getIdCandidato());

		desativarStatus(candidatoEntity);

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusCandidatoEntity.setStatus(statusDAO.findById(situacaoCandidato.getStatus().getValue()));
		statusCandidatoEntity.setCandidato(candidatoEntity);
		statusCandidatoEntity.setDsParecer(situacaoCandidato.getParecer());
		statusCandidatoEntity.setProposta(situacaoCandidato.getProposta());
		statusCandidatoEntity.setDtAlteracao(new Date());
		if (usuarioBean != null)
			statusCandidatoEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));
		statusCandidatoEntity.setFlSituacao(true);

		return statusCandidatoEntity;
	}
@Transactional
	public CandidatoBean obterPorCPF(String cpf) {
		List<CandidatoEntity> candidatosEntity = null;

		candidatosEntity = candidatoDAO.findByNamedQuery("obterPorCPF", cpf);

		for (CandidatoEntity candidatoEntity : candidatosEntity) {

			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
		}

		return candidatoBean;
	}

	private Boolean verificarCandidatura(CandidatoBean candidato) {

		return candidato.getUltimoStatus().getId() == null ? true : false;

	}

	private Date parseData(Date dataAntiga) {
		SimpleDateFormat novaData = new SimpleDateFormat("yyyy-MM-dd");

		String data = "";
		try {
			data = novaData.format(dataAntiga);
			return novaData.parse(data);
		} catch (ParseException e) {
			e.printStackTrace(); // imprimi a stack trace
		}
		return dataAntiga;

	}

	@Transactional
	private void inserirAvaliadores(CandidatoEntity candidato, Integer idVaga) {
		VagaEntity vaga = vagaDAO.findById(idVaga);
		List<AvaliadorVagaEntity> avaliadoresEntity = avaliadorVagaDAO.findByNamedQuery("obterAvaliadoresDaVaga",
				vaga.getId());
		if (avaliadoresEntity != null && avaliadoresEntity.size() > 0)
			for (AvaliadorVagaEntity avaliadorVagaEntity : avaliadoresEntity) {
				AvaliadorCandidatoEntity avaliadorCandidatoEnitty = new AvaliadorCandidatoEntity();
				avaliadorCandidatoEnitty.setVaga(avaliadorVagaEntity.getVaga());
				avaliadorCandidatoEnitty.setUsuario(avaliadorVagaEntity.getUsuario());
				avaliadorCandidatoEnitty.setCandidato(candidato);
				avaliadorCandidatoDAO.insert(avaliadorCandidatoEnitty);
			}
	}

	@Transactional
	public List<CandidatoBean> listarAprovacao() {
		List<Integer> listaStatus = obterStatusDisponivelAprovacao();
		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		Integer idStatusCandidatura = 0;

		for (FuncionalidadeBean funcionalidadeBean : usuarioBean.getPerfil().getListaFuncionalidades()) {
			if (funcionalidadeBean.getId() == 27) {
				idStatusCandidatura = StatusCandidatoEnum.CANDIDATURA.getValue();
			}
		}

		List<CandidatoEntity> entities = candidatoDAO.findByNamedQuery("listarAprovacoes", listaStatus,
				StatusCandidatoEnum.CANDIDATOEMANALISE.getValue(), usuarioBean.getId(), idStatusCandidatura);
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);

		return beans;
	}

	/**
	 * Obtêm os status disponíveis para visualização para o usuário logado
	 * 
	 * @return Lista dos id's dos status disponíveis
	 */
	private List<Integer> obterStatusDisponivelAprovacao() {
		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		List<Integer> listaStatus = new ArrayList<Integer>();

		for (FuncionalidadeBean funcionalidadeBean : usuarioBean.getPerfil().getListaFuncionalidades()) {
			if (funcionalidadeBean.getId() == 26)
				listaStatus.add(StatusCandidatoEnum.GERARPROPOSTA.getValue());

			if (funcionalidadeBean.getId() == 25)
				listaStatus.add(StatusCandidatoEnum.PROPOSTACANDIDATO.getValue());

			if (funcionalidadeBean.getId() == 28) {
				listaStatus.add(StatusCandidatoEnum.PROPOSTAACEITA.getValue());
				listaStatus.add(StatusCandidatoEnum.PROPOSTARECUSADA.getValue());
			}
		}
		return listaStatus;	
	}
}

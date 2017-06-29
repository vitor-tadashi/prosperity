package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import br.com.prosperity.bean.AvaliadorCandidatoBean;
import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.CompetenciaBean;
import br.com.prosperity.bean.ComunicacaoBean;
import br.com.prosperity.bean.DataEntrevistaBean;
import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.QuantiaCandidatoPorStatusBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.AvaliacaoConverter;
import br.com.prosperity.converter.AvaliadorCandidatoConverter;
import br.com.prosperity.converter.AvaliadorVagaConverter;
import br.com.prosperity.converter.CancelamentoConverter;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.converter.CompetenciaConverter;
import br.com.prosperity.converter.ComunicacaoConverter;
import br.com.prosperity.converter.DataEntrevistaConverter;
import br.com.prosperity.converter.FuncionarioConverter;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliacaoDAO;
import br.com.prosperity.dao.AvaliadorCandidatoDAO;
import br.com.prosperity.dao.AvaliadorVagaDAO;
import br.com.prosperity.dao.CanalInformacaoDAO;
import br.com.prosperity.dao.CancelamentoDAO;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.dao.CompetenciaDAO;
import br.com.prosperity.dao.ComunicacaoDAO;
import br.com.prosperity.dao.DataEntrevistaDAO;
import br.com.prosperity.dao.FuncionarioDAO;
import br.com.prosperity.dao.PropostaDAO;
import br.com.prosperity.dao.SituacaoAtualDAO;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusDisponivelDAO;
import br.com.prosperity.dao.StatusFuturoDAO;
import br.com.prosperity.dao.TipoCursoDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaCandidatoDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliacaoEntity;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;
import br.com.prosperity.entity.AvaliadorVagaEntity;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.CompetenciaEntity;
import br.com.prosperity.entity.DataEntrevistaEntity;
import br.com.prosperity.entity.FuncionarioEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusDisponivelEntity;
import br.com.prosperity.entity.StatusFuturoEntity;
import br.com.prosperity.entity.VagaCandidatoEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.exception.BusinessException;
import br.com.prosperity.util.FormatUtil;
import br.com.prosperity.util.GeradorEmail;

@SuppressWarnings("unused")
@Component
public class CandidatoBusiness {

	@Autowired
	private CandidatoBean candidatoBean;

	@Autowired
	private CandidatoBean beans;

	@Autowired
	private CandidatoDAO candidatoDAO;

	@Autowired
	private DataEntrevistaDAO dataEntrevistaDAO;

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
	private UsuarioConverter usuarioConverter;

	@Autowired
	private CanalInformacaoDAO canalInformacaoDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private TipoCursoDAO tipoCursoDAO;

	@Autowired
	private SituacaoAtualDAO situacaoAtualDAO;

	@Autowired
	private ComunicacaoDAO comunicacaoDAO;

	@Autowired
	private ComunicacaoConverter comunicacaoConverter;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusFuturoDAO statusFuturoDAO;

	@Autowired
	private AvaliadorCandidatoDAO avaliadorCandidatoDAO;

	@Autowired
	private AvaliadorCandidatoConverter avaliadorCandidatoConverter;

	@Autowired
	private AvaliadorVagaDAO avaliadorVagaDAO;

	@Autowired
	private AvaliadorVagaConverter avaliadorVagaConverter;

	@Autowired
	private VagaConverter vagaConverter;

	@Autowired
	private DataEntrevistaConverter dataEntrevistaConverter;

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	private VagaCandidatoDAO vagaCandidatoDAO;

	@Autowired
	private StatusDisponivelDAO statusDisponivelDAO;

	@Autowired
	private HttpSession session;

	@Autowired
	private UsuarioBusiness usuarioBusiness;

	@Autowired
	private SituacaoCandidatoBean situacaoCandidato;

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private FuncionarioConverter funcionarioConverter;

	@Autowired
	private CancelamentoDAO cancelamentoDAO;

	@Autowired
	private CancelamentoConverter cancelamentoConverter;

	@Autowired
	private PropostaDAO propostaDAO;

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
			candidatoBean.setContato(FormatUtil.formatPhone(candidatoBean.getContato()));
		}
		Collections.sort(candidatoBean.getStatus());
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
	public List<CandidatoBean> filtroCandidato(CandidatoBean candidato, Integer page) {
		List<Criterion> criterions = confFiltro(candidato);

		List<CandidatoEntity> candidatos = candidatoDAO.findByCriteria(page, criterions);
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(candidatos);
		return beans;
	}

	@Transactional
	public void inserir(CandidatoBean candidatoBean) throws BusinessException {
		situacaoCandidato = new SituacaoCandidatoBean();
		beans = new CandidatoBean();
		CandidatoEntity candidatoEntity = new CandidatoEntity();

		// Para inserir candidato:
		if (candidatoBean.getVagaCandidato().getFuncionarioBean() != null) {
			Integer idFuncionario = candidatoBean.getVagaCandidato().getFuncionarioBean().getId();
			FuncionarioEntity funcionarioEntity = funcionarioDAO.findById(idFuncionario);
		}
		VagaCandidatoEntity vagaCandidatoEntity = new VagaCandidatoEntity();

		if (candidatoBean.getId() == null) {
			if (verificarCandidatura(candidatoBean)) {
				candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoBean);
				VagaEntity vagaAtual = definirVagas(candidatoBean, candidatoEntity);

				candidatoEntity.setDataAbertura(new Date());
				definirFormacao(candidatoBean, candidatoEntity);
				tratarInformacoes(candidatoEntity);

				candidatoDAO.insert(candidatoEntity);

				inserirAvaliadores(candidatoEntity, vagaAtual.getId());

				situacaoCandidato.setStatus(StatusCandidatoEnum.CANDIDATURA);
				situacaoCandidato.setIdCandidato(candidatoEntity.getId());
				situacaoCandidato.setNomeVaga(vagaAtual.getNomeVaga());
				situacaoCandidato.setIdVaga(vagaAtual.getId());
				alterarStatus(situacaoCandidato);

			} else {
				// retornar mensagem de candidato em processo seletivo para vaga
			}

		} else {
			candidatoEntity = candidatoDAO.findById(candidatoBean.getId());
			candidatoEntity.setPropostaEntity(propostaDAO.findByNamedQuery("buscarProposta", candidatoEntity.getId()));

			// TODO fazer datas salvar certa quando edita
			beans = candidatoConverter.convertEntityToBean(candidatoEntity);
			if(candidatoBean.getDataEntrevista() == null){
				candidatoBean.setDataEntrevista(beans.getDataEntrevista());
			} else {
				int i = 0;
				for (DataEntrevistaBean dt : beans.getDataEntrevista()) {
					for (DataEntrevistaBean dtTela : candidatoBean.getDataEntrevista()) {
						if (dt.getVaga().getId().equals(dtTela.getVaga().getId())
								&& dt.getUsuario().getId().equals(dtTela.getUsuario().getId())) {
							beans.getDataEntrevista().get(i).setDataEntrevista(dtTela.getDataEntrevista());
						}
					}
					i++;
				}
				candidatoBean.setDataEntrevista(beans.getDataEntrevista());
			}
			if (candidatoBean.getVagaCandidato().getVaga() == null) {
				candidatoBean.getVagaCandidato().setVaga(beans.getUltimaVaga());
			}
			candidatoBean.setPropostaBean(beans.getPropostaBean());
			candidatoBean.setCurriculo(beans.getCurriculo());
			candidatoBean.setCompetencias(beans.getCompetencias());
			candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoEntity, candidatoBean);
			tratarInformacoes(candidatoEntity);
			definirFormacao(candidatoBean, candidatoEntity);

			candidatoDAO.update(candidatoEntity);

			if (candidatoBean.getVagaCandidato().getVaga().getId() != 0) {
				if (!beans.getUltimaVaga().getId().equals(candidatoBean.getVagaCandidato().getVaga().getId())) {
					candidatoEntity.setDataAbertura(new Date());
					// desativarDataEntrevista(candidatoBean);

					VagaEntity vagaAtual = definirVagas(candidatoBean, candidatoEntity);

					desativarAvaliadores(candidatoBean.getId());
					inserirAvaliadores(candidatoEntity, vagaAtual.getId());

					situacaoCandidato.setStatus(StatusCandidatoEnum.CANDIDATURA);
					situacaoCandidato.setIdCandidato(candidatoEntity.getId());
					situacaoCandidato.setNomeVaga(vagaAtual.getNomeVaga());
					situacaoCandidato.setIdVaga(vagaAtual.getId());
					alterarStatus(situacaoCandidato);
				}
			}
		}
	}

	@Transactional
	public void inserirWordpress(CandidatoBean candidatoBean) throws BusinessException {
		CandidatoEntity candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoBean);
		SituacaoCandidatoBean situacaoCandidato = new SituacaoCandidatoBean();
		Date dateNow = new Date();
		candidatoEntity.setDataAbertura(dateNow);

		situacaoCandidato.setStatus(StatusCandidatoEnum.CANCELADO);
		situacaoCandidato.setIdCandidato(candidatoEntity.getId());
		alterarStatus(situacaoCandidato);

		// Verificar se o rapaz já se cadastrou pelo CPF:
		if (candidatoDAO.findByNamedQuery("obterPorCPF", candidatoEntity.getCpf()) == null) {
			definirFormacao(candidatoBean, candidatoEntity);
			VagaEntity vagaAtual = definirVagas(candidatoBean, candidatoEntity);
			tratarInformacoes(candidatoEntity);

			candidatoDAO.insert(candidatoEntity);
		} else {
			// Se sim, fazer nada:
			// Porque ele ficará sempre na VagaWordpress
		}
	}

	private void tratarInformacoes(CandidatoEntity candidatoEntity) {
		String replaceCPF = candidatoEntity.getCpf().replace(".", "").replace("-", "");
		String replaceTelefone = candidatoEntity.getContato().getTelefone().replace("(", "").replace(")", "")
				.replace("-", "");

		candidatoEntity.getContato().setTelefone(replaceTelefone);
		candidatoEntity.setCpf(replaceCPF);
	}

	// Esse método é que está setando informações na tabela VagaCandidato
	// (tbVagaCandidato):

	private VagaEntity definirVagas(CandidatoBean candidatoBean, CandidatoEntity candidatoEntity) {
		// TODO findById not working
		Set<VagaCandidatoEntity> vagas = new HashSet<>();
		for (VagaCandidatoEntity v : candidatoEntity.getVagas()) {
			/*
			 * v.setVaga(vagaDAO.findById(candidatoBean.getVagaCandidato().
			 * getVaga().getId())); v.setCanalInformacao(
			 * canalInformacaoDAO.findById(candidatoBean.getVagaCandidato().
			 * getCanalInformacao().getId()));
			 */
			v.setSituacao(false);
			vagas.add(v);
		}
		VagaCandidatoEntity novoVagaCandidato = new VagaCandidatoEntity();
		VagaEntity vagaEntity = vagaDAO.findById(candidatoBean.getVagaCandidato().getVaga().getId());
		novoVagaCandidato.setVaga(vagaEntity);

		if (candidatoBean.getVagaCandidato().getCanalInformacao().getId() != null) {
			novoVagaCandidato.setCanalInformacao(
					canalInformacaoDAO.findById(candidatoBean.getVagaCandidato().getCanalInformacao().getId()));

			if (candidatoBean.getVagaCandidato().getFuncionarioBean() != null) {
				if (candidatoBean.getVagaCandidato().getFuncionarioBean().getId() != null
						&& candidatoBean.getVagaCandidato().getFuncionarioBean().getId() != 0) {
					novoVagaCandidato.setFuncionarioEntity(
							funcionarioDAO.findById(candidatoBean.getVagaCandidato().getFuncionarioBean().getId()));
				}
				if (candidatoBean.getVagaCandidato().getOutros() != null) {
					novoVagaCandidato.setOutros(candidatoBean.getVagaCandidato().getOutros());
				}
			}
		}
		novoVagaCandidato.setSituacao(true);
		novoVagaCandidato.setCandidato(candidatoEntity);
		vagas.add(novoVagaCandidato);

		candidatoEntity.setVagas(vagas);
		return novoVagaCandidato.getVaga();
	}

	private void definirFormacao(CandidatoBean candidatoBean, CandidatoEntity candidatoEntity) {
		candidatoEntity.getFormacao()
				.setTipoCurso(tipoCursoDAO.findById(candidatoBean.getFormacao().getTipoCurso().getId()));
		candidatoEntity.getFormacao()
				.setSituacaoAtual(situacaoAtualDAO.findById(candidatoBean.getFormacao().getSituacaoAtual().getId()));
	}

	@Transactional
	public CandidatoBean obterCandidatoPorId(Integer id) {
		CandidatoBean bean = candidatoConverter.convertEntityToBean(candidatoDAO.findById(id));

		for (int i = 0; i < bean.getDataEntrevista().size(); i++) {
			if (!bean.getDataEntrevista().get(i).getVaga().getId().equals(bean.getUltimaVaga().getId())) {
				bean.getDataEntrevista().remove(i);
				i--;
			}
		}
		return bean;
	}

	@Transactional
	private void desativarStatus(CandidatoEntity candidatoEntity) {
		List<StatusCandidatoEntity> status = statusCandidatoDAO.findByNamedQuery("desativarStatus",
				candidatoEntity.getId());
		if (status != null) {
			for (StatusCandidatoEntity statusCand : status) {
				statusCand.setFlSituacao(false);
				statusCandidatoDAO.update(statusCand);
			}
		}
	}

	@Transactional(readOnly = true)
	public void alterarStatus(SituacaoCandidatoBean situacaoCandidato) {
		StatusCandidatoEntity statusCandidatoEntity = null;
		List<StatusFuturoEntity> statusFuturoEntity = null;
		List<AvaliadorCandidatoEntity> avaliadorCandidatoEntity = null;
		List<StatusCandidatoEntity> listaStatusCandidato = null;
		listaStatusCandidato = statusCandidatoDAO.findByNamedQuery("obterStatusCandidato",
				situacaoCandidato.getIdCandidato());
		List<StatusDisponivelEntity> listaStatusDisponivelEntity = statusDisponivelDAO.findAll();
		if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANDIDATURA.getValue()) {
			statusCandidatoEntity = statusAlteracao(situacaoCandidato);
			statusCandidatoDAO.insert(statusCandidatoEntity);
		} else if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANCELADO.getValue()
				|| situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.SEMVAGA.getValue()) {
			if (listaStatusCandidato.get(0).getStatus().getId() != situacaoCandidato.getStatus().getValue()) {
				statusCandidatoEntity = statusAlteracao(situacaoCandidato);
				statusCandidatoDAO.insert(statusCandidatoEntity);
			}
		} else {
			if (listaStatusDisponivelEntity != null) {
				for (StatusDisponivelEntity statusDisponivelEntity : listaStatusDisponivelEntity) {
					if (statusDisponivelEntity.getStatus().getId() == listaStatusCandidato.get(0).getStatus().getId()) {
						if (situacaoCandidato.getStatus().getValue() == statusDisponivelEntity
								.getIdStatusDisponivel()) {
							statusCandidatoEntity = statusAlteracao(situacaoCandidato);
							statusCandidatoDAO.insert(statusCandidatoEntity);
							candidatoBean.setId(situacaoCandidato.getIdCandidato());
							if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CONTRATADO.getValue()) {
								List<VagaCandidatoEntity> contratado = vagaCandidatoDAO
										.findByNamedQuery("candidatoContratado", situacaoCandidato.getIdCandidato());
								VagaCandidatoEntity contratados = null;
								for (VagaCandidatoEntity cand : contratado) {
									cand.setContratado(true);
									contratados = cand;
								}
								vagaCandidatoDAO.update(contratados);
							}
						}
					}
				}
			}
		}
		statusFuturoEntity = statusFuturoDAO.findByNamedQuery("obterStatusFuturos",
				situacaoCandidato.getStatus().getValue());

		if (statusFuturoEntity != null && statusFuturoEntity.size() > 0) {
			situacaoCandidato.setParecer(null);

			if (statusFuturoEntity.size() == 1) {
				situacaoCandidato.setStatus(StatusCandidatoEnum.valueOf(statusFuturoEntity.get(0).getIdStatusFuturo()));
			} else {
				avaliadorCandidatoEntity = avaliadorCandidatoDAO.findByNamedQuery("obterAvaliadoresCandidato",
						statusCandidatoEntity.getCandidato());
				if (avaliadorCandidatoEntity != null && avaliadorCandidatoEntity.size() > 0) {
					StatusCandidatoEnum status = avaliadorCandidatoEntity.size() == 1
							? StatusCandidatoEnum.GERARPROPOSTA : StatusCandidatoEnum.CANDIDATOEMANALISE;

					situacaoCandidato.setStatus(status);
				}
			}
			avaliadorCandidatoEntity = avaliadorCandidatoDAO.findByNamedQuery("atualizarAvaliador", usuarioBean.getId(),
					statusCandidatoEntity.getCandidato());
			if (avaliadorCandidatoEntity != null && avaliadorCandidatoEntity.size() > 0) {
				for (int i = 0; i < avaliadorCandidatoEntity.size(); i++) {
					avaliadorCandidatoEntity.get(i).setStatus(situacaoCandidato.getStatus().getValue());
					avaliadorCandidatoDAO.update(avaliadorCandidatoEntity.get(i));
				}
			}
			statusCandidatoDAO.insert(statusAlteracao(situacaoCandidato));
		}
		 buscarUsuariosParaEmail(situacaoCandidato);
	}

	@Transactional
	private StatusCandidatoEntity statusAlteracao(SituacaoCandidatoBean situacaoCandidato) {
		StatusCandidatoEntity statusCandidatoEntity = new StatusCandidatoEntity();
		CandidatoEntity candidatoEntity = new CandidatoEntity();
		candidatoEntity.setId(situacaoCandidato.getIdCandidato());

		desativarStatus(candidatoEntity);

		if (situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANCELADO.getValue()
				|| situacaoCandidato.getStatus().getValue() == StatusCandidatoEnum.CANDIDATOREPROVADO.getValue()) {
			desativarAvaliadores(situacaoCandidato.getIdCandidato());
		}

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusCandidatoEntity.setStatus(statusDAO.findById(situacaoCandidato.getStatus().getValue()));
		statusCandidatoEntity.setCandidato(candidatoEntity);
		statusCandidatoEntity.setDsParecer(situacaoCandidato.getParecer());
		statusCandidatoEntity.setDtAlteracao(new Date());
		if(situacaoCandidato.getStatus().getValue() != StatusCandidatoEnum.SEMVAGA.getValue()){
			statusCandidatoEntity.setIdVaga(situacaoCandidato.getIdVaga());
		}
		if (situacaoCandidato.getNomeVaga() != null && !situacaoCandidato.getNomeVaga().isEmpty()){
			statusCandidatoEntity.setNmVaga(situacaoCandidato.getNomeVaga());
		}
		if (situacaoCandidato.getIdCancelamento() != null) {
			statusCandidatoEntity.setCancelamento(cancelamentoDAO.findById(situacaoCandidato.getIdCancelamento()));
		}
		if (situacaoCandidato.getDsCancelamento() != null) {
			statusCandidatoEntity.setDsCancelamento(situacaoCandidato.getDsCancelamento());
		}
		if (usuarioBean != null)
			statusCandidatoEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));
		statusCandidatoEntity.setFlSituacao(true);

		return statusCandidatoEntity;
	}

	@Transactional
	private void desativarAvaliadores(Integer idCandidato) {
		List<AvaliadorCandidatoEntity> avaliadoresCandidato = avaliadorCandidatoDAO
				.findByNamedQuery("desativarAvaliadores", idCandidato);
		if (avaliadoresCandidato != null) {
			for (AvaliadorCandidatoEntity avaliador : avaliadoresCandidato) {
				avaliador.setStatus(StatusCandidatoEnum.CANCELADO.getValue());
				avaliadorCandidatoDAO.update(avaliador);
			}
		}
	}

	@Transactional
	public CandidatoBean obterPorCPF(String cpf) {
		List<CandidatoEntity> candidatosEntity = null;

		candidatosEntity = candidatoDAO.findByNamedQuery("obterPorCPF", cpf.replace(".", "").replace("-", ""));
		if (candidatosEntity.isEmpty()) {
			return null;
		}
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
		if (avaliadoresEntity != null && avaliadoresEntity.size() > 0) {
			for (AvaliadorVagaEntity avaliadorVagaEntity : avaliadoresEntity) {
				AvaliadorCandidatoEntity avaliadorCandidatoEnitty = new AvaliadorCandidatoEntity();
				DataEntrevistaEntity dataEntrevistaEntity = new DataEntrevistaEntity();
				avaliadorCandidatoEnitty.setVaga(avaliadorVagaEntity.getVaga());
				avaliadorCandidatoEnitty.setUsuario(avaliadorVagaEntity.getUsuario());
				avaliadorCandidatoEnitty.setCandidato(candidato);
				avaliadorCandidatoDAO.insert(avaliadorCandidatoEnitty);
				dataEntrevistaEntity.setCandidato(candidato.getId());
				dataEntrevistaEntity.setUsuario(avaliadorVagaEntity.getUsuario());
				dataEntrevistaEntity.setVaga(vaga);
				dataEntrevistaDAO.insert(dataEntrevistaEntity);
			}
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
			if (funcionalidadeBean.getId() == 26) {
				listaStatus.add(StatusCandidatoEnum.GERARPROPOSTA.getValue());
			}
			if (funcionalidadeBean.getId() == 23) {
				listaStatus.add(StatusCandidatoEnum.PROPOSTACANDIDATO.getValue());
			}
			if (funcionalidadeBean.getId() == 28) {
				listaStatus.add(StatusCandidatoEnum.CANDIDATORECUSOUPROPOSTA.getValue());
				listaStatus.add(StatusCandidatoEnum.PROPOSTAAPROVADA.getValue());
				listaStatus.add(StatusCandidatoEnum.PROPOSTARECUSADA.getValue());
			}
		}
		if (listaStatus.isEmpty()) {
			listaStatus.add(0);
		}
		return listaStatus;
	}

	@Transactional
	public Integer totalPagina(CandidatoBean candidato) {
		float pag = 0;
		List<Criterion> criterions = confFiltro(candidato);
		pag = (float) candidatoDAO.rowCount(criterions) / (float) CandidatoDAO.limitResultsPerPage;
		Integer paginas = null;
		if (pag % 1 == 0) {
			paginas = (int) pag;
		} else {
			paginas = (int) Math.ceil((double) pag);
		}
		paginas = paginas < 1 ? 1 : paginas;
		return paginas;
	}

	private List<Criterion> confFiltro(CandidatoBean candidato) {
		Integer idVaga = 0;
		List<Criterion> criterions = new ArrayList<>();
		if (candidato.getVagaBean() != null) {
			criterions.add(Restrictions.eq("vaga.vaga.id", candidato.getVagaBean().getId()));
		}
		if (candidato.getNome() != null) {
			criterions.add(Restrictions.like("nome", "%" + candidato.getNome() + "%"));
		}
		if (candidato.getDataAberturaDe() != null && candidato.getDataAberturaPara() != null) {
			criterions.add(Restrictions.between("dataAbertura", parseData(candidato.getDataAberturaDe()),
					parseData(candidato.getDataAberturaPara())));
		} else if (candidato.getDataAberturaDe() != null && candidato.getDataAberturaPara() == null) {
			criterions.add(Restrictions.between("dataAbertura", parseData(candidato.getDataAberturaDe()),
					Calendar.getInstance().getTime()));
		} else if (candidato.getDataAberturaDe() == null && candidato.getDataAberturaPara() != null) {
			try {
				criterions.add(
						Restrictions.between("dataAbertura", new SimpleDateFormat("yyyy-MM-dd").parse("2010-01-01"),
								parseData(candidato.getDataAberturaPara())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (candidato.getPretensaoDe() != null && candidato.getPretensaoPara() != null) {
			criterions.add(
					Restrictions.between("valorPretensao", candidato.getPretensaoDe(), candidato.getPretensaoPara()));
		}
		if (idVaga != 0) {
			criterions.add(Restrictions.like("ultimaVaga.nomeVaga", "%" + idVaga + "%"));
		}
		return criterions;
	}

	@Transactional
	public void buscarUsuariosParaEmail(SituacaoCandidatoBean situacaoCandidatoBean) {
		if (situacaoCandidatoBean == null || situacaoCandidatoBean.getIdCandidato() == null) {
			return;
		}
		candidatoBean = candidatoConverter
				.convertEntityToBean(candidatoDAO.findById(situacaoCandidatoBean.getIdCandidato()));
		List<UsuarioBean> usuarios;
		ArrayList<String> recipients = new ArrayList<>();
		ArrayList<String> nomes = new ArrayList<>();
		List<AvaliadorCandidatoBean> avaliadores;
		FuncionalidadeBean f = new FuncionalidadeBean();
		
		if (situacaoCandidatoBean.getStatus().getValue() == StatusCandidatoEnum.CONTRATADO.getValue()) {
			
			avaliadores = buscarAvaliadoresSemRepetir(situacaoCandidatoBean.getIdCandidato(),situacaoCandidatoBean.getIdVaga());
			for (AvaliadorCandidatoBean a : avaliadores) {
				if (a.getUsuario() != null) {
					recipients.add(a.getUsuario().getEmail());
					nomes.add(a.getUsuario().getFuncionario().getNome());
				}
			}
		}else if(situacaoCandidatoBean.getStatus().getValue() == StatusCandidatoEnum.CANDIDATOEMANALISE.getValue()){
			
			avaliadores = avaliadorCandidatoConverter.convertEntityToBean(avaliadorCandidatoDAO.findByNamedQuery("obterAvaliadoresCandidato", 
					situacaoCandidatoBean.getIdCandidato()));
			for (AvaliadorCandidatoBean a : avaliadores) {
				if (a.getUsuario() != null) {
					recipients.add(a.getUsuario().getEmail());
					nomes.add(a.getUsuario().getFuncionario().getNome());
				}
			}
		} else if (situacaoCandidatoBean.getStatus().getValue() == StatusCandidatoEnum.PROPOSTACANDIDATO.getValue()) {
			
			f.setId(23);
			usuarios = buscarUsuariosSemRepetir();
			for (UsuarioBean u : usuarios) {
				//recebe email quem pode aprovar proposta
				if (u.getPerfil().getListaFuncionalidades().contains(f)) {
				//case "Diretor de operação":
					recipients.add(u.getEmail());
					nomes.add(u.getFuncionario().getNome());
				}
			}
		} else if (situacaoCandidatoBean.getStatus().getValue() == StatusCandidatoEnum.GERARPROPOSTA.getValue()
				|| situacaoCandidatoBean.getStatus().getValue() == StatusCandidatoEnum.CANDIDATORECUSOUPROPOSTA.getValue()) {
			
			f.setId(26);
			usuarios = buscarUsuariosSemRepetir();
			for (UsuarioBean u : usuarios) {
				//recebe email quem pode gerar proposta
				if (u.getPerfil().getListaFuncionalidades().contains(f)) {
				//case "Analista de RH":
					recipients.add(u.getEmail());
					nomes.add(u.getFuncionario().getNome());
				}
			}
		}
		GeradorEmail email = new GeradorEmail();
		for (int i = 0; i < recipients.size(); i++) {
			try {
				email.enviarEmail(candidatoBean, recipients.get(i), nomes.get(i));
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	private List<AvaliadorCandidatoBean> buscarAvaliadoresSemRepetir(int idCandidato, int idVaga) {
		List<AvaliadorCandidatoBean> avaliadores = avaliadorCandidatoConverter
				.convertEntityToBean(avaliadorCandidatoDAO.findByNamedQuery("listarAvaliadoresCandidatoVaga", idCandidato, idVaga));
		List<AvaliadorCandidatoBean> avaliadoresNaoRepetidos = new ArrayList<>();
		Set<Integer> idAvaliadores = new HashSet<Integer>();
		if (avaliadores != null) {
			for (AvaliadorCandidatoBean u : avaliadores) {
				if (idAvaliadores.add(u.getId())) {
					avaliadoresNaoRepetidos.add(u);
				}
			}
		}
		return avaliadoresNaoRepetidos;
	}

	private List<UsuarioBean> buscarUsuariosSemRepetir() {
		List<UsuarioBean> usuarios = usuarioBusiness.findAll();
		List<UsuarioBean> usuariosNaoRepetidos = new ArrayList<>();
		Set<Integer> idUsuarios = new HashSet<Integer>();

		if (usuarios != null) {
			for (UsuarioBean u : usuarios) {
				if (idUsuarios.add(u.getId())) {
					usuariosNaoRepetidos.add(u);
				}
			}
		}
		return usuariosNaoRepetidos;
	}

	public boolean podeEditarVaga(StatusCandidatoBean ultimoStatus) {
		if (ultimoStatus.getStatus().getId() != null) {
			if (ultimoStatus.getStatus().getId() != 5 && ultimoStatus.getStatus().getId() != 17
					&& ultimoStatus.getStatus().getId() != 29 && ultimoStatus.getStatus().getId() != 15) {
				return false;
			}
		}
		return true;
	}

	@Transactional
	public void salvarProposta(CandidatoBean bean) {
		candidatoDAO.update(candidatoConverter.convertBeanToEntity(bean));
	}

	@Transactional
	public void inserirComunicacao(ComunicacaoBean bean) {
		comunicacaoDAO.insert(comunicacaoConverter.convertBeanToEntity(bean));
	}

	@Transactional
	private void desativarDataEntrevista(CandidatoBean candidatoBean) {
		List<DataEntrevistaEntity> dtsEntrevista = dataEntrevistaDAO.findByNamedQuery("desativarDtEntrevista",
				candidatoBean.getId());

		if (dtsEntrevista != null) {
			for (DataEntrevistaEntity dtEntrevista : dtsEntrevista) {
				dtEntrevista.setCandidato(candidatoBean.getId());
				dtEntrevista.setFlSituacao(false);
				dataEntrevistaDAO.update(dtEntrevista);
			}
		}
	}
	@Transactional
	public List<CandidatoBean> listarCandidatosVaga(Integer idVaga) {
		List<CandidatoEntity> entitys = candidatoDAO.findByNamedQuery("listaCandidatosVaga", idVaga);
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entitys);
		
		for(int cont = 0; cont < beans.size(); cont ++){
			for(int i = 0; i < beans.get(cont).getStatus().size(); i++){
				if(beans.get(cont).getStatus().get(i).getIdVaga() == null || !beans.get(cont).getStatus().get(i).getIdVaga().equals(idVaga)){
					beans.get(cont).getStatus().remove(i);
					i--;
				}
			}
		}
		return beans;
	}
	public QuantiaCandidatoPorStatusBean contarCandidatosPorStatus(List<CandidatoBean> beans){
		QuantiaCandidatoPorStatusBean qtdCandidatoPorStatus = new QuantiaCandidatoPorStatusBean();
		
		for(CandidatoBean candidato : beans){
			Integer idStatusCandidato = candidato.getUltimoStatus().getStatus().getId();
			
			if(idStatusCandidato.equals(StatusCandidatoEnum.CANDIDATURA.getValue())){
				qtdCandidatoPorStatus.setCandidaturas();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CANDIDATOAPROVADO.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.GERARPROPOSTA.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.PROPOSTACANDIDATO.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.PROPOSTAAPROVADA.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.PROPOSTARECUSADA.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CANDIDATORECUSOUPROPOSTA.getValue())){
				qtdCandidatoPorStatus.setAprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CANDIDATOREPROVADO.getValue())){
				qtdCandidatoPorStatus.setReprovados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CANCELADO.getValue())){
				qtdCandidatoPorStatus.setCancelados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CONTRATADO.getValue())){
				qtdCandidatoPorStatus.setContratados();
			}else if(idStatusCandidato.equals(StatusCandidatoEnum.CANDIDATOEMANALISE.getValue())){
				qtdCandidatoPorStatus.setEmAnalise();
			}
		}
		return qtdCandidatoPorStatus;
	}
}
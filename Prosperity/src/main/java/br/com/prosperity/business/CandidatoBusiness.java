package br.com.prosperity.business;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.io.path.Path;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.StatusCandidatoBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.CandidatoConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliadorCandidatoDAO;
import br.com.prosperity.dao.CanalInformacaoDAO;
import br.com.prosperity.dao.CandidatoDAO;
import br.com.prosperity.dao.SituacaoAtualDAO;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusFuturoDAO;
import br.com.prosperity.dao.TipoCursoDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;
import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusFuturoEntity;
import br.com.prosperity.entity.VagaCandidatoEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.util.FormatUtil;

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
	private VagaDAO vagaDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private VagaConverter vagaConverter;

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
	public List<CandidatoBean> listar() {
		List<CandidatoEntity> candidato = candidatoDAO.findByNamedQuery("verificarCanidatura");
		List<CandidatoEntity> entities = candidatoDAO.findAll();
		List<CandidatoBean> beans = candidatoConverter.convertEntityToBean(entities);

		return beans;
	}

	@Transactional
	public void inserir(CandidatoBean candidatoBean) {
		if (candidatoBean.getId() == null) {
			if (verificarCandidatura(candidatoBean) == true) {
				CandidatoEntity candidatoEntity = candidatoConverter.convertBeanToEntity(candidatoBean);
				candidatoEntity.getFormacao().setSituacaoAtual(situacaoAtualDAO.findById(candidatoEntity.getFormacao().getSituacaoAtual().getIdSituacaoAtual()));
				candidatoEntity.getFormacao().setTipoCurso(tipoCursoDAO.findById(candidatoEntity.getFormacao().getTipoCurso().getId()));
				VagaEntity vagaEntity = vagaDAO.findById(candidatoBean.getVagaCandidato().getVaga().getId());
				VagaCandidatoEntity vagaCandidatoEntity = new VagaCandidatoEntity();
				
				vagaCandidatoEntity.setVaga(vagaEntity);
				vagaCandidatoEntity.setCanalInformacao(canalInformacaoDAO.findById(candidatoBean.getVagaCandidato().getCanalInformacao().getId()));
				candidatoEntity.getVagas().add(vagaCandidatoEntity);
				
				candidatoDAO.insert(candidatoEntity);
				
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
				avaliadorCandidatoEntity = avaliadorCandidatoDAO.findByNamedQuery("obterAvaliadoresCandidato");
				if (avaliadorCandidatoEntity != null && avaliadorCandidatoEntity.size() > 0) {
					StatusCandidatoEnum status = avaliadorCandidatoEntity.size() == 1
							? StatusCandidatoEnum.PROPOSTACANDIDATO : StatusCandidatoEnum.CANDIDATOEMANALISE;

					situacaoCandidato.setStatus(status);
					avaliadorCandidatoEntity.get(0).setIdStatus(situacaoCandidato.getStatus().getValue());
					avaliadorCandidatoDAO.update(avaliadorCandidatoEntity.get(0));
				}
			}

			statusCandidatoDAO.insert(statusAlteracao(situacaoCandidato));
		}
	}

	private StatusCandidatoEntity statusAlteracao(SituacaoCandidatoBean situacaoCandidato) {
		StatusCandidatoEntity statusCandidatoEntity = new StatusCandidatoEntity();

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusCandidatoEntity.setStatus(statusDAO.findById(situacaoCandidato.getStatus().getValue()));
		candidatoBean.setId(situacaoCandidato.getIdCandidato());
		statusCandidatoEntity.setCandidato(candidatoConverter.convertBeanToEntity(candidatoBean));
		statusCandidatoEntity.setDsParecer(situacaoCandidato.getParecer());
		statusCandidatoEntity.setProposta(situacaoCandidato.getProposta());
		statusCandidatoEntity.setDtAlteracao(new Date());
		statusCandidatoEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));

		return statusCandidatoEntity;
	}

	public CandidatoBean obterPorCPF(String cpf) {
		List<CandidatoEntity> candidatosEntity = null;

		candidatosEntity = candidatoDAO.findByNamedQuery("obterPorCPF", cpf);

		// Integer idDoCara = candidatosEntity.get(0).getId();
		// for (int i = 0; i < candidatosEntity.size(); i++) {
		//
		// }

		for (CandidatoEntity candidatoEntity : candidatosEntity) {

			candidatoBean = candidatoConverter.convertEntityToBean(candidatoEntity);
		}


		return candidatoBean;
	}

	private Boolean verificarCandidatura(CandidatoBean candidato) {

		return candidato.getUltimoStatus().getId() == null ? true : false;

	}

	@Transactional
	private void inserirAvaliadores(CandidatoEntity candidato, Integer idVaga) {
		VagaEntity vaga = vagaDAO.findById(idVaga);
		List<AvaliadorCandidatoEntity> avaliadoresCandidatoEntity = avaliadorCandidatoDAO
				.findByNamedQuery("obterAvaliadoresDaVaga", vaga);
		for (AvaliadorCandidatoEntity avaliadorCandidatoEntity : avaliadoresCandidatoEntity) {

			avaliadorCandidatoEntity.setCandidato(candidato);

			avaliadorCandidatoDAO.update(avaliadorCandidatoEntity);
		}
	}
}

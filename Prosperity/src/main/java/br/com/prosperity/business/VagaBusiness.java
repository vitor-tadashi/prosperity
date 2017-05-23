package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.AvaliadorVagaBean;
import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.SituacaoCandidatoBean;
import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.AvaliadorVagaConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliadorCandidatoDAO;
import br.com.prosperity.dao.AvaliadorVagaDAO;
import br.com.prosperity.dao.StatusCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaCandidatoDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;
import br.com.prosperity.entity.AvaliadorVagaEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusVagaEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusCandidatoEnum;
import br.com.prosperity.enumarator.StatusVagaEnum;
import br.com.prosperity.util.GeradorEmail;

@Component
public class VagaBusiness {

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	private VagaConverter vagaConverter;

	@Autowired
	private VagaCandidatoDAO vagaCandidatoDAO;

	@Autowired
	private StatusDAO statusDAO;

	@Autowired
	private StatusVagaDAO statusVagaDAO;

	@Autowired
	private AvaliadorVagaDAO avaliadorVagaDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private HttpSession session;

	@Autowired
	private SituacaoVagaBean situacaoVaga;

	@Autowired
	private List<VagaBean> vagaBean;

	@Autowired
	private List<AvaliadorVagaBean> avaliadorVagaBean;

	@Autowired
	private AvaliadorVagaDAO avaliadorVagaDao;

	@Autowired
	private AvaliadorCandidatoDAO avaliadorCandidatoDAO;

	@Autowired
	private AvaliadorVagaConverter avaliadorVagaConverter;

	@Autowired
	private CandidatoBusiness candidatoBusiness;

	@Autowired
	private SituacaoCandidatoBean situacaoCandidato;

	@Autowired
	private StatusCandidatoDAO statusCandidatoDAO;

	@Autowired
	private UsuarioBusiness usuarioBusiness;

	@Transactional(readOnly = true)
	public List<VagaBean> listarDecrescente() {
		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("findAllDesc");
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> listar() {
		List<VagaEntity> vagaEntity = vagaDAO.findAll();
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	// TODAS AS VAGAS ATIVAS
	@Transactional(readOnly = true)
	public Integer totalPagina(VagaBean vaga) {
		List<Criterion> criterions = confFiltro(vaga);
		float pag = (float) vagaDAO.rowCount(criterions) / (float) VagaDAO.limitResultsPerPage;
		Integer paginas = null;
		if (pag % 1 == 0) {
			paginas = (int) pag;
		} else {
			paginas = (int) Math.ceil((double) pag);
		}
		paginas = paginas < 1 ? 1 : paginas;
		return paginas;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> listarVagasAtivas() {
		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagasAtivas");
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional
	public List<VagaBean> listarVagaAprovar() {
		List<Integer> listaStatus = obterStatusDisponivelAprovacao();

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagaAprovar", listaStatus); // PENSAR
		int aux = 0;
		for (VagaEntity vaga : vagaEntity) {
			vaga.setDataInicio(parseData(vaga.getDataInicio()));
			System.out.println(vaga.getDataInicio());
			vagaEntity.get(aux).setDataInicio(vaga.getDataInicio());
			aux++;
		}

		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		for (int i = 0; i < vagaBean.size(); i++) {
			for (int c = 0; c < vagaBean.get(i).getVagaCandidatoBean().size(); c++) {
				if (vagaBean.get(i).getVagaCandidatoBean().get(c).getContratado() != null
						&& vagaBean.get(i).getVagaCandidatoBean().get(c).getContratado()) {
					vagaBean.get(i).getUltimoStatus().getStatus().getStatusDisponiveis().remove(0);
					c = vagaBean.get(i).getVagaCandidatoBean().size();
				}
			}
		}
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> filtroVaga(VagaBean vaga, Integer page) {
		List<Criterion> criterions = confFiltro(vaga);

		List<VagaEntity> vagas = vagaDAO.paginar(page, criterions);

		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagas);
		return vagaBean;
	}

	private List<Criterion> confFiltro(VagaBean vaga) {
		List<Criterion> criterions = new ArrayList<>();
		Integer idStatus = 0;
		try {
			if (!vaga.getStatus().get(0).getStatus().getNome().equals("")) {
				idStatus = Integer.parseInt(vaga.getStatus().get(0).getStatus().getNome());
			}
			if (!vaga.getNomeVaga().isEmpty() || vaga.getNomeVaga() != null) {
				criterions.add(Restrictions.like("nomeVaga", "%" + vaga.getNomeVaga() + "%"));
			}

			if (vaga.getDataAberturaDe() != null && vaga.getDataAberturaPara() != null) {
				if (vaga.getDataAberturaDe() == null) {
					criterions.add(Restrictions.between("dataAbertura", "", parseData(vaga.getDataAberturaPara())));
				} else if (vaga.getDataAberturaPara() == null) {
					criterions.add(Restrictions.between("dataAbertura", parseData(vaga.getDataAberturaDe()), ""));
				} else {
					criterions.add(Restrictions.between("dataAbertura", parseData(vaga.getDataAberturaDe()),
							parseData(vaga.getDataAberturaPara())));
				}
			}

			if (idStatus != 0) {
				criterions.add(Restrictions.eq("status.id", idStatus));
			}
		} catch (Exception e) {

		}
		return criterions;
	}

	@Transactional(readOnly = true)
	public VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.findById(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	@Transactional
	public void inserir(VagaBean vagaBean, List<UsuarioBean> usuarioBean) {

		VagaEntity vagaEntity = vagaConverter.convertBeanToEntity(vagaBean);

		if (vagaEntity.getId() == null) {
			vagaEntity.setDataAbertura(new Date());
			vagaDAO.insert(vagaEntity);
			situacaoVaga.setIdVaga(vagaEntity.getId());
			situacaoVaga.setStatus(StatusVagaEnum.PENDENTE);
			alterarStatus(situacaoVaga);
		} else {
			vagaDAO.update(vagaEntity);
		}
		if(usuarioBean.size() > 0 && usuarioBean.get(0).getId()!= null)
			inserirAvaliadores(vagaEntity, usuarioBean);
	}

	@Transactional
	public VagaBean obterVagaPorId(Integer id) {
		VagaEntity vagaEntity = vagaDAO.findById(id);
		List<AvaliadorVagaBean> avaliadorVaga = avaliadorVagaConverter
				.convertEntityToBean(vagaEntity.getAvaliadorVagaEntity());
		List<UsuarioBean> usuariosBean = new ArrayList<>();

		VagaBean bean = vagaConverter.convertEntityToBean(vagaEntity);
		for (AvaliadorVagaBean av : avaliadorVaga) {
			usuariosBean.add(av.getUsuario());
		}
		bean.setAvaliadores(usuariosBean);
		return bean;
	}

	public Date formatarHora(String hora) throws ParseException {
		String myDateString = hora;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(myDateString);
		return date;
	}

	/**
	 * @author guilherme.oliveira Método de alteração de status da vaga. Caso
	 *         tente ativar a vaga que não tenha avaliadores ela fica com status
	 *         NOVA VAGA. Se a cancelar/recusar/fechar a vaga todos os seus
	 *         candidato ficam com o status SEM VAGA, exceto os contratados. Se
	 *         o status for PENDENTE ele não desativa status anteriores.
	 */
	@Transactional(readOnly = true)
	public void alterarStatus(SituacaoVagaBean situacaoVaga) {
		StatusVagaEntity statusVagaEntity = new StatusVagaEntity();
		VagaEntity vagaEntity = vagaDAO.findById(situacaoVaga.getIdVaga());
		vagaEntity.setId(situacaoVaga.getIdVaga());
		if (situacaoVaga.getStatus() == StatusVagaEnum.ATIVO) {
			List<AvaliadorVagaEntity> avaliadorVagaEntity = avaliadorVagaDao.findByNamedQuery("obterAvaliadoresDaVaga",
					vagaEntity.getId());
			if (avaliadorVagaEntity == null || avaliadorVagaEntity.size() == 0 ||
				vagaEntity.getMarketingSocial().equals("")) {
				situacaoVaga.setStatus(StatusVagaEnum.VAGANOVA);
			}
		}

		if (situacaoVaga.getStatus().getValue() == StatusVagaEnum.CANCELADO.getValue()
				|| situacaoVaga.getStatus().getValue() == StatusVagaEnum.RECUSADO.getValue()
				|| situacaoVaga.getStatus().getValue() == StatusVagaEnum.FECHADO.getValue()) {
			List<AvaliadorCandidatoEntity> avaliadorCandidatos = avaliadorCandidatoDAO
					.findByNamedQuery("desativarAvaliadoresPorVaga", vagaEntity.getId());
			for (AvaliadorCandidatoEntity acandidato : avaliadorCandidatos) {
				List<StatusCandidatoEntity> statusCandidato = statusCandidatoDAO
						.findByNamedQuery("obterStatusCandidato", acandidato.getCandidato().getId());
				if (statusCandidato.get(0).getStatus().getId() != StatusCandidatoEnum.CONTRATADO.getValue()) {
					situacaoCandidato.setIdCandidato(acandidato.getCandidato().getId());
					situacaoCandidato.setStatus(StatusCandidatoEnum.SEMVAGA);
					candidatoBusiness.alterarStatus(situacaoCandidato);
				}
			}
		}

		if (situacaoVaga.getStatus().getValue() != StatusVagaEnum.PENDENTE.getValue()) {
			desativarStatus(vagaEntity);
		}

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusVagaEntity.setStatus(statusDAO.findById(situacaoVaga.getStatus().getValue()));
		statusVagaEntity.setVaga(vagaEntity);
		statusVagaEntity.setDataAlteracao(new Date());
		statusVagaEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));
		statusVagaEntity.setSituacao(true);

		statusVagaDAO.insert(statusVagaEntity);

		buscarUsuariosParaEmail(situacaoVaga);
	}

	@Transactional
	public void alterarDataAprovacao(SituacaoVagaBean status) {
		Integer idStatus = status.getStatus().getValue();
		VagaEntity vagaEntity = vagaDAO.findById(status.getIdVaga());

		if (idStatus == 1 || idStatus == 27) {
			vagaEntity.setDataAprovacao(new Date());
			vagaDAO.update(vagaEntity);
		} else if (idStatus == 2 || idStatus == 3 || idStatus == 18) {
			vagaEntity.setDataFechamento(new Date());
			vagaDAO.update(vagaEntity);
		}
	}

	@Transactional
	private void desativarStatus(VagaEntity vagaEntity) {
		List<StatusVagaEntity> statusVagas = statusVagaDAO.findByNamedQuery("desativarStatusVaga", vagaEntity);
		if (statusVagas != null) {
			for (StatusVagaEntity status : statusVagas) {
				status.setSituacao(false);
				statusVagaDAO.update(status);
			}
		}
	}

	private Date parseData(Date dataAntiga) {
		SimpleDateFormat novaData = new SimpleDateFormat("dd-MM-yyyy");

		String data = "";
		try {
			data = novaData.format(dataAntiga);
			return novaData.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataAntiga;
	}

	@Transactional
	private void inserirAvaliadores(VagaEntity vaga, List<UsuarioBean> usuarios) {
		List<AvaliadorVagaEntity> avaliadores = avaliadorVagaDAO.findByNamedQuery("obterAvaliadoresDaVaga",
				vaga.getId());
		if (avaliadores.size() > 0) {
			for (AvaliadorVagaEntity av : avaliadores) {
				avaliadorVagaDAO.remove(av);
			}

		}
		if (usuarios != null) {
			for (UsuarioBean usuario : usuarios) {
				AvaliadorVagaEntity avaliadorVagaEntity = new AvaliadorVagaEntity();
				avaliadorVagaEntity.setVaga(vaga);
				avaliadorVagaEntity.setUsuario(usuarioDAO.findById(usuario.getId()));
				avaliadorVagaDAO.insert(avaliadorVagaEntity);
			}
		}
	}

	@Transactional(readOnly = true)
	public List<VagaBean> obterTodos() {
		List<VagaEntity> vagaEntity = vagaDAO.findAll();
		vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true) // esta dando nullPointer
	public List<AvaliadorVagaBean> obterAvaliadores(Integer id) {
		List<AvaliadorVagaEntity> avaliadorVagaEntity = avaliadorVagaDao.findByNamedQuery("obterAvaliadoresDaVaga", id);
		avaliadorVagaBean = avaliadorVagaConverter.convertEntityToBean(avaliadorVagaEntity);
		return avaliadorVagaBean;
	}

	private List<Integer> obterStatusDisponivelAprovacao() {
		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		Set<Integer> lista = new HashSet<>();
		List<Integer> listaStatus = new ArrayList<Integer>();

		for (FuncionalidadeBean funcionalidadeBean : usuarioBean.getPerfil().getListaFuncionalidades()) {
			if (funcionalidadeBean.getId() == 1)
				lista.add(StatusVagaEnum.PENDENTE.getValue());

			if (funcionalidadeBean.getId() == 30)
				lista.add(StatusVagaEnum.ATIVO.getValue());

			if (funcionalidadeBean.getId() == 29) {
				lista.add(StatusVagaEnum.VAGANOVA.getValue());
				lista.add(StatusVagaEnum.PENDENTE.getValue());
				lista.add(StatusVagaEnum.ATIVO.getValue());

			}
		}
		for (Integer listas : lista) {
			listaStatus.add(listas);
		}
		return listaStatus;
	}

	public Long obterQtdCandidatos(Integer idVaga) {
		Long count = vagaCandidatoDAO.count("countCandidatosVaga");
		return count;
	}

	@Transactional
	public void buscarUsuariosParaEmail(SituacaoVagaBean situacaoVagaBean) {

		try {
			VagaEntity vaga = vagaDAO.findById(situacaoVagaBean.getIdVaga());

			List<UsuarioBean> usuarios = buscarUsuariosSemRepetir();

			// Não enviar email caso a lista estiver vazia:
			if (usuarios == null || usuarios.size() == 0) {
				return;
			}

			ArrayList<String> recipients = new ArrayList<>();
			ArrayList<String> nomes = new ArrayList<>();

			if (situacaoVagaBean.getStatus().getValue() == StatusVagaEnum.VAGANOVA.getValue()) {
				for (UsuarioBean u : usuarios) {
					switch (u.getPerfil().getNome()) {
					case "Analista de RH":
						recipients.add(u.getEmail());
						nomes.add(u.getFuncionario().getNome());
						break;
					default:
						break;
					}
				}
			}
			GeradorEmail email = new GeradorEmail();
			for (int i = 0, j = 0; i < recipients.size() && j < nomes.size(); i++, j++) {
				email.enviarEmail(vaga, recipients.get(i), nomes.get(j));
			}
		} catch (Exception e) {
			System.out.println("Erro\n");
			e.printStackTrace();
		}
	}

	private List<UsuarioBean> buscarUsuariosSemRepetir() {
		List<UsuarioBean> usuarios = usuarioBusiness.findAll();
		List<UsuarioBean> usuariosNaoRepetidos = new ArrayList<>();
		Set<Integer> idUsuarios = new HashSet<Integer>();

		for (UsuarioBean u : usuarios) {
			if (idUsuarios.add(u.getId())) {
				usuariosNaoRepetidos.add(u);
			}
		}

		return usuariosNaoRepetidos;
	}
}
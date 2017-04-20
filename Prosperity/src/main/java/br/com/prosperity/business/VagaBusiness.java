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
import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.AvaliadorVagaConverter;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliadorVagaDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaCandidatoDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorVagaEntity;
import br.com.prosperity.entity.StatusVagaEntity;
import br.com.prosperity.entity.VagaCandidatoEntity;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusVagaEnum;

@Component
public class VagaBusiness {

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	private VagaConverter vagaConverter;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private SenioridadeBusiness senioridadeBusinness;

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
	private AvaliadorVagaConverter avaliadorVagaConverter;

	@Transactional(readOnly = true)
	public List<VagaBean> listarDecrescente() {
		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("findAllDesc");
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> listar() {

		List<VagaEntity> vagaEntity = vagaDAO.findAll(); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	//TODAS AS VAGAS ATIVAS
	@Transactional(readOnly = true)
	public Integer totalPagina() {
		Integer paginas = (int)Math.round((double) (vagaDAO.count("paginacao") / VagaDAO.limitResultsPerPage)+0.5);
		paginas = paginas < 1 ? 1 : paginas;
		return paginas;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> listarVagasAtivas() {
		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagasAtivas", 1);
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
		// for each para percorrer lista de vagas formantando ela.
		// vagaEntity.get(0).setDataInicio(parseData(vagaEntity.get(0).getDataInicio()));
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> filtroVaga(VagaBean vaga,Integer page) {
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
				criterions.add(Restrictions.between("dataAbertura", parseData(vaga.getDataAberturaDe()),
						parseData(vaga.getDataAberturaPara())));
			}

			if (idStatus != 0) {
				criterions.add(Restrictions.eq("status.id", idStatus));
			}
		} catch (Exception e) {

		}
		List<VagaEntity> vagas = vagaDAO.paginar(page, criterions);

		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagas);
		return vagaBean;
	}

	@Transactional(readOnly = true)

	public VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.findById(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	@Transactional
	public String inserir(VagaBean vagaBean, List<UsuarioBean> usuarioBean) {

		VagaEntity vagaEntity = vagaConverter.convertBeanToEntity(vagaBean);

		vagaEntity.setStatusVagaEntity(statusVagaDAO.findByNamedQuery("statusVaga", vagaEntity.getId()));

		try {
			if (vagaEntity.getId() == null) {
				Date dateNow = new Date();
				vagaEntity.setDataAbertura(dateNow);
				vagaDAO.insert(vagaEntity);
				situacaoVaga.setIdVaga(vagaEntity.getId());
				situacaoVaga.setStatus(StatusVagaEnum.PENDENTE);
				alterarStatus(situacaoVaga);
				inserirAvaliadores(vagaEntity, usuarioBean);
			} else {
				// VERIFICAR SE DEVE SER DATA DE ALTERAÇÂO
				inserirAvaliadores(vagaEntity, usuarioBean);
				vagaDAO.update(vagaEntity);
			}
			return "Ok";

		} catch (Exception e) {
			String erro = new String();
			erro = e.toString();
			return erro;
		}
	}

	@Transactional
	public VagaBean obterVagaPorId(Integer id) {
		VagaBean bean = vagaConverter.convertEntityToBean(vagaDAO.findById(id));
		return bean;
	}

	public Date formatarHora(String hora) throws ParseException {
		String myDateString = hora;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(myDateString);
		return date;
	}

	@Transactional
	public void alterarStatus(SituacaoVagaBean situacaoVaga) {
		StatusVagaEntity statusVagaEntity = new StatusVagaEntity();
		VagaEntity vagaEntity = new VagaEntity();
		vagaEntity.setId(situacaoVaga.getIdVaga());

		if (situacaoVaga.getStatus() == StatusVagaEnum.ATIVO) {
			avaliadorVagaBean = obterAvaliadores(vagaEntity.getId());
			if (avaliadorVagaBean == null || avaliadorVagaBean.size() == 0) {
				situacaoVaga.setStatus(StatusVagaEnum.AGUARDANDOAVALIADORES);
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
	}

	@Transactional
	public void alterarDataAprovacao(SituacaoVagaBean status) {
		VagaEntity vagaEntity = vagaDAO.findById(status.getIdVaga());
		vagaEntity.setDataAprovacao(new Date());
		vagaDAO.update(vagaEntity);
		vagaEntity.setDataFechamento(new Date());
		vagaDAO.update(vagaEntity);
	}

	@Transactional
	private void desativarStatus(VagaEntity vagaEntity) {
		List<StatusVagaEntity> statusVagas = statusVagaDAO.findByNamedQuery("obterStatusVaga", vagaEntity);
		if (statusVagas == null || statusVagas.size() < 1) {
		} else {
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
			e.printStackTrace(); // imprimi a stack trace
		}
		return dataAntiga;
	}

	@Transactional
	private void inserirAvaliadores(VagaEntity vaga, List<UsuarioBean> usuarios) {
		if (usuarios != null || usuarios.size() < 1) {
			for (UsuarioBean usuario : usuarios) {
				AvaliadorVagaEntity avaliadorVagaEntity = new AvaliadorVagaEntity();
				avaliadorVagaEntity.setUsuario(usuarioConverter.convertBeanToEntity(usuario));
				avaliadorVagaEntity.setVaga(vaga);
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

	@Transactional(readOnly = true)
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
				lista.add(StatusVagaEnum.AGUARDANDOAVALIADORES.getValue());
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
}
	

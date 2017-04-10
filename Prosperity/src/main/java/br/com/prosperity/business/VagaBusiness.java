package br.com.prosperity.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.AvaliadorVagaBean;
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
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorVagaEntity;
import br.com.prosperity.entity.StatusVagaEntity;
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
	private CargoBusiness cargoBusinness;

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
	public List<VagaBean> listar() {

		List<VagaEntity> vagaEntity = vagaDAO.findAll(); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> listarVagasAtivas() {
		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagasAtivas", 1);
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional
	public List<VagaBean> listarVagaAprovar() {

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagaAprovar", 4,1, true); // PENSAR
		int aux = 0;
		for(VagaEntity vaga: vagaEntity)
		{
			vaga.setDataInicio(parseData(vaga.getDataInicio()));
			System.out.println(vaga.getDataInicio());
			vagaEntity.get(aux).setDataInicio(vaga.getDataInicio());
			aux++;
		}
		//for each para percorrer lista de vagas formantando ela.
		//vagaEntity.get(0).setDataInicio(parseData(vagaEntity.get(0).getDataInicio()));
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaBean> filtroVaga(VagaBean vaga) {

		Integer idStatus = 0;
		if (!vaga.getStatus().get(0).getStatus().getNome().equals("")) {
			idStatus = Integer.parseInt(vaga.getStatus().get(0).getStatus().getNome());
		}
		
		List<Criterion>criterions = new ArrayList<>();
		if(!vaga.getNomeVaga().isEmpty() || vaga.getNomeVaga() != null){
			criterions.add(Restrictions.like("nomeVaga", "%" + vaga.getNomeVaga() + "%"));
		}
		if(vaga.getDataAberturaDe() != null && vaga.getDataAberturaPara() != null){
			criterions.add(Restrictions.between("dataAbertura", parseData(vaga.getDataAberturaDe()),  parseData(vaga.getDataAberturaPara())));
		}
		
		if(idStatus != 0) {
			criterions.add(Restrictions.eq("status.id", idStatus));
		}
		List<VagaEntity>vagas = vagaDAO.findByCriteria(criterions);
		
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
	public void inserir(VagaBean vagaBean, List<UsuarioBean> usuarioBean) {

		VagaEntity vagaEntity = vagaConverter.convertBeanToEntity(vagaBean);
		
		vagaEntity.setStatusVagaEntity(statusVagaDAO.findByNamedQuery("statusVaga", vagaEntity.getId()));
		
		if (vagaEntity.getId() == null) {
			Date dateNow = new Date();
			vagaEntity.setDataAbertura(dateNow);
			vagaDAO.insert(vagaEntity);
			situacaoVaga.setIdVaga(vagaEntity.getId());
			situacaoVaga.setStatus(StatusVagaEnum.PENDENTE);
			alterarStatus(situacaoVaga);
			inserirAvaliadores(vagaEntity, usuarioBean);
		} else {
			// vagaEntity.setDataAbertura(vagaBean.getDataAbertura()); //
			// VERIFICAR SE DEVE SER DATA DE ALTERAÇÂO
			// vagaBean.setUsuarioBean(usuario);
			vagaDAO.update(vagaEntity);
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

		usuarioBean = (UsuarioBean) session.getAttribute("autenticado");
		statusVagaEntity.setStatus(statusDAO.findById(situacaoVaga.getStatus().getValue()));
		statusVagaEntity.getVaga().setId(situacaoVaga.getIdVaga());
		statusVagaEntity.setDataAlteracao(new Date());
		statusVagaEntity.setUsuario(usuarioDAO.findById(usuarioBean.getId()));
		statusVagaEntity.setSituacao(true);

		desativarStatus(statusVagaEntity);

		statusVagaDAO.insert(statusVagaEntity);
	}

	@Transactional
	private void desativarStatus(StatusVagaEntity statusVaga) {
		List<StatusVagaEntity> statusVagas = statusVagaDAO.findByNamedQuery("obterStatusVaga", statusVaga.getVaga());
		for (StatusVagaEntity status : statusVagas) {
			status.setSituacao(false);
			statusVagaDAO.update(status);
		}

	}

	private Date parseData(Date dataAntiga) {
		SimpleDateFormat novaData = new SimpleDateFormat("dd-MM-yyyy");

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
	private void inserirAvaliadores(VagaEntity vaga, List<UsuarioBean> usuarios) {
		for (UsuarioBean usuario : usuarios) {
            AvaliadorVagaEntity avaliadorVagaEntity = new AvaliadorVagaEntity();
            avaliadorVagaEntity.setUsuario(usuarioConverter.convertBeanToEntity(usuario));
            avaliadorVagaEntity.setVaga(vaga);
            avaliadorVagaDAO.insert(avaliadorVagaEntity);
		}
	}
	
	@Transactional(readOnly=true)
	public List<VagaBean> obterTodos() {
		List<VagaEntity> vagaEntity = vagaDAO.findAll();
		vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}
	
	@Transactional(readOnly=true)
	public List<AvaliadorVagaBean> obterAvaliadores (Integer id){
		List<AvaliadorVagaEntity> avaliadorVagaEntity = avaliadorVagaDao.findByNamedQuery("obterAvaliadoresDaVaga",id);
		avaliadorVagaBean = avaliadorVagaConverter.convertEntityToBean(avaliadorVagaEntity);
		return avaliadorVagaBean;
	}
}

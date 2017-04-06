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

import br.com.prosperity.bean.SituacaoVagaBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.AvaliadorCandidatoDAO;
import br.com.prosperity.dao.StatusDAO;
import br.com.prosperity.dao.StatusVagaDAO;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.AvaliadorCandidatoEntity;
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
	private AvaliadorCandidatoDAO avaliadorCandidatoDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private SituacaoVagaBean situacaoVaga;

	@Transactional(readOnly = true)
	public List<VagaBean> listar() {

		List<VagaEntity> vagaEntity = vagaDAO.findAll(); // PENSAR
		List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaBean;
	}

	@Transactional(readOnly = true)
	public List<VagaEntity> listarVagasAtivas() {

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagasAtivas", 1); // PENSAR
		//List<VagaBean> vagaBean = vagaConverter.convertEntityToBean(vagaEntity);
		return vagaEntity;
	}

	@Transactional
	public List<VagaBean> listarVagaAprovar() {

		List<VagaEntity> vagaEntity = vagaDAO.findByNamedQuery("listarVagaAprovar", 18, true); // PENSAR
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
	public void inserir(VagaBean vagaBean/*, List<UsuarioBean> avaliadores , HttpSession session */) {

		VagaEntity vagaEntity = vagaConverter.convertBeanToEntity(vagaBean);

		if (vagaEntity.getId() == null) {
			Date dateNow = new Date();
			vagaEntity.setDataAbertura(dateNow);
			// vagaBean.setUsuarioBean(usuario);
			vagaDAO.insert(vagaEntity);
			situacaoVaga.setIdVaga(vagaEntity.getId());
			situacaoVaga.setStatus(StatusVagaEnum.PENDENTE);
			alterarStatus(situacaoVaga);
			/*inserirAvaliadores(vagaEntity, avaliadores);*/
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
		statusVagaEntity.setVaga(situacaoVaga.getIdVaga());
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

	private void inserirAvaliadores(VagaEntity vaga, List<UsuarioBean> usuarios) {
		for (UsuarioBean usuario : usuarios) {
			AvaliadorCandidatoEntity avaliadorCandidatoEntity = new AvaliadorCandidatoEntity();
			avaliadorCandidatoEntity.setUsuario(usuarioConverter.convertBeanToEntity(usuario));
			avaliadorCandidatoEntity.setVaga(vaga);
			avaliadorCandidatoDAO.insert(avaliadorCandidatoEntity);
		}
	}
}

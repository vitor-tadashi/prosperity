package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.CandidatoEntity;

@Repository
public class CandidatoDAO extends GenericDAOImpl<CandidatoEntity, Integer> {
	
	Session session;
	
	public static final int limitResultsPerPage = 10;
	
	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public List<CandidatoEntity> findByCriteria(Integer page, final List<Criterion> criterion) {
		List<CandidatoEntity> ret = null;
		try {
			ret = findByCriteria("dataAbertura", true, (page * limitResultsPerPage) - (limitResultsPerPage), limitResultsPerPage, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<CandidatoEntity> findByCriteria(String propertyOrder, Boolean isDesc, final int firstResult, final int maxResults,
			final List<Criterion> criterion) {
		List<CandidatoEntity> result = null;

		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria crit = session.createCriteria(CandidatoEntity.class, "candidato");
			crit.createAlias("candidato.vagas", "vaga");
			//crit.createAlias("vagas.vaga", "vaga");
			for (final Criterion c : criterion) {
				crit.add(c);
		}

		if (firstResult > 0) {
			crit.setFirstResult(firstResult);
		}

			
			if (maxResults > 0) {
				crit.setMaxResults(maxResults);
			}
			
			if (propertyOrder != null && !propertyOrder.isEmpty()) {
				if (isDesc) {
					crit.addOrder(Order.desc(propertyOrder));
				} else {
					crit.addOrder(Order.asc(propertyOrder));
				}
			}

			
			result = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public float rowCount(List<Criterion> criterions) {
		Integer result = null;
		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria crit = session.createCriteria(CandidatoEntity.class, "candidato");
			crit.createAlias("candidato.vagas", "vaga");
			
			for (final Criterion c : criterions) {
				crit.add(c);
			}
			result = ((Number)crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == null)
			result = 0;
		return result;
	}
	public List<CandidatoEntity> listarAprovacao(List<Integer> listaStatus,Integer statu,Integer idUsuario,Integer idStatusCandidatura,Integer page){
		Query query = entityManager.createQuery("SELECT DISTINCT c FROM CandidatoEntity c "
				+ "INNER JOIN c.statusCandidatos sc "
				+ "INNER JOIN c.avaliadores ac "
				+ "WHERE (sc.idStatusCandidato = (SELECT max(scc.idStatusCandidato) FROM StatusCandidatoEntity scc WHERE scc.candidato.id = c.id) "
				+ "AND (sc.status.id IN (?1) AND ac.status IS NOT NULL AND sc.flSituacao = true) "
				+ "OR (sc.status.id = ?2 AND ac.status IS NULL AND ac.usuario.id = ?3 AND sc.flSituacao = true)"
				+ "OR (sc.status.id = ?4 AND ac.status IS NULL AND sc.flSituacao = true)) ORDER BY c.id DESC");
		
		query.setParameter(1, listaStatus);
		query.setParameter(2, statu);
		query.setParameter(3, idUsuario);
		query.setParameter(4, idStatusCandidatura);
		
		query.setFirstResult((page * limitResultsPerPage) - (limitResultsPerPage));
		query.setMaxResults(limitResultsPerPage);
		
		@SuppressWarnings("unchecked")
		List<CandidatoEntity> candidatos = query.getResultList();
		
		return candidatos;
	}
	public float countAprovacao(List<Integer> listaStatus,Integer statu,Integer idUsuario,Integer idStatusCandidatura){
		Long result = null;
		
		Query query = entityManager.createQuery("SELECT COUNT(DISTINCT sc.candidato.id) FROM CandidatoEntity c "
				+ "INNER JOIN c.statusCandidatos sc "
				+ "INNER JOIN c.avaliadores ac "
				+ "WHERE (sc.idStatusCandidato = (SELECT max(scc.idStatusCandidato) FROM StatusCandidatoEntity scc WHERE scc.candidato.id = c.id) "
				+ "AND (sc.status.id IN (?1) AND ac.status IS NOT NULL AND sc.flSituacao = true) "
				+ "OR (sc.status.id = ?2 AND ac.status IS NULL AND ac.usuario.id = ?3 AND sc.flSituacao = true)"
				+ "OR (sc.status.id = ?4 AND ac.status IS NULL AND sc.flSituacao = true)) ");
		
		query.setParameter(1, listaStatus);
		query.setParameter(2, statu);
		query.setParameter(3, idUsuario);
		query.setParameter(4, idStatusCandidatura);
		
		result = (long) query.getSingleResult();
		return result;
	}
}

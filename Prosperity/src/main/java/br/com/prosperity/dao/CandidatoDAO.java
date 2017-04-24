package br.com.prosperity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.CandidatoEntity;

@Repository
public class CandidatoDAO extends GenericDAOImpl<CandidatoEntity, Integer> {
	
	Session session;
	
	
	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public List<CandidatoEntity> findByCriteria(final List<Criterion> criterion) {
		List<CandidatoEntity> ret = null;
		try {
			ret = findByCriteria("id", true, -1, -1, criterion);
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
}

package br.com.prosperity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.CandidatoEntity;
import br.com.prosperity.entity.StatusCandidatoEntity;
import br.com.prosperity.entity.StatusVagaEntity;
import br.com.prosperity.entity.VagaEntity;

@Repository
public class CandidatoDAO extends GenericDAOImpl<CandidatoEntity, Integer> {
	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public List<CandidatoEntity> findByCriteria() {
		List<CandidatoEntity> ret = null;
		try {
			ret = findByCriteria(15);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<CandidatoEntity> findByCriteria(final int maxResults) {
		List<CandidatoEntity> result = null;

		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria crit = session.createCriteria(getEntityClass());

			if (maxResults > 0) {
				crit.setMaxResults(maxResults);
			}

			result = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}

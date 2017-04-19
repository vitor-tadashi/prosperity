
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

import br.com.prosperity.entity.StatusVagaEntity;
import br.com.prosperity.entity.VagaEntity;

@Repository
public class VagaDAO extends GenericDAOImpl<VagaEntity, Integer> {

	Session session;

	public static final int limitResultsPerPage =5;

	public List<StatusVagaEntity> pegarOsStatus() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(VagaEntity.class, "vaga");
		criteria.createAlias("vaga.statusVagaBean", "status");
		criteria.createAlias("status.situacao", "sit");
		criteria.add(Restrictions.eq("sit", true));

		return criteria.list();
	}

	public List<VagaEntity> findByCriteria(final List<Criterion> criterion) {
		List<VagaEntity> ret = null;
		try {
			ret = findByCriteria("id", true, -1, -1, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	public List<VagaEntity> paginar(Integer page, final List<Criterion> criterion) {
		List<VagaEntity> ret = null;
		try {
			ret = findByCriteria("id", true, (page * limitResultsPerPage) - (limitResultsPerPage), limitResultsPerPage, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	protected List<VagaEntity> findByCriteria(String propertyOrder, Boolean isDesc, final int firstResult,
			final int maxResults, final List<Criterion> criterion) {
		List<VagaEntity> result = null;

		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria crit = session.createCriteria(VagaEntity.class, "vaga");
			crit.createAlias("vaga.statusVagaEntity", "statusVaga");
			crit.createAlias("statusVaga.status", "status");
			crit.add(Restrictions.eq("statusVaga.situacao", true));

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

	public Long count(final String name) {
		Long result = null;

		try {
			javax.persistence.Query query = entityManager.createNamedQuery(name);

			result = (Long)query.getSingleResult();

		} catch (Exception e) {

		}

		return result;
	}

}

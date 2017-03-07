package br.com.prosperity.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;


public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	// ~ Instance fields
	// --------------------------------------------------------
	private Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {

		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public GenericDAOImpl(final Class<T> persistentClass) {
		super();
		this.entityClass = persistentClass;
	}

	// ~ Methods
	// ----------------------------------------------------------------

	@Override
	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public List<T> listar() {
		List<T> ret = null;
		try {
			ret = findByCriteria();
		} catch (Exception e) {

		}

		return ret;
	}

	@Override
	public List<T> findAll(String propertyOrder, Boolean isDesc) {
		List<T> ret = null;
		try {
			ret = findByCriteria(propertyOrder, isDesc);
		} catch (Exception e) {

		}

		return ret;
	}

	@Override
	public T obterPorId(final ID id) {
		T result = null;
		try {
			result = entityManager.find(entityClass, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(final String name, Object... params) {
		List<T> result = null;

		try {
			javax.persistence.Query query = entityManager.createNamedQuery(name);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			result = (List<T>) query.getResultList();
		} catch (Exception e) {

		}
		return result;
	}



	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(final Criterion... criterion) {
		List<T> ret = null;
		try {
			ret = findByCriteria(null, null, -1, -1, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(String propertyOrder, Boolean isDesc, final Criterion... criterion) {
		List<T> ret = null;
		try {
			ret = findByCriteria(propertyOrder, isDesc, -1, -1, criterion);
		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(String propertyOrder, Boolean isDesc, final int firstResult, final int maxResults, final Criterion... criterion) {
		List<T> result = null;

		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria crit = session.createCriteria(getEntityClass());

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

	protected int countByCriteria(Criterion... criterion) {

		Integer ret = null;

		Session session = (Session) entityManager.getDelegate();
		Criteria crit = session.createCriteria(getEntityClass());
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion) {
			crit.add(c);
		}
		ret = (Integer) crit.list().get(0);

		return ret;
	}

	@Override
	public void remover(T entity) {
		try {
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T adicionar(T entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public T alterar(T entity) {
		try {
			entityManager.merge(entity);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return entity;
	}

}
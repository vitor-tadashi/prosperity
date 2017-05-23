package br.com.prosperity.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, K extends Serializable> {

	Class<T> getEntityClass();

	T findById(final K id);

	List<T> findAll();

	List<T> findAll(String propertyOrder, Boolean isDesc);

	List<T> findByNamedQuery(final String queryName, Object... params);

	T insert(final T entity);

	void remove(final T entity);

	public T update(T entity);
}
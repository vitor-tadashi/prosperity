package br.com.prosperity.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, K extends Serializable> {

	Class<T> getEntityClass();

	T obterPorId(final K id);

	List<T> listar();

	List<T> findAll(String propertyOrder, Boolean isDesc);

	List<T> findByNamedQuery(final String queryName, Object... params);

	T adicionar(final T entity);

	void remover(final T entity);

	public T alterar(T entity);

}
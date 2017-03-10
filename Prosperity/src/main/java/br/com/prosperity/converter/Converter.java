package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

public interface Converter<E, B> {

	E convertBeanToEntity(B bean);

	B convertEntityToBean(E entity);
	
	default List<B> convertEntityToBean(List<E> entities) {
		List<B> beans = new ArrayList<B>();
		
		for(E entity : entities){
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}
	
	default List<E> convertBeanToEntity(List<B> beans) {
		List<E> entities = new ArrayList<E>();
		
		for(B bean : beans){
			entities.add(convertBeanToEntity(bean));
		}
		return entities;
	}

}
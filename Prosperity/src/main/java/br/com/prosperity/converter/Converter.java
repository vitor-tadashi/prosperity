package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

public interface Converter<E, B> {

	E convertBeanToEntity(B bean);

	B convertEntityToBean(E entity);
	
	List<B> convertEntityToBean(List<E> entities); 
	/*{
		List<B> beans = new ArrayList<B>();
		
		for(E entity : entities){
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}*/

}
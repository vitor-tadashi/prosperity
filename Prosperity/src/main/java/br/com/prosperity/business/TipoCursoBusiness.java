package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import br.com.prosperity.bean.TipoCursoBean;

import br.com.prosperity.converter.TipoCursoConverter;

import br.com.prosperity.dao.TipoCursoDAO;


@Component
public class TipoCursoBusiness {
	@Autowired
	private TipoCursoDAO tipoCursoDAO;
	
	@Autowired
	private TipoCursoConverter tipoCursoConverter;
	
	@Transactional
	public List<TipoCursoBean> getTipoCurso(){
	
		List<TipoCursoBean> tiposCurso = tipoCursoConverter.convertEntityToBean(tipoCursoDAO.listar()) ;
		
		return tiposCurso;
		
	}

	

}

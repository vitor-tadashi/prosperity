package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.prosperity.entity.AvaliadorEntity;

public class AvaliadorDAO extends GenericDAOImpl<AvaliadorEntity, Integer>{

	public AvaliadorEntity buscarAvaliadorPorId(int id){
		
		TypedQuery <AvaliadorEntity> query = entityManager
				.createQuery("SELECT c FROM AvaliadorEntity AS c WHERE c.id = :id AND c.ativo = 'S'", AvaliadorEntity.class);
		query.setParameter("id", id);
		List<AvaliadorEntity> listaAvaliador = query.getResultList();
		if (listaAvaliador.isEmpty()) {
			return null;
		} else {
			return listaAvaliador.get(0);
		}
		//return super.obterPorId(id);
	}
}

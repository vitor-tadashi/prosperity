package br.com.prosperity.dao;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAOImpl<UsuarioEntity, Integer> {
	
	public Integer obterPorUsuario(String nome){
		Integer id=null;
		Query query = entityManager.createQuery("Select u.id FROM UsuarioEntity AS u WHERE u.nome = :nome");
		query.setParameter("nome", nome);
		id = (Integer) query.getSingleResult();
		return id;
	}
	
	public UsuarioEntity obterPorUsuario(UsuarioEntity usuarioEntity) {
		TypedQuery<UsuarioEntity> query = entityManager.createQuery(
				"SELECT u.nome FROM UsuarioEntity AS u WHERE u.nome = :nome", UsuarioEntity.class);
		query.setParameter("nome", usuarioEntity.getNome());
		
		System.out.println(query.toString());
		
		if(query.getSingleResult()!=null){
			return usuarioEntity;
		}
		else{
			return null;
		}
	}
}

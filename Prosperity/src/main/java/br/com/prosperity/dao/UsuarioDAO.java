package br.com.prosperity.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAOImpl<UsuarioEntity, Integer> {
	
	public UsuarioEntity obterPorUsuario(UsuarioEntity usuarioEntity) {
		TypedQuery<UsuarioEntity> query = entityManager.createQuery(
				"SELECT u.nome, u.senha FROM UsuarioEntity AS u WHERE u.nome = :nome", UsuarioEntity.class);
		query.setParameter("nome", usuarioEntity.getNome());
		
		if(query.getSingleResult()!=null){
			return usuarioEntity;
		}
		else{
			return null;
		}
	}
}

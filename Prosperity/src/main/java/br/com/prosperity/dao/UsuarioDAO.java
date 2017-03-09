package br.com.prosperity.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAOImpl<UsuarioEntity, Integer> {
	
	public UsuarioEntity obterPorUsuario(UsuarioEntity usuarioEntity) {
		TypedQuery<UsuarioEntity> query = entityManager.createQuery(
				"SELECT u FROM tbUsuario u WHERE u.nmUsuario = :nmUsuario",
				UsuarioEntity.class);
		query.setParameter("nmUsuario", usuarioEntity.getNome());
		
		if(query.getSingleResult()!=null){
			return usuarioEntity = query.getSingleResult();
		}
		else{
			return null;
		}
	}
}

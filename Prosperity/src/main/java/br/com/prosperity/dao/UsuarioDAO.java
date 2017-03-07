package br.com.prosperity.dao;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.UsuarioEntity;

//@Repository
public class UsuarioDAO/* extends GenericDAOImpl<UsuarioEntity, Integer> */{
/*
	public UsuarioEntity obterPorUsuario(String nmUsuario, String senha) {
		TypedQuery<UsuarioEntity> query = entityManager.createQuery(
				"SELECT u FROM tbUsuario AS u WHERE u.nmUsuario = :nmUsuario AND u.senha = :senha",
				UsuarioEntity.class);
		query.setParameter("nmUsuario", nmUsuario);
		query.setParameter("senha", senha);
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(nmUsuario);
		usuarioEntity.setSenha(senha);
		return usuarioEntity;
	}
	*/
}

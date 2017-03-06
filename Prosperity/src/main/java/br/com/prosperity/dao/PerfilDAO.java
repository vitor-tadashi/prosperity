package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import br.com.prosperity.entity.PerfilEntity;

public class PerfilDAO extends GenericDAOImpl<PerfilEntity, Integer>{
		
		public List <PerfilEntity> listar(){
				TypedQuery<PerfilEntity> query = entityManager.createQuery("SELECT u FROM PerfilBean AS u WHERE u.ativo = 'S'", PerfilEntity.class);
						List<PerfilEntity> listaPerfis = query.getResultList();
				return listaPerfis;
			} 
		
			public PerfilEntity obterPorTipo(String tipo) {
					<PerfilEntity> query = entityManager
						.createQuery("SELECT u FROM PerfilBean AS u WHERE u.tipo = :tipo AND u.ativo = 'S'", PerfilEntity.class);
				query.setParameter("tipo", tipo);
				List<PerfilEntity> listaPerfil = query.getResultList();
				if (listaPerfil.isEmpty()) {
					return null;
				} else {
					return listaPerfil.get(0);
					}
				}
				
				public PerfilEntity obterPorId(int id) {
					TypedQuery<PerfilEntity> query = entityManager
							.createQuery("SELECT p FROM PerfilBean AS p WHERE p.id = :id AND p.ativo = 'S'", PerfilEntity.class);
					query.setParameter("id", id);
					List<PerfilEntity> listaPerfil = query.getResultList();
					if (listaPerfil.isEmpty()) {
						return null;
					} else {
						return listaPerfil.get(0);
					}
	}
		

	}



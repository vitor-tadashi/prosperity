package br.com.prosperity.dao;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.VagaCandidatoEntity;

@Repository
public class VagaCandidatoDAO extends GenericDAOImpl<VagaCandidatoEntity, Integer> {
	public Long count(final String name) {
		Long result = null;

		try {
			javax.persistence.Query query = entityManager.createNamedQuery(name);

			result = (Long) query.getSingleResult();

		} catch (Exception e) {

		}

		return result;
	}
}
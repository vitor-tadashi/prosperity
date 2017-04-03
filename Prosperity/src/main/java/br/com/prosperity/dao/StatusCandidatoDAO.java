package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.StatusCandidatoEntity;

@Repository
public class StatusCandidatoDAO extends GenericDAOImpl<StatusCandidatoEntity, Integer> {
	public List<StatusCandidatoEntity> listar(Integer id) {
		TypedQuery<StatusCandidatoEntity> query = entityManager.createQuery(
				"SELECT u FROM StatusCandidatoEntity u WHERE u.idCandidato = :id ORDER BY u.dtAlteracao DESC",
				StatusCandidatoEntity.class);
		query.setParameter("id", id);

		List<StatusCandidatoEntity> lista = query.getResultList();

		return lista;
	}
}

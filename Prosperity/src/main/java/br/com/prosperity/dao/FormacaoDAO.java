package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.FormacaoEntity;

@Repository
public class FormacaoDAO extends GenericDAOImpl<FormacaoEntity, Integer> {

	/**
	 * -JPQL- Retorna uma lista com todas as informaçoes ATIVAS da tabela de
	 * formação
	 * 
	 * @param no
	 *            parameters
	 * @return listaCliente (retorna a lista de formação)
	 */
	@Override
	public List<FormacaoEntity> findAll() {
		TypedQuery<FormacaoEntity> query = entityManager.createQuery("SELECT formacao FROM tbFormacao AS formacao",
				FormacaoEntity.class);
		List<FormacaoEntity> listaFormacao = query.getResultList();
		return listaFormacao;
	}

	/**
	 * -JPQL- Retorna uma lista de Formação ATIVOS (buscado através do ID
	 * passado como parâmetro)
	 * 
	 * @param idCliente
	 * @return List<FormacaoEntity>
	 */
	@Override
	public FormacaoEntity findById(Integer idCurso) {
		TypedQuery<FormacaoEntity> query = entityManager.createQuery(
				"SELECT formacao FROM tbFormacao AS formacao WHERE formacao.id = :id", FormacaoEntity.class);
		return query.setParameter("id", idCurso).getResultList().get(0);
	}

}

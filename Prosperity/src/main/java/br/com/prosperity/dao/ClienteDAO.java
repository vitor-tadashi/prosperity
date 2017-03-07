package br.com.prosperity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.prosperity.entity.ClienteEntity;

@Repository
public class ClienteDAO extends GenericDAOImpl <ClienteEntity, Integer> {
	/**
	 * -JPQL- Retorna uma lista com todos os Clientes ATIVOS da tabela de
	 * Clientes
	 * 
	 * @param no
	 *            parameters
	 * @return listaCliente (retorna a lista de clientes)
	 */
	public List<ClienteEntity> listar() {
		TypedQuery<ClienteEntity> query = entityManager.createQuery("SELECT c FROM tbCliente AS c", ClienteEntity.class);
		List<ClienteEntity> listaCliente = query.getResultList();
		return listaCliente;
	}
	
	/**
	 * -JPQL- Retorna uma lista de Clientes ATIVOS (buscado através do ID
	 * passado como parâmetro)
	 * 
	 * @param idCliente
	 * @return List<ClienteBean>
	 */
	@Override
	public ClienteEntity obterPorId(Integer idCliente) {
		TypedQuery<ClienteEntity> query = entityManager.createQuery("SELECT c FROM tbCliente AS c WHERE c.id = :id", ClienteEntity.class);
		return query.setParameter("id", idCliente).getResultList().get(0);
	}
}

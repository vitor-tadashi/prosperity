package br.com.prosperity.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.prosperity.entity.SenioridadeEntity;
import br.com.prosperity.utils.JPAUtil;

public class TestaJPA {

	/*private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("JPA_EFICAZ_HIBERNATE");*/

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			SenioridadeEntity entity = new SenioridadeEntity();
			
			entity.setDescricao("Teste");
			entityManager.persist(entity);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}

package br.com.prosperity.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.prosperity.entity.SenioridadeEntity;
import br.com.prosperity.utils.JPAUtil;

public class TestaJPA2 {

	/*private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("JPA_EFICAZ_HIBERNATE");*/

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			SenioridadeEntity entity = new SenioridadeEntity();
			entity.setId(1);
			
			SenioridadeEntity find = entityManager.find(SenioridadeEntity.class, 1);
			
			System.out.println("ID: " + find.getId() + " Descrição:" + find.getDescricao());
			
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

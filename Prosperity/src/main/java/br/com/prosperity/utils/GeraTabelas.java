package br.com.prosperity.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("prosperity2-persistence-unit");
		factory.close();
	}
}

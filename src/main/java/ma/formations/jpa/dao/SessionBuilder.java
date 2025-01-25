package ma.formations.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionBuilder {
	private static EntityManagerFactory sessionfactory;

	private SessionBuilder() {
	}

	public static EntityManagerFactory getSessionfactory() {
		if (sessionfactory == null) {
			sessionfactory = Persistence.createEntityManagerFactory("UNITE1");
		}
		return sessionfactory;
	}

	public EntityManager openSession() {
		return getSessionfactory().createEntityManager();
	}

}

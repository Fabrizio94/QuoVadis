package quovadis.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
	
	private static EntityManagerFactory emf;
	
	private EntityManagerSingleton() {
		
	}

	public static EntityManagerFactory getInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("QuoVadis");
		}
		return emf;
	}
}


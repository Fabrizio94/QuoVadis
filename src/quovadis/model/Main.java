package quovadis.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuoVadis");
	EntityManager em = emf.createEntityManager();
	
	QuoVadis quoVadis = new QuoVadis();
	
}

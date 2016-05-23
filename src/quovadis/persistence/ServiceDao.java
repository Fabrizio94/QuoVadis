package quovadis.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import quovadis.model.Service;

public class ServiceDao implements Dao<Service>{
	
	
	@Override
	public void save(EntityManagerFactory emf, Service s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(s);
		tx.commit();
		em.close();		
	}

	@Override
	public void update(EntityManagerFactory emf, Service s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Service findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityManagerFactory emf, Service s) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<Service> result = em.createNamedQuery("Service.findAll").getResultList();
		em.close();
		return result;
	}

}

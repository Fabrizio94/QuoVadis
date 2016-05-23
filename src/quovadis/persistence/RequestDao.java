package quovadis.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import quovadis.model.Request;

public class RequestDao implements Dao<Request>{

	@Override
	public void save(EntityManagerFactory emf, Request r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(r);
		tx.commit();
		em.close();
		
	}

	@Override
	public void update(EntityManagerFactory emf, Request r) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(r);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(EntityManagerFactory emf, Request r) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<Request> result = em.createNamedQuery("Request.findAll").getResultList();
		em.close();
		return result;
	}

	@Override
	public Request findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

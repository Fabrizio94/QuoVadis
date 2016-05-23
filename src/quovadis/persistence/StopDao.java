package quovadis.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import quovadis.model.Stop;

public class StopDao implements Dao<Stop> {

	@Override
	public void save(EntityManagerFactory emf, Stop s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(s);
		tx.commit();
		em.close();		
	}

	@Override
	public void update(EntityManagerFactory emf, Stop entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stop findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityManagerFactory emf, Stop entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stop> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<Stop> result = em.createNamedQuery("Stop.findAll").getResultList();
		em.close();
		return result;
	}

}

package quovadis.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import quovadis.model.Suggestion;

public class SuggestionDao implements Dao<Suggestion> {

	@Override
	public void save(EntityManagerFactory emf, Suggestion s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(s);
		tx.commit();
		em.close();
	}

	@Override
	public void update(EntityManagerFactory emf, Suggestion s) {
		// TODO Auto-generated method stub

	}

	@Override
	public Suggestion findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityManagerFactory emf, Suggestion s) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suggestion> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<Suggestion> result = em.createNamedQuery("Suggestion.findAll").getResultList();
		em.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getTags(EntityManagerFactory emf, Suggestion s){
		EntityManager em = emf.createEntityManager();
		List<String> result = em.createNamedQuery("Suggestion.getTags").getResultList();
		em.close();
		return result;
	}

}

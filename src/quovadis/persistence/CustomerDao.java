package quovadis.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import quovadis.model.Customer;


public class CustomerDao implements Dao<Customer>{
	

	public CustomerDao(){}


	@Override
	public void save(EntityManagerFactory emf,Customer c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
	}

	@Override
	public void update(EntityManagerFactory emf, Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityManagerFactory emf, Customer c) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<Customer> result = em.createNamedQuery("User.findAll").getResultList();
		em.close();
		return result;
	}

}

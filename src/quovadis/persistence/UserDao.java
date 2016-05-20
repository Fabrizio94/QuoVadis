package quovadis.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import quovadis.model.User;

public class UserDao implements Dao<User>{
	

	
	public UserDao() {
		
	}


	@Override
	public void save(EntityManagerFactory emf,User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
		em.close();
	}

	@Override
	public void update(EntityManagerFactory emf, User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(EntityManagerFactory emf, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityManagerFactory emf, User u) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		List<User> result = em.createNamedQuery("User.findAll").getResultList();
		em.close();
		return result;
	}

}

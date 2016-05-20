package quovadis.persistence;

import java.util.List;

import javax.persistence.EntityManagerFactory;

public interface Dao<T> {

	public void save(EntityManagerFactory emf, T entity);
	
	public void update(EntityManagerFactory emf, T entity);
	
	public T findById(EntityManagerFactory emf, long id);
	
	public void delete(EntityManagerFactory emf, T entity);
	
	public List<T> findAll(EntityManagerFactory emf);
}

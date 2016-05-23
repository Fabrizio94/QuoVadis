package quovadis.model;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import quovadis.persistence.ServiceDao;


@Entity
public class Stop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String description;
	@ManyToMany
	private List<Service> services;
	
	private ServiceDao serviceDAOImp;
	
	EntityManagerFactory emf = EntityManagerSingleton.getInstance();
	
	
	public Stop(String title, String description){
		this.title = title;
		this.description = description;
		services = new LinkedList<Service>();
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addService(Service s){
		serviceDAOImp.save(emf,s);
	}
}
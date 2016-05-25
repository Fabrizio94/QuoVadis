package quovadis.model;
//ciao
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import quovadis.persistence.RequestDao;

@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String message;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Suggestion suggestion;
	
	private RequestDao requestDAOImp;
	
	EntityManagerFactory emf = EntityManagerSingleton.getInstance();
	
	public Request(Customer customer, String title, String message){
		this.customer = customer;
		this.title = title;
		this.message = message;
	}
	
	public Request(){
		
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}

	public Suggestion getSuggestion() {
		return this.suggestion;
	}

	public void addSuggestion(Suggestion s) {
		this.suggestion = s;		
		requestDAOImp.update(emf, this);
	}
	
}

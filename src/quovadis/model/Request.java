package quovadis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public abstract class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String message;
	
	@OneToOne
	private Customer customer;
	
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
	
}

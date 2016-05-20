package quovadis.model;

import java.util.List;

import javax.persistence.OneToMany;


public class Customer extends User {


	@OneToMany
	private List<Request> requests;
	
	
	public Customer(String name, String surname, String username, String password, String email) {
		super(name, surname, username, password, email);
		// TODO Auto-generated constructor stub
	}
	
	
	
}

package quovadis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name = "User.findRequests", query = "Select r FROM Request r, User u WHERE r.id = u.id ")
public class Customer extends User {


	@OneToMany(mappedBy= "customer")
	private List<Request> requests;
	
	private Map<Long,Suggestion> wishList; 
	
	public Customer(String name, String surname, String username, String password, String email) {
		super(name, surname, username, password, email);
		wishList = new HashMap<Long, Suggestion>();
	}
	
	
	public void addRequest(Request r){
		requests.add(r);
		wishList.put(r.getSuggestion().getId(),r.getSuggestion());
	}
	
}

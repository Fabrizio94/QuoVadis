package quovadis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import quovadis.model.Deal;

import javax.persistence.OneToMany;


public class Customer extends User {


	@OneToMany
	private List<Request> requests;
	private Map<Long,Suggestion> wishList; 
	
	public Customer(String name, String surname, String username, String password, String email) {
		super(name, surname, username, password, email);
		wishList = new HashMap<Long, Suggestion>();
	}
	
	
	public void addDeal(Deal d){
		requests.add(d);
		wishList.put(d.getSuggestion().getId(),d.getSuggestion());
	}
	
	public void addPersonalRequest(PersonalRequest pr){
		requests.add(pr);
	}
}

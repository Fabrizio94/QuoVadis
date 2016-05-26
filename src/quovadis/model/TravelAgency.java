package quovadis.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import quovadis.persistence.CustomerDao;
import quovadis.persistence.RequestDao;
import quovadis.persistence.SuggestionDao;


public class TravelAgency {
		
	List<Suggestion> suggestions;
	List<Request> requests;
	List<Customer> customers;
	CustomerDao customerDAOImp;
	SuggestionDao suggestionDAOImp;
	RequestDao requestDAOImp;
	
	
	EntityManagerFactory emf = EntityManagerSingleton.getInstance();
	
	public TravelAgency(){
		suggestions = new LinkedList<Suggestion>();
		requests = new LinkedList<Request>();
		customers = new LinkedList<Customer>();
		customerDAOImp = new CustomerDao();
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}
	
	public List<Request> getRequests() {
		return requests;
	}
	
	public boolean checkSubscription(String username, String email) {
		boolean ret = true;
		customers = customerDAOImp.findAll(emf);
		
		for(Customer c : customers){
			if(c.getUsername().equals(username))
				return false;
			if(c.getEmail().equals(email))
				return false;
		}
		return ret;
		
		
	}
	
	public void addCustomer(Customer c) {
		
		customerDAOImp.save(emf, c);
	}
	
	public Customer getCustomer(String username){
		customers = customerDAOImp.findAll(emf);
		for(Customer c : customers)
			if(c.getUsername().equals(username))
				return c;
		return null;
	}

	public Map<Long, Suggestion> findSuggestions(String tag) {
		Map<Long,Suggestion> result = new HashMap<Long,Suggestion>();
		suggestions = suggestionDAOImp.findAll(emf);
		for(Suggestion s : suggestions)
			if(s.getTags().contains(tag))
				result.put(s.getId(),s);
		return result;
	}
	
	public void addRequest(Request r){
		requestDAOImp.save(emf,r);
	}

	public void addSuggestion(Suggestion s) {
		suggestionDAOImp.save(emf, s);
	}
	
	
}

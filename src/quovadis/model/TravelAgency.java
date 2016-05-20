package quovadis.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import quovadis.persistence.UserDao;

public class TravelAgency {
		
	List<Suggestion> suggestions;
	List<PersonalRequest> personalRequests;
	List<Deal> deals;
	List<User> users;
	UserDao userDAOImp;

	EntityManagerFactory emf = EntityManagerSingleton.getInstance();
	
	public TravelAgency(){
		suggestions = new LinkedList<Suggestion>();
		personalRequests = new LinkedList<PersonalRequest>();
		deals = new LinkedList<Deal>();
		users = new LinkedList<User>();
		userDAOImp = new UserDao();
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}
	public List<PersonalRequest> getPersonalRequests() {
		return personalRequests;
	}
	public void setPersonalRequests(List<PersonalRequest> personalRequests) {
		this.personalRequests = personalRequests;
	}
	public List<Deal> getDeals() {
		return deals;
	}
	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
	public boolean checkSubscription(String username, String email) {
		boolean ret = true;
		users = userDAOImp.findAll(emf);
		
		for(User u : users){
			if(u.getUsername().equals(username))
				return false;
			if(u.getEmail().equals(email))
				return false;
		}
		return ret;
		
		
	}
	
	public void createCustomer(String name, String surname, String username, String password, String email) {
		User u = new Customer(name,surname,username,password,email);
		userDAOImp.save(emf, u);
	}
	
	public User getUser(String username){
		for(User u : users)
			if(u.getUsername().equals(username))
				return u;
		return null;
	}

	public Map<Long, Suggestion> findSuggestions(String tag) {
		Map<Long,Suggestion> result = new HashMap<Long,Suggestion>();
		for(Suggestion s : suggestions)
			if(s.getTags().contains(tag))
				result.put(s.getId(),s);
		return result;
	}
	
	public void addDeal(Deal d){
		deals.add(d);
	}
	
	public void addPersonalRequest(PersonalRequest pr){
		personalRequests.add(pr);
	}
}

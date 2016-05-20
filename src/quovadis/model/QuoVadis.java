package quovadis.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QuoVadis {
	
	private TravelAgency agency;
	private Suggestion currentSuggestion;
	private Map<Long, Suggestion> currentResults;
	private User currentUser;
	private Stop currentStop;
	
	public QuoVadis(){
		agency = new TravelAgency();
		currentSuggestion = new Suggestion();
		currentResults = new HashMap<Long,Suggestion>();
	}
	
	
	public TravelAgency getAgency() {
		return agency;
	}
	public void setAgency(TravelAgency agency) {
		this.agency = agency;
	}
	public Suggestion getCurrentSuggestion() {
		return currentSuggestion;
	}
	public void setCurrentSuggestion(Suggestion currentSuggestion) {
		this.currentSuggestion = currentSuggestion;
	}
	public Map<Long,Suggestion> getCurrentResults() {
		return currentResults;
	}
	public void setCurrentResults(HashMap<Long,Suggestion> currentResults) {
		this.currentResults = currentResults;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public Stop getCurrentStop() {
		return currentStop;
	}
	public void setCurrentStop(Stop currentStop) {
		this.currentStop = currentStop;
	}
	
	public void subscribe(String name, String surname, String username, String password, String email){
		if(this.agency.checkSubscription(username,email)) //controllo i dati, true se non presenti
			this.agency.createUser(name,surname,username,password,email);
		else
			System.out.println("Username/Email già esistenti");
	}
	
	public void login(String username, String password){
		User u = this.agency.getUser(username);
		if(u != null)
			if(u.checkPassword(password))
				this.currentUser = u;
		else
			System.out.println("login fallito");
	}
	
	public void findSuggestions(String tag){
		Map<Long,Suggestion> result = this.agency.findSuggestions(tag);
		if(result.isEmpty())
			System.out.println("lista vuota");
		this.currentResults = result;
	}
	
	public void selectSuggestion(long id){
		this.currentSuggestion = currentResults.get(id);
	}
	
	
}

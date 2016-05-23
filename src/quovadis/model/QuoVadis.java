package quovadis.model;

import java.util.HashMap;
import java.util.Map;

public class QuoVadis {
	
	private TravelAgency agency;
	private Suggestion currentSuggestion;
	private Map<Long, Suggestion> currentResults;
	private Stop currentStop;
	private Customer currentCustomer;
	private Admin currentAdmin;
	private Request currentRequest;
	
	public Admin getCurrentAdmin() {
		return currentAdmin;
	}


	public void setCurrentAdmin(Admin currentAdmin) {
		this.currentAdmin = currentAdmin;
	}


	public void setCurrentResults(Map<Long, Suggestion> currentResults) {
		this.currentResults = currentResults;
	}


	public QuoVadis(){
		agency = new TravelAgency();
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
	public User getCurrentCustomer() {
		return currentCustomer;
	}
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	public Stop getCurrentStop() {
		return currentStop;
	}
	public void setCurrentStop(Stop currentStop) {
		this.currentStop = currentStop;
	}
	
	public void subscribe(String name, String surname, String username, String password, String email){
		if(this.agency.checkSubscription(username,email)) //controllo i dati, true se non presenti
			this.agency.createCustomer(name,surname,username,password,email);
		else
			System.out.println("Username/Email già esistenti");
	}
	
	public void login(String username, String password) throws ClassNotFoundException{
		User u = this.agency.getUser(username);
		if(u != null && u.checkPassword(password))
			if(u.getClass() == Class.forName("quovadis.model.Customer"))
				this.currentCustomer = (Customer) u;
			else
				this.currentAdmin = (Admin) u;
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
	
	public void makeRequest(String title, String message){
		Request r = new Request(currentCustomer, title, message);
		this.agency.addRequest(r);
		this.currentCustomer.addRequest(r);
		this.currentRequest = r;
	}
	
	public void associateSuggestionToRequest(){
		this.currentRequest.addSuggestion(this.currentSuggestion);
	}
	
	public void createSuggestion(String title, String period, double cost){
		Suggestion s = new Suggestion(title, period,cost);
		this.currentSuggestion = s;
	}
	
	public void createStop(String title, String description){
		Stop s = new Stop(title, description);
		this.currentStop = s;
		
	}
	
	public void createService(double cost, String typology, String description){
		Service s = new Service(cost, typology, description);
		this.currentStop.addService(s);
	}
	
	public void saveStop(){
		this.currentSuggestion.addStop(currentStop);
		
		
	}
	
	public void saveSuggestion(){
		this.agency.addSuggestion(this.currentSuggestion);
	}
	
	
	
}

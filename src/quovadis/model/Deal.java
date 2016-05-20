package quovadis.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Deal extends Request {
	
	@OneToOne
	private Suggestion suggestion;
	
	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public Deal(Customer customer, Suggestion s, String title, String message){
		super(customer,title,message);
		
	}
	
	public Deal(){
		super();
	}
	
	
	
}

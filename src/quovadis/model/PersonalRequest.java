package quovadis.model;

import javax.persistence.Entity;

@Entity

public class PersonalRequest extends Request {

	public PersonalRequest(Customer customer, String title, String message) {
		super(customer, title, message);
	}
	
}

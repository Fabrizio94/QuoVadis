package quovadis.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Deal extends Request {
	
	@OneToOne
	private Suggestion suggestion;
	
}

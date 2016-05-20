package quovadis.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {
	
	
	@Column (nullable = false)
	private String name;
	
	@Column (nullable = false)
	private String surname;
	
	@Column (nullable = false)
	private String username;

	@Column (nullable = false)
	private String password;
	
	@Column (nullable = false)
	private String email;
	
	@OneToMany
	private Map<Integer,Suggestion> wishList; 
	
	 
		public User(String name, String surname, String username, String password, String email) {
			this.name = name;
			this.surname = surname;
			this.username = username;
			this.password = password;
			this.email = email;
			wishList = new HashMap<Integer,Suggestion>();
	}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getSurname() {
			return surname;
		}
		
		public void setSurname(String surname) {
			this.surname = surname;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}

		public boolean checkPassword(String password) {
			return this.password.equals(password);
		} 
}

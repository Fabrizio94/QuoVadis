package quovadis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User.findAll", query = "select u from User u")
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
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
	
	
	 
		public User(String name, String surname, String username, String password, String email) {
			this.name = name;
			this.surname = surname;
			this.username = username;
			this.password = password;
			this.email = email;
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
		
		public long getId(){
			return this.id;
		}
}

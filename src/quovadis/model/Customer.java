package quovadis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQuery(name = "User.findRequests", query = "Select r FROM Request r, Customer c WHERE c.id = c.id ")

public class Customer{
	
	public Customer(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String surname;
	@Column(nullable=false)
	private String username; 
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;

	@OneToMany(mappedBy= "customer")
	private List<Request> requests;
	
	private Map<Long,Suggestion> wishList; 
	
	public Customer(String name, String surname, String username, String password, String email) {
		this.name= name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.email = email;
		wishList = new HashMap<Long, Suggestion>();
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Request> getRequests() {
		return requests;
	}


	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}


	public Map<Long, Suggestion> getWishList() {
		return wishList;
	}


	public void setWishList(Map<Long, Suggestion> wishList) {
		this.wishList = wishList;
	}


	public void addRequest(Request r){
		requests.add(r);
		wishList.put(r.getSuggestion().getId(),r.getSuggestion());
	}


	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
}

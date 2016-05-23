package quovadis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Service {
	
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private String typology;
	@Column(nullable = false)
	private String description;
	@OneToMany
	private Stop stop;
	
	public Service(double cost, String typology, String description){
		this.cost = cost;
		this.typology = typology;
		this.description = description;
	}
	
	public double getCost(){
		return this.cost;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public String getTypology(){
		return this.typology;
	}
	
	public void setTypology(String typology){
		this.typology = typology;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description; 
	}
}

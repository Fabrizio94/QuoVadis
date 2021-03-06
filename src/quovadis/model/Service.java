package quovadis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private String typology;
	@Column(nullable = false)
	private String description;
	public Service(){}
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

package quovadis.model;

public class Services {
	
	private double cost;
	private String typology;
	private String description;
	
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

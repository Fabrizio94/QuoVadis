package quovadis.model;

public class Order {
	
	private String title;
	private double price;
	private String period; // STESSO DISCORSO DI SUGGESTION, LO GESTIAMO COME STRINGA?
	private String description;
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getPeriod(){
		return this.period;
	}
	
	public void setPeriod(String period){
		this.period = period;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}

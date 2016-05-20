package quovadis.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Suggestion {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String period; //meglio data inizio e fine oppure periodo ad esempio stagione
	@Column(nullable=false)
	private String duration; //come la gestiamo la durata? numero di giorni o stringa ?  TIMETABLE?
	@Column(nullable=false)
	private double indicativeCost;
	@ElementCollection
	@CollectionTable(name = "tag")
	private List<String> tags;

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getPeriod(){
		return this.period;
	}

	public void setPeriod(String period){
		this.period = period;
	}

	public String getDuration(){
		return this.duration;
	}

	public void setDuration(String duration){
		this.duration = duration;
	}

	public double getIndicativeCost(){
		return this.indicativeCost;
	}

	public void setIndicativeCost(double indicativeCost){
		this.indicativeCost = indicativeCost;
	}

	public List<String> getTags(){
		return this.tags;
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}
}

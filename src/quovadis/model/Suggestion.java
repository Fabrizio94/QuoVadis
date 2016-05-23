package quovadis.model;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import quovadis.persistence.StopDao;
import quovadis.persistence.SuggestionDao;


@Entity
@NamedQueries({
	@NamedQuery(name = "Suggestion.findAll", query = "select s from Suggestion s"),
	@NamedQuery(name = "Suggestion.getTags", query = "select s from Suggestion s JOIN s.tags where Suggestion_id = s.id")
})

public class Suggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String period; 
	@Column(nullable=false)
	private double indicativeCost;
	@OneToMany
	private List<Stop> stops;
	@ElementCollection
	@CollectionTable(name = "tags")
	private List<String> tags;
	
	EntityManagerFactory emf = EntityManagerSingleton.getInstance();

	
	private SuggestionDao suggestionDAOImp;
	private StopDao stopDAOImp;

	public Suggestion(String title, String period, double cost){
		this.title = title;
		this.period = period;
		this.indicativeCost = cost;
		tags = new LinkedList<String>();
	}
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
	public double getIndicativeCost(){
		return this.indicativeCost;
	}
	public void setIndicativeCost(double indicativeCost){
		this.indicativeCost = indicativeCost;
	}
	public List<String> getTags(){
		this.tags = suggestionDAOImp.getTags(emf, this);
		return this.tags;
	}

	public long getId(){
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	public void addStop(Stop s){
		stopDAOImp.save(emf,s);
	}
}

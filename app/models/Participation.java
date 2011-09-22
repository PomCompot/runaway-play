package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Participation extends Model {
	@ManyToOne
	public Person person;
	
	
	public String uniqueIdentifier;
	
	
	public int absoluteRank;
	
	
	public String score;
	
	@ManyToOne
	public Club club;
	
	@ManyToOne
	public Event event;
	
	@OneToOne
	public Town town;
	
	@ManyToOne
	public Categorie categorie;
}

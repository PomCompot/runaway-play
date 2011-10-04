package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import play.db.jpa.Model;

@Entity
public class Participation extends Model {
	@ManyToOne
	public Person person;
	
	public String uniqueIdentifier;
	
	public int absoluteRank;
	
	@ManyToOne
	public Club club;
	
	@ManyToOne
	public Event event;
	
	@ManyToOne
	public Categorie categorie;
	
//	@OneToOne
	public Result result;
}

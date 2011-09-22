package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Club extends Model {
	
	public String noun;
	
	@OneToOne
	public Town town;
	
	@Override
	public String toString() {
		return noun;
	}
}

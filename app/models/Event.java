package models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.joda.time.LocalDate;

import play.db.jpa.Model;

@Entity
public class Event extends Model {
	
	public String noun;
	
	
	public LocalDate date;
	
	@OneToMany
	public Collection<Participation> participations;
	
	@Override
	public String toString() {
		return noun;
	}
}

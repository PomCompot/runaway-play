package models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.joda.time.LocalDate;

import play.db.jpa.Model;

@Entity
public class Person extends Model {
	
	public String firstname;
	
	
	public String lastname;
	
	
	public LocalDate birthday;
	
	
	public String mail;
	
	@ManyToOne
	public Town town;
	
	@OneToMany
	public Collection<Participation> participations;
	
	@Override
	public String toString() {
		return lastname + ' ' + firstname;
	}
}

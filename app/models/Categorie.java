package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Categorie extends Model {
	
	public String noun;
	
	@Override
	public String toString() {
		return noun;
	}
}
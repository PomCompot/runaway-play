package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import org.joda.time.LocalTime;

import play.db.jpa.Model;

@Entity
public class Result extends Model {
	
	public Long time;
	
	@OneToOne
	public Participation participation;
	
	@Override
	public String toString() {
		return time == null ? null : time.toString();
	}
}

package controllers;

import java.util.Collection;
import java.util.List;

import models.Participation;
import models.Result;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.validation.Required;
import play.db.jpa.JPABase;
import play.mvc.Controller;

public class Application extends Controller {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void index() {
        render();
    }
    
    public static void createEvent() {
    	render();
    }
    
    public static void test() {
    	logger.info("Deleting all existing results.");
    	Result.deleteAll();
    	render();
    }
    
    public static void tick(@Required Long time, String number) {
    	logger.info("Time: {}", time);
    	String lastTime = flash.get("lastTime");
    	if (lastTime != null) {
    		logger.info("Storing last time {} for current passed number {}.", lastTime, number);
    		Result lastResult = Result.find("order by time desc").first();
	    	Participation associatedParticipation = null;
	    	if (!"".equals(number)) {
	    		List<Participation> participations = Participation.find("byUniqueIdentifier", number).fetch();
	    		if (!participations.isEmpty()) {
	    			associatedParticipation = participations.get(0);
	    		}
	    	}
	    	lastResult.participation = associatedParticipation;
	    	lastResult.save();
    	}
    	Result result = new Result();
    	result.time = time;
    	result.save();
    	flash("lastTime", time);
    }
    
    public static void cancel() {
    	logger.info("Canceling last time.");
    }
    
    public static void results() {
    	// Keep lastTime in life
    	flash("lastTime", flash.get("lastTime"));
    	
    	Collection<JPABase> results = Result.findAll();
    	logger.info("Results size: {}", results.size());
    	render(results, flash.get("lastTime"));
    }
}
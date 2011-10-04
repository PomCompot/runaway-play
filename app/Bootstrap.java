import models.Person;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	@Override
	public void doJob() throws Exception {
		if (Person.findAll().size() == 0) {
			Fixtures.loadModels("initialData.yml");
		}
	}
}

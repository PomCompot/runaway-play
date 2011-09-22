import models.Categorie;

import org.junit.Test;

import play.test.UnitTest;


public class CategorieTest extends UnitTest {
	@Test
	public void createCategorie() {
		Categorie categorie = new Categorie();
		categorie.noun = "Senior";
		categorie.save();
		
		Categorie retrievedCategorie = Categorie.find("byNoun", "Senior").first();
		
		assertNotNull(retrievedCategorie);
		assertEquals(categorie, retrievedCategorie);
	}
}

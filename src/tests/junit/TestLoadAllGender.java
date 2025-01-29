package tests.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
import data.entities.Adresse;
import data.entities.Gender;
import data.entities.Person;
import data.fake.FakeDataGeneration;

class TestLoadAllGender {
	static final String SQL_QUERY = "SELECT * FROM GENDER";
	static final String DELETE_ALL_GENDER = "delete from gender;";
	static final String RESET_AI_GENDER = "alter table gender AUTO_INCREMENT = 1;";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FakeDataGeneration.deleteAndResetAll();
		FakeDataGeneration.createFakePerson();
	}

	@Test
	void testLoadOne() {
		DataManager dm = DataManager.getInstance();
		Person pers = dm.loadPersonbyID(2);
		System.out.println(pers.getGebdat().toString());
		assertNotNull(pers);
	}

	@Test
	void testPers() {
		DataManager dm = DataManager.getInstance();
		Person pers = dm.loadById(2, Person.class);
		System.out.println(pers.getGebdat().toString());
		assertNotNull(pers);
	}

	@Test
	void testAdr() {
		DataManager dm = DataManager.getInstance();
		Adresse adr = dm.loadById(2, Adresse.class);
		System.out.println(adr.getPlz());
		assertNotNull(adr);
	}

	@Test
	void testGen() {
		DataManager dm = DataManager.getInstance();
		Gender g = dm.loadById(2, Gender.class);
		System.out.println(g.getInfo());
		assertNotNull(g);
	}

}

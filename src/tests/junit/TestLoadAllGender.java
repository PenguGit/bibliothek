package tests.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
import data.entities.DataAdresse;
import data.entities.DataGender;
import data.entities.DataPerson;
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
		DataPerson pers = dm.loadPersonbyID(2);
		System.out.println(pers.getGebdat().toString());
		assertNotNull(pers);
	}

	@Test
	void testPers() {
		DataManager dm = DataManager.getInstance();
		DataPerson pers = dm.loadById(2, DataPerson.class);
		System.out.println(pers.getGebdat().toString());
		assertNotNull(pers);
	}

	@Test
	void testAdr() {
		DataManager dm = DataManager.getInstance();
		DataAdresse adr = dm.loadById(2, DataAdresse.class);
		System.out.println(adr.getPlz());
		assertNotNull(adr);
	}

	@Test
	void testGen() {
		DataManager dm = DataManager.getInstance();
		DataGender g = dm.loadById(2, DataGender.class);
		System.out.println(g.getInfo());
		assertNotNull(g);
	}

}

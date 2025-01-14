package tests.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
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
	}

	@Test
	void test() {
		DataManager dm = DataManager.getInstance();
		ArrayList<Gender> result = dm.getAllGenders();
		assertEquals(0, result.size());
		
		
		Gender g = new Gender("GG" , "info");
		g.save();
		result = dm.getAllGenders();
		assertEquals(1, result.size());
	}
	@Test
	void test2() {
		DataManager dm = DataManager.getInstance();
		ArrayList<Gender> result;
		
		Gender g = new Gender("GG" , "info");
		g.save();
		result = dm.getAllGenders();
		assertEquals(2, result.size());
	}
	
	@Test
	void test3() {
		DataManager dm = DataManager.getInstance();
		FakeDataGeneration.createFakePerson();
		Person pers = dm.loadPersonbyID(2);
		System.out.println(pers.getGebdat().toString());
		assertNotNull(pers);
	}
	

}

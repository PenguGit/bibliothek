package data.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
import data.entities.Gender;

class TestBef {

	final static String DELETE_ALL_GENDER = "delete from gender;";
	final static String RESET_AI_GENDER = "alter table gender AUTO_INCREMENT = 1;";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DataManager dm = DataManager.getInstance();
		// Alle Datensätze in der Tabelle Gender löschen
		dm.executeSQL(DELETE_ALL_GENDER);
		dm.executeSQL(RESET_AI_GENDER);
	}

	@Test
	void test() {
		Gender g = new Gender("G2", "Gender 2");
		g.save();
		assertEquals(1, g.getId());
	}

}

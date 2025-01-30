package tests.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
import data.pengugit.entities.Gender;

class TestGenderTest {
	static final String DELETE_ALL_GENDER = "delete from gender;";
	static final String RESET_AI_GENDER = "alter table gender AUTO_INCREMENT = 1;";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DataManager dm = DataManager.getInstance();
		// Alle Datensätze in der Tabelle Gender löschen
		dm.executeSQL(DELETE_ALL_GENDER);
		dm.executeSQL(RESET_AI_GENDER);
		
	}

	@Test
	void test() {
		Gender g = new Gender("G1", "Gender 1");
		assertEquals(0, g.getId());
		
		DataManager.getInstance().save(g);
		assertEquals(1, g.getId());
	}

}

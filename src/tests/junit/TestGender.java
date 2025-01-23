package tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import data.DataManager;
import data.entities.DataGender;

class TestGender {
	static final String SQL_QUERY = "SELECT * FROM GENDER";
	final String DELETE_ALL_GENDER = "delete from gender;";
	final String RESET_AI_GENDER = "alter table gender AUTO_INCREMENT = 1;";
	
	
	@Test
	void test() {
		DataManager dm = DataManager.getInstance();
		// Alle Datensätze in der Tabelle Gender löschen
		dm.executeSQL(DELETE_ALL_GENDER);
		dm.executeSQL(RESET_AI_GENDER);
		
		DataGender g = new DataGender("G1", "Gender 1");
		assertEquals(0, g.getId());
		
		dm.save(g);
		assertEquals(1, g.getId());
	}
	@Test
	void test1() {
		
		DataGender g = new DataGender("G2", "Gender 2");
		DataManager.getInstance().save(g);
		assertEquals(2, g.getId());
	}
	
	/**
	 * Testet Queries für die Tabelle Gender anhand von ResultSets
	 */
	@Test
	static void testQuery() {
		DataManager dm = DataManager.getInstance();
		ResultSet rs = dm.executeQuery(SQL_QUERY);
		if (rs == null) {
			System.out.println("Error executing query or no results found.");
			return;
		}
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("info");
				String name2 = rs.getString("kuerzel");
				System.out.println("ID: " + id + ", Info: " + name + ", Kuerzel: " + name2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}











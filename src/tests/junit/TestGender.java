package tests.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import data.DataManager;
import data.entities.Gender;

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
		
		Gender g = new Gender("G1", "Gender 1");
		assertEquals(0, g.getId());
		
		g.save();
		assertEquals(1, g.getId());
	}
	@Test
	void test1() {
		
		Gender g = new Gender("G2", "Gender 2");
		g.save();
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











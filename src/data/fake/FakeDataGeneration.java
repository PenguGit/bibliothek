package data.fake;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import data.DataManager;
import data.entities.DataAdresse;
import data.entities.DataGender;
import data.entities.DataPerson;

public class FakeDataGeneration {
	static final String DELETE_ALL = "delete from %s;";
	static final String RESET_AI = "alter table %s AUTO_INCREMENT = 1;";
	private static DataManager dm = DataManager.getInstance();

	public static void main(String[] args) {
		createFakePerson();
	}
	
	public static void deleteAny(String table) {
		dm.executeSQL(DELETE_ALL.formatted(table));
		dm.executeSQL(RESET_AI.formatted(table));
	}

	public static void createFakeGender() {
		deleteAny("Gender");
		DataGender g;
		for (int i = 1; i < 6; i++) {
			g = new DataGender("G" + i, "Gender " + i);
			dm.save(g);
		}
	}

	public static void deleteAndResetAll() {
		deleteAny("person");
		deleteAny("adresse");
		deleteAny("gender");
	}
	
	private static LocalDate makeRandomDate() {
	    long minDay = LocalDate.of(1940, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2018, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
	    return randomDate;
	}

	public static void createFakePerson() {
		deleteAny("person");
		createFakeGender();
		createFakeAdresse();
		ArrayList<DataGender> genders = dm.getAllGenders();
		ArrayList<DataAdresse> adressen = dm.getAllAdressen();
		Random rand = new Random();
		int anzahlGender = genders.size();
		int anzahlAdresse = adressen.size();
		DataPerson p;
		DataGender g;
		DataAdresse adr;
		for (int i = 0; i < anzahlAdresse; i++) {
			int index = rand.nextInt(anzahlGender);
			g = genders.get(index);
			adr = adressen.get(i);
			LocalDate date = makeRandomDate();
			p = new DataPerson("Name" + i, "Vorname" + i, date , g, adr);
			dm.save(p);
		}
	}

	public static void createFakeAdresse() {
		deleteAny("adresse");
		Random rand = new Random();
		DataAdresse adr;
		for (int i = 1; i < 6; i++) {
			adr = new DataAdresse(i + rand.nextInt(99990), "Stadt." + i, "Strasse" + i, "HausNr" + i);
			dm.save(adr);
		}
	}

}

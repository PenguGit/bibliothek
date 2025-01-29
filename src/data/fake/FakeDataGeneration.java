package data.fake;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import data.DataManager;
import data.entities.Adresse;
import data.entities.Gender;
import data.entities.Person;

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
		Gender g;
		for (int i = 1; i < 6; i++) {
			g = new Gender("G" + i, "Gender " + i);
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
		ArrayList<Gender> genders = dm.getAllGenders();
		ArrayList<Adresse> adressen = dm.getAllAdressen();
		Random rand = new Random();
		int anzahlGender = genders.size();
		int anzahlAdresse = adressen.size();
		Person p;
		Gender g;
		Adresse adr;
		for (int i = 0; i < anzahlAdresse; i++) {
			int index = rand.nextInt(anzahlGender);
			g = genders.get(index);
			adr = adressen.get(i);
			LocalDate date = makeRandomDate();
			p = new Person("Name" + i, "Vorname" + i, date , g, adr);
			dm.save(p);
		}
	}

	public static void createFakeAdresse() {
		deleteAny("adresse");
		Random rand = new Random();
		Adresse adr;
		for (int i = 1; i < 6; i++) {
			adr = new Adresse(i + rand.nextInt(99990), "Stadt." + i, "Strasse" + i, "HausNr" + i);
			dm.save(adr);
		}
	}

}

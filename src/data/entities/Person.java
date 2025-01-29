package data.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import data.DataManager;

/**
 * Repräsentiert die Entität Person
 */
public class Person extends DataAccessObject {

	private final String SQL_INSERT = "INSERT INTO Person (geburtsdatum, name, vorname,  Adresse_id, Gender_id) VALUES('%s', '%s', '%s', '%s', '%s')";
	private final String SQL_UPDATE = "UPDATE Person set geburtsdatum = '%s', name = '%s', vorname = '%s', Adresse_id = '%s', Gender_id = '%s' WHERE id = %d;";
	
	private String name;
	private String vorname;
	private LocalDate gebdat;
	private Gender gender;
	private Adresse adresse;
	
	
	/**
	 * Konstruktor für generische LoadbyID methode
	 * @param rs
	 * @throws SQLException
	 */
	public Person(ResultSet rs) throws SQLException {
		this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.vorname = rs.getString("vorname");
        this.gebdat = rs.getDate("geburtsdatum").toLocalDate();
        int genderId = rs.getInt("gender_id");
        int adresseId = rs.getInt("adresse_id");

        // Use DataManager to load related objects
        DataManager dm = DataManager.getInstance();
        this.gender = dm.loadById(genderId, Gender.class);
        this.adresse = dm.loadById(adresseId, Adresse.class);
    }

	/**
	 * Konstruiert eine Instanz der Klasse und
	 * Initialisiert die Felder name, vorname und gebdat.
	 * Die Felder gender und adresse bleiben null.
	 * @param name
	 * @param vorname
	 * @param gebdat
	 */
	public Person(String name, String vorname, LocalDate gebdat) {
		this(name, vorname, gebdat, null, null);
	}
	/**
	 * 
	 * @param name
	 * @param vorname
	 * @param gebdat
	 * @param gender
	 * @param adresse
	 */
	public Person(String name, String vorname, LocalDate gebdat, Gender gender, Adresse adresse) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.gebdat = gebdat;
		this.gender = gender;
		this.adresse = adresse;
	}
	
	@Override
	public String getSqlString() {
		return id > 0 ? SQL_UPDATE.formatted(Date.valueOf(gebdat).toString(), name, vorname, adresse.getId(), gender.getId()) : SQL_INSERT.formatted(Date.valueOf(gebdat).toString(), name, vorname, adresse.getId(), gender.getId());
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public LocalDate getGebdat() {
		return gebdat;
	}

	public void setGebdat(LocalDate gebdat) {
		this.gebdat = gebdat;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getSQL_INSERT() {
		return SQL_INSERT;
	}

	public String getSQL_UPDATE() {
		return SQL_UPDATE;
	}
	
}












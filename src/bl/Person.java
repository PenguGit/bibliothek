package bl;

import java.time.LocalDate;

/**
 * Repräsentiert die Entität Person
 */
public class Person extends DataTransferObject {

	private String name;
	private String vorname;
	private LocalDate gebdat;
	private Gender gender;
	private Adresse adresse;
	
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

}












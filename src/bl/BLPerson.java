package bl;

import java.time.LocalDate;

/**
 * Repräsentiert die Entität Person
 */
public class BLPerson extends DataTransferObject {

	private String name;
	private String vorname;
	private LocalDate gebdat;
	private BLGender gender;
	private BLAdresse adresse;
	
	/**
	 * Konstruiert eine Instanz der Klasse und
	 * Initialisiert die Felder name, vorname und gebdat.
	 * Die Felder gender und adresse bleiben null.
	 * @param name
	 * @param vorname
	 * @param gebdat
	 */
	public BLPerson(String name, String vorname, LocalDate gebdat) {
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
	public BLPerson(String name, String vorname, LocalDate gebdat, BLGender gender, BLAdresse adresse) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.gebdat = gebdat;
		this.gender = gender;
		this.adresse = adresse;
	}
	
	public BLPerson() {
		super();
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

	public BLGender getGender() {
		return gender;
	}

	public void setGender(BLGender gender) {
		this.gender = gender;
	}

	public BLAdresse getAdresse() {
		return adresse;
	}

	public void setAdresse(BLAdresse adresse) {
		this.adresse = adresse;
	}

}











